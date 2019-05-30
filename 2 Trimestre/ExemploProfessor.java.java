@Controller
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping("/categoria")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/categoriaPost");
		mv.addObject("categorias", repository.findAll());
		return mv;
	}

	@GetMapping("/addCategoria")
	public ModelAndView add(Categoria categoria) {

		ModelAndView mv = new ModelAndView("/categoriaAdd");
		mv.addObject("categoria", categoria);

		return mv;
	}

	@GetMapping("/editarCategoria/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		Optional<Categoria> categoria = repository.findById(id);
		Categoria e = categoria.get();

		return add(e);
	}

	@GetMapping("/removerCategoria/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		Optional<Categoria> categoria = repository.findById(id);
		Categoria e = categoria.get();
		repository.delete(e);

		return findAll();
	}

	@PostMapping("/salvarCategoria")
	public ModelAndView save(@Valid Categoria categoria, BindingResult result) {

		if(result.hasErrors()) {
			return add(categoria);
		}

		repository.saveAndFlush(categoria);

		return findAll();
	}
}
//-------------------------HTML CATEGORIA ADD----------------------------------------;
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width" />
	<title>Cadastro de Posts</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<strong>Cadastro de Categorias</strong>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" th:object="${categoria}" th:action="@{/salvarCategoria}" method="POST" style="margin: 10px">
				<div class="form-group">
 					<fieldset>
						<div class="form-group row">
							<div class="alert alert-danger" th:if="${#fields.hasAnyErrors()}">
								<div th:each="detailedError : ${#fields.detailedErrors()}">
									<span th:text="${detailedError.message}"></span>
								</div>
							</div>
						</div>
						<div class="form-group row">
						    <div class="col-md-1">
						        <input type="text" class="form-control input-sm" id="id" th:field="*{id}" readOnly="readonly"/>
						    </div>
						 </div>
						<div class="form-group row">
							<div class="col-md-4" th:classappend="${#fields.hasErrors('descricao')}? 'has-error'">
							    <label>Descrição</label>
							    <input type="text" class="form-control input-sm" th:field="*{descricao}" autofocus="autofocus" placeholder="Informe a Categoria do Post" maxlength="50"/>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="form-group row">
					<button type="submit" class="btn btn-sm btn-primary">Salvar</button>
					<a th:href="@{/categoria}" class="btn btn-sm btn-default">Cancelar</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
//-----------------------CATEGORIA POST -----------------------------------------
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width" />
	<title>Posts</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<strong>Categorias dos Posts</strong>
		</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-sm table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Descrição</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr th:each="categoria : ${categorias}">
							<td th:text="${categoria.id}"></td>
							<td th:text="${categoria.descricao}"></td>
							<td>
								<div class="btn-group pull-right">
							   		<a class="btn btn-sm btn-primary" th:href="@{/editarCategoria/{id}(id=${categoria.id})}" >Editar</a>
							   		<a class="delete btn btn-sm btn-danger" th:href="@{/removerCategoria/{id}(id=${categoria.id})}">Excluir</a>
							   </div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel-footer">
			<a class="btn btn-sm btn-success" th:href="@{/addCategoria/}" >Adicionar</a>
		</div>
	</div>
</body>
</html>
