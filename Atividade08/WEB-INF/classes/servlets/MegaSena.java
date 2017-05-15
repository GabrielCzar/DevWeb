package servlets;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mega")
public class MegaSena extends HttpServlet{
	private ArrayList<Integer> numeros;
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException ,java.io.IOException {
		numeros = new ArrayList<Integer>();
		Random random = new Random();
		while (numeros.size() < 6) {
			int x = random.nextInt(60) + 1;
			if (!numeros.contains(x))
				numeros.add(x);
		}
		HttpSession session = req.getSession();
		session.setAttribute("numeros", numeros);
		RequestDispatcher rd = req.getRequestDispatcher("megasena.jsp");
		rd.forward(req, res);
	};
}
