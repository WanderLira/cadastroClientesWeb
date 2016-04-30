<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,entities.Cardapio" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de cardápios</title>
</head>
<body>
    <a href='logout'>Sair</a>
	<a href='cadastroCardapio'>Novo</a>
	<br />
		<% 
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem != null){
		%>		
			<script>
				alert('<%=mensagem%>');
			</script>
		<% 		
			}
		%>
	<table>
		<tr>
			<td>Nome</td>
			<td>Preço</td>
			<td>Ações</td>
		</tr>
		<%
		   List<Cardapio> cardapios = (List<Cardapio>) request.getAttribute("cardapios"); 
		%>
		<%for (Cardapio cardapio : cardapios) {%>
			
		<tr>
			<td><%=cardapio.getNome()%></td>
			<td><%=cardapio.getPreco()%></td>
			<td>
				<a href='removerCardapio?id=<%=cardapio.getId()%>'>remover</a>
				<a href='cadastroCardapio?id=<%=cardapio.getId()%>'>editar</a>
			</td>
		</tr>
		<%}%>

	</table>


</body>
</html>