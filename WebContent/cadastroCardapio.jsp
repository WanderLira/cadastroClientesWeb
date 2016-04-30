<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Cardapio"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de cardápio</title>
</head>
<body>
     
    <% 
    	Cardapio cardapio = (Cardapio) request.getAttribute("cardapio");
    %> 
	<br />
	<form method='post' action='cadastroCardapio'>
	
	    <input type='hidden' name='id' value="<%=cardapio == null ? "" : cardapio.getId()%>" />
		
		<table>
			
			<tr>
				<td>Nome</td>
				<td><input type='text' name='nome' value="<%=cardapio == null ? "" : cardapio.getNome()%>" /></td>
			</tr>

			<tr>
				<td>Preço</td>
				<td><input type='text' name='preco' value="<%=cardapio == null ? "" : cardapio.getPreco()%>"/></td>
			</tr>

			<tr>
				<td><input type='submit' value='Salvar' /></td>
				<td></td>
			</tr>

		</table>

	</form>
</body>
</html>