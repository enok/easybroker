package br.com.otavio.easybroker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.easybroker.bo.AcaoBO;
import br.com.otavio.easybroker.to.AcaoTO;

/**
 * Servlet implementation class CadastroAcao
 */
public class CadastroAcao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroAcao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = "";
		AcaoTO acaoTO = new AcaoTO();
		
		acaoTO.setCodigo(request.getParameter("txtcod"));
		acaoTO.getEmpresa().setCodigoemp(Integer.getInteger(request.getParameter("selemp")));
		
		AcaoBO acaoBO = new AcaoBO();
		
		try{
			acaoBO.inserir(acaoTO);
			mensagem = "Cadstrado com sucesso!";
		}catch (Exception e){
			mensagem = e.getMessage();
		}
		
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./CadastroAcao.jsp");
		dispatcher.forward(request, response);
	}
	
}