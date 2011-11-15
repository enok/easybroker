package br.com.otavio.easybroker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.easybroker.bo.UsuarioBO;
import br.com.otavio.easybroker.to.UsuarioTO;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
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
		
		UsuarioTO usuarioTO = new UsuarioTO();
		
		usuarioTO.setNome(request.getParameter("txtnome"));
		usuarioTO.setCpf(request.getParameter("txtcpf"));
		usuarioTO.setSexo(request.getParameter("R1"));
		usuarioTO.setEmail(request.getParameter("email"));
		usuarioTO.setSenha(request.getParameter("txtsenha"));
		
		
		UsuarioBO usuarioBO = new UsuarioBO();
		
		try {
			usuarioBO.inserir(usuarioTO);
			mensagem = "Cadastrado com sucesso!";
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./CadastroUsuario.jsp");
		dispatcher.forward(request, response);
		
	}

}
