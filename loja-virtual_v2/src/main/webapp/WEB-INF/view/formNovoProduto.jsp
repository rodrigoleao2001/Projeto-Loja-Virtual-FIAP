<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produto</title>
</head>
<body>

	Novo Produto:
	<br>
	<br>
	<form action="/produto" method="post">
		<label>Nome</label> <br> <input type=text name="nome"> <br>
		<label>Descri��o</label><br> <input type=text name="descricao"><br>
		<br> <label for="categoria">Categorias:</label> <br> <select
			name="categoria" id="categoria">
			<option value=1>Eletr�nicos</option>
			<option value=2>Games</option>
			<option value=3>Eletrodom�sticos</option>
			<option value=4>Alimentos</option>
			<option value=5>Brinquedos</option>
		</select> <br> <br> <br> 
		<input type="hidden" name="param" value="NovoProduto"><br> 
		<input type="submit" name="enviar" value="Enviar"> 
		<input type="reset" name="limpar" value="Limpar">
	</form>


</body>
</html>