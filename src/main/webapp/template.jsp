<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>.:: EasyBroker ::.</title>
<link href="publico/css/stylle.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="menu">
		<div class="logo"></div>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="sobre.jsp">Sobre</a></li>
			<% if ( session.getAttribute("nomeUsuario") == null ) { %>
				<li><a href="CadastroUsuario.jsp">Cadastro</a></li>
			<% } %>	
			<% if ( session.getAttribute("nomeUsuario") != null ) { %>
				<li><a href="ListaAcoes.jsp">Ações</a></li>
			<% } %>	
			<% if ( session.getAttribute("nomeUsuario") != null ) { %>
				<li><a href="Carteira.jsp">Carteira</a></li>
			<% } %>
			<% if ( session.getAttribute("admin") != null ) { %>
				<li><a href="ListaUsuarios.jsp">Usuários</a></li>
			<% } %>
			<% if ( session.getAttribute("nomeUsuario") != null ) { %>
				<li><a href="ListaEmpresa">Empresa</a></li>
			<% } %>
			<% if ( session.getAttribute("nomeUsuario") != null ) { %>
				<li><a href="ListaUsuario">Usuarios</a></li>
			<% } %>
				
			
		</ul>
	</div>
	<form action="LoginServlet" name="login" method="post" >
		<% if ( session.getAttribute("nomeUsuario") == null ) { %>
				<div class="login">
					Email: 
					<input type="text" name="txtemail" id="txtemail" size="20"/>
					Senha:
					<input type="password" name="txtsenha" id="txtsenha" size="5"/>
					<input type="submit"  value="Entrar" id="login"/>
				</div>
	  	<%} else { %>
	  	<div class="login">
	  		Bem Vindo <%= session.getAttribute("nomeUsuario") %>!
<!--	  		<input type="submit" accept="<%request.setAttribute("logout", "true"); %>" onclick="<%request.setAttribute("logout", "true"); %>" value="Sair" id="logout"/>-->
	  		<a href="./logout.jsp" >Sair</a>
	  		
		</div>
	  	<%}%>
	  	<% if ( request.getAttribute("mensagem") != null && !"".equals(request.getAttribute("mensagem"))) { %>
      		<script type="text/javascript">alert('<%=request.getAttribute("mensagem")%>')</script>
      	<%} %>
    </form>
</body>
</html>