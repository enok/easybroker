package br.com.otavio.easybroker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.easybroker.bo.EmpresaBO;
import br.com.otavio.easybroker.to.EmpresaTO;

/**
 * Servlet implementation class EmpresaServlet
 */
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpresaServlet() {
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
		
		EmpresaTO empresaTO = new EmpresaTO();
		
		empresaTO.setNomeemp(request.getParameter("txtemp"));
		empresaTO.setCnpj(request.getParameter("txtcnpj"));
		empresaTO.setRamo(request.getParameter("txtramo"));
		
		EmpresaBO empresaBO = new EmpresaBO();
		
		try{
			empresaBO.inserir(empresaTO);
			mensagem = "Cadstrado com sucesso!";
		}catch (Exception e){
			mensagem = e.getMessage();
		}
		
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./CadastroEmpresa.jsp");
		dispatcher.forward(request, response);
	
}
}