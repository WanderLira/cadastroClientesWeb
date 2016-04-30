package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Cardapio;
import services.CardapioService;

public class CadastroCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("login.html");
		}
		String id = request.getParameter("id");

		if (id != null) {
			Cardapio cardapio = CardapioService.buscarPorId(new Long(id));
			request.setAttribute("cardapio", cardapio);
		}

		request.getRequestDispatcher("cadastroCardapio.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String preco = request.getParameter("preco");

		Cardapio cardapio = new Cardapio();

		cardapio.setNome(nome);
		cardapio.setPreco(new Double(preco));

		if (id != null && !id.equals("")) {
			cardapio.setId(new Long(id));
			CardapioService.atualizar(cardapio);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			CardapioService.inserir(cardapio);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("listarCardapios").forward(request, response);

	}

}
