package br.com.otavio.easybroker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.easybroker.bo.AcaoBO;
import br.com.otavio.easybroker.to.AcaoTO;
import br.com.otavio.easybroker.to.AcaoUserTO;
import br.com.otavio.easybroker.to.UsuarioTO;

/**
 * Servlet implementation class AcoesServlet
 */
public class AcoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcoesServlet() {
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

		AcaoTO acao = (AcaoTO)request.getAttribute("acao");
		if (acao != null){
			
			Integer quantidadeAcao = Integer.parseInt(request.getParameter("qtAcao"+acao.getAcao()));
			if (quantidadeAcao == null || quantidadeAcao == 0){
				quantidadeAcao = 100;
			}
			AcaoUserTO acaoUser = new AcaoUserTO();
			UsuarioTO usuario = (UsuarioTO) request.getSession().getAttribute("nomeUsuario");
			/*acaoUser.setAcao(acao);
			acaoUser.setUsuario(usuario);
			acaoUser.setNr_acoes(quantidadeAcao);
			AcaoUserBO acaoUserBO = new AcaoUserBO();
			
			request.setAttribute("mensagem","Adicionado com sucesso!");
			try {
				acaoUserBO.inserir(acaoUser);
			} catch (Exception e) {
				request.setAttribute("mensagem", e.getMessage());
				e.printStackTrace();
			} finally {
				acao = null;
				request.setAttribute("acao", null);
			}*/
			
		} else {
			
			AcaoBO acaoBO = new AcaoBO();
			try {
				//List<AcaoTO> acoes = acaoBO.listarTodos(acao);
				//request.setAttribute("acoes", acoes);
			} catch (Exception e) {
				System.out.println("Erro: "+ e.getMessage());
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("./ListaAcoes.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("./ListaAcoes.jsp");
		}
		
	}

}
