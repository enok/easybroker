package br.com.otavio.easybroker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.easybroker.bo.AcaoUserBO;
import br.com.otavio.easybroker.to.AcaoUserTO;

/**
 * Servlet implementation class CarteiraServlet
 */
public class CarteiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarteiraServlet() {
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
		AcaoUserTO acao = (AcaoUserTO)request.getAttribute("acao");
		AcaoUserBO acaoBO = new AcaoUserBO();
		try {
			//List<AcaoUserTO> acoes = acaoBO.listarTodos(acao);
			//request.setAttribute("acoes", acoes);
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./AcoesUsuario.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("./ListaAcoes.jsp");
	}

}
