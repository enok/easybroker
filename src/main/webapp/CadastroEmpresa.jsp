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
<form action="EmpresaServlet" method="post">
      <table  style="width:70%;">
          <tr height="50px">
              <td colspan="2">Cadastro de nova empresa</td>
          </tr>
          <tr>
              <td>Nome da Empresa:</td>
              <td><input id="txtemp" name="txtemp" type="text" /></td>
          </tr>
          <tr>
              <td>CNPJ:</td>
              <td><input id="txtcnpj" name="txtcnpj" type="text" /></td>
          </tr>
          <tr>
          		<td>Ramo:</td>
                <td><input id="txtramo" name="txtramo" type="text" /></td>
                                          
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