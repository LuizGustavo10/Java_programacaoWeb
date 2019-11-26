$(document)
		.ready(

				function() {

					$("#papelJS").submit(function(event) {
						event.preventDefault();
						submeterPapel();
					});

					function submeterPapel() {
						var campo = {
							cargo : $("#nomeCargo").val()

						}
						$.ajax({
									type : "POST",
									contentType : "application/json",
									url : "/comapp/administrativo/papel/papelAdicionar",
									dataType : "json",
									data : JSON.stringify(campo),
									success : function(result) {

										if (result.id != null) {
											$("#mensagem")
													.html(
															"<div class=\"alert alert-success\" role=\"alert\"> Cadastro com sucesso</div>");
											campoNovo();
										} else {
											$("#mensagem")
													.html(
															"<div class=\"alert alert-danger\" role=\"alert\"> Algo deu errado</div>");
										}

									},
									error : function(e) {
										console.log(e);
										alert("ERROR: " + e);
									}

								})

					}

					function campoNovo() {
						$("#nomeCargo").val("");

					}

				}

		)