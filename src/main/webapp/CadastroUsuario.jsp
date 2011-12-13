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
	<form action="UsuarioServlet" method="post">
      <table  style="width:70%;">
          <tr height="50px">
              <td colspan="2">Cadastro de usuário</td>
          </tr>
          <tr>
              <td>Nome:</td>
              <td><input id="txtnome" name="txtnome" type="text" /></td>
          </tr>
          <tr>
              <td>CPF:</td>
              <td><input id="txtcpf" name="txtcpf" type="text" /></td>
          </tr>
          <tr>
          	<td>Sexo:</td>
            <td>
              	  <input id="rdbmasc" checked="checked" name="R1" type="radio" value="Masculino" />Masculino
                  <input id="rdbfemi" checked="checked" name="R1" type="radio" value="Feminino" />Feminino
            </td>                             
          </tr>
          <tr>
          		<td>Email:</td>
                <td><input id="email" name="email" type="text" /></td>
                                          
          </tr>

          <tr>
          	   <td>Senha:</td>
              <td><input id="txtsenha" name="txtsenha" type="password" /></td>
          </tr>
          <tr>
              <td>Confirmar Senha:</td>
              <td><input id="txtsenhaconf" name="txtsenhaconf" type="password" /></td>                        
          </tr>
          <tr>   
              <td id="btnCadastrar">
                  <input type="submit" value="Cadastrar"/>
              </td>             
          </tr>
      </table>
      </form>
      <% if ( request.getAttribute("mensagem") != null && !"".equals(request.getAttribute("mensagem"))) { %>
      	<script type="text/javascript">alert('<%=request.getAttribute("mensagem")%>')</script>
      	<%} %>
      	
 </body>
</html>