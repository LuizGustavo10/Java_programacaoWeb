$(document).ready(
			function(){
				
				$("#papelJS").submit(function(event){
					event.preventDefault();
					submeterPapel();
				});			
				
				function submeterPapel(){
					var valoresCampos={
							nome : $("#nomeCargo").val()
					}
// 					alert(valoresCampos.nome);
					//console.log(valoresCampos);
					$.ajax({
						type:"POST",
						contentType:"application/json",
						url: "/administrativo/papel/salvarPapeis",
						dataType:'json',
						data : JSON.stringify(valoresCampos),
						success: function(result){
							//alert("asd");
							if(result.id!=null){
								//alert("salvo com sucesso "+result.nome);
								$("#mensagem").html("<div class=\"alert alert-success\" role=\"alert\"> Opaa, deu certo! </div>");
								limparCampo();
							}else{
								//alert("Erro ao salvar "+result.nome);
								$("#mensagem").html("Erro ao salvar");
							}
						},
						error : function(e){
							alert("ERROR: "+e.nome);
						}
					})
				}
				
				function limparCampo(){
					$("#nomeCargo").val("");
				}
			})	