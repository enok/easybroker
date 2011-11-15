package br.com.otavio.easybroker.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.easybroker.bo.EmpresaBO;
import br.com.otavio.easybroker.to.EmpresaTO;

/**
 * Servlet implementation class ListEmpAcaoes
 */
public class ListEmpAcaoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmpAcaoes() {
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

		EmpresaBO emp =  new EmpresaBO();
		EmpresaTO to = new EmpresaTO();
		List listato = new ArrayList();
		
		try {
			listato = emp.listar(to);
			request.getSession().setAttribute("listaEmpresas", listato);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.sendRedirect("CadastroAcoes.jsp");
	}

}
