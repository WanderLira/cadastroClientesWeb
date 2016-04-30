package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.CardapioService;
import entities.Cardapio;

public class ListarCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("login.html");
			return;
		}
		
		List<Cardapio> cardapios = CardapioService.listar();
		request.setAttribute("cardapios", cardapios);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCardapios.jsp");
		requestDispatcher.forward(request, response);

	}

}
