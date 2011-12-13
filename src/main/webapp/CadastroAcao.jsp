<%@page import="java.util.ArrayList"%>
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


<form action="CadastroAcao" method="post">
      <table  style="width:70%;">
          <tr height="50px">
              <td colspan="2">Cadastro de nova ação</td>
          </tr>
          <tr>
              <td>Codigo da Ação:</td>
              <td><input id="txtcod" name="txtcod" type="text" /></td>
          </tr>
          <tr>
              <td>Empresa:</td>
	              <td><select name="selemp" onclick="submit('frmlista')">
				  <%List<EmpresaTO> lista = (ArrayList<EmpresaTO>) request.getSession().getAttribute("listaEmpresas");%>
	              <%if (lista != null) { for (int i = 0;i < lista.size(); i++){ %>		
	              		<option value=<%= ((EmpresaTO)lista.get(i)).getCodigoemp()%>><%= ((EmpresaTO)lista.get(i)).getNomeemp()%></option>
	  				</select>
	              <%}}%>
	              </td>
              
          </tr>
		 <tr>   
              <td id="btnCadastrar">
                  <input type="submit" value="Cadastrar"/>
              </td>             
          </tr>
         
      </table>
      </form>
</body>
</html>