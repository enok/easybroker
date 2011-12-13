<%@page import="br.com.otavio.easybroker.to.EmpresaTO"%>
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
	<% if ( request.getSession().getAttribute("listaEmpresas") != null) {
      	List lista = (List) request.getSession().getAttribute("listaEmpresas");
    %>
	<form>
		<table  style="width:70%;">
			<tr height="50px">
            	<td colspan="2">Lista de empresas</td>
          	</tr>
          	<tr>
          		<td>Nome da Empresa:</td>
          		<td>CNPJ:</td>
          		<td>Ramo:</td>
          	</tr>
          	<% for(int i = 0; i < lista.size();i++){%>
          	<tr>
          		<td><%=((EmpresaTO)lista.get(i)).getNomeemp()%></td>
          		<td><%=((EmpresaTO)lista.get(i)).getCnpj()%></td>
          		<td><%=((EmpresaTO)lista.get(i)).getRamo()%></td>
          		<td><input type = "submit" value = "Excluir"/></td>
          		<td><input type = "submit" value = "Alterar"/></td>
          	</tr>
          	<%}%>	
		</table>
	</form>
	<%} %>
</body>
</html>