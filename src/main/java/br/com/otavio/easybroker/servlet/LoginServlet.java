package br.com.otavio.easybroker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.easybroker.bo.LoginBO;
import br.com.otavio.easybroker.to.UsuarioTO;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = "";
		String admin = "";
		UsuarioTO usuarioTO = null;
		LoginBO loginBO = new LoginBO();
		String email = request.getParameter("txtemail");
		String senha = request.getParameter("txtsenha");
		
		if (email != null && !email.isEmpty() && senha != null && !senha.isEmpty()){
			try {
				usuarioTO = loginBO.login(email, senha);
			} catch (Exception e) {
				mensagem = e.getMessage();
			}
			if (usuarioTO != null && usuarioTO.getNome() != null && !usuarioTO.getNome().isEmpty()){
				request.getSession().setAttribute("nomeUsuario", usuarioTO.getNome());
				admin = usuarioTO.getAdmin();
				//request.setAttribute("nomeUsuario", usuarioTO.getNome());
			} else {
				mensagem = "Usu�rio e senha n�o conferem!";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./AcoesUsuario.jsp");
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("admin", admin);
		dispatcher.forward(request, response);
		
	}

}