<%@page import="br.com.otavio.easybroker.to.UsuarioTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.:: Easybroker ::.</title>
<jsp:include page="template.jsp"></jsp:include>
</head>
<body>
	<% if ( request.getSession().getAttribute("listaUsuarios") != null) {
      	List lista = (List) request.getSession().getAttribute("listaUsuarios");
	%>
	<form>
		<table  style="width:70%;">
			<tr height="50px">
            	<td colspan="2">Lista de usuários</td>
          	</tr>
          	<tr>
          		<td>Nome do Usuário:</td>
          		<td>Email:</td>
          		
          	</tr>
          	<% for(int i = 0; i < lista.size();i++){%>
          	<tr>
          		<td><%=((UsuarioTO)lista.get(i)).getNome()%></td>
          		<td><%=((UsuarioTO)lista.get(i)).getEmail()%></td>
          		<td><input type = "submit" value = "Excluir"/ id="<%((UsuarioTO)lista.get(i)).getCodigo();%>"  onclick="<% %>>"></td>
          		<td><input type = "submit" value = "Alterar" /></td>
          	</tr>
          	<%}%>	
		</table>
	</form>
	<%} %>
</body>
</html>