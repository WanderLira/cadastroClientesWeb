package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Cardapio;
import services.CardapioService;

public class RemoverCardapioServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CardapioService.remover(new Cardapio(new Long(id)));
		response.sendRedirect("listarCardapios");
	}

	
}
