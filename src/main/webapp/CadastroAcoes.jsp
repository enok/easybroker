<%@page import="br.com.otavio.easybroker.to.EmpresaTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.:: Easybroker ::.</title>
<jsp:include page="templates/template.xhtml"></jsp:include>
</head>
<body>

    
    <form action="CadastroAcao" method="post">
      <table  style="width:70%;">
          <tr height="50px">
              <td colspan="2">Cadastro de nova a��o</td>
          </tr>
          <tr>
              <td>Codigo da A��o:</td>
              <td><input id="txtcod" name="txtcod" type="text" /></td>
          </tr>
          <tr>
              <td>Empresa:</td>
	              <td><select name="selemp">
			  
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