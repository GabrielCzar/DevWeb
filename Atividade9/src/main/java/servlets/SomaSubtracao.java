package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/soma_subtracao")
public class SomaSubtracao extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			try {
			Double x = Double.parseDouble(req.getParameter("x")),
					y = Double.parseDouble(req.getParameter("y"));
			Double soma = x + y,
					subtracao = x - y;
			
			HttpSession session = req.getSession();
			session.setAttribute("soma", soma);
			session.setAttribute("subtracao", subtracao);
			RequestDispatcher rd = req.getRequestDispatcher("somasub.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("error.html");
		}
	}
}
