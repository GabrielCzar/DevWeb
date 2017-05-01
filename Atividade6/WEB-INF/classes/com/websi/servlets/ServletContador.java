package com.websi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ServletContador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie [] cookies = req.getCookies();
		int contador = 0;
		Cookie cookie = null;
		for (Cookie c : cookies) {
			if (c.getName().equals("contador")) { 
				cookie = c;
				contador = Integer.parseInt(c.getValue());
			}
		}
		if (cookie == null) {
			cookie = new Cookie("contador", Integer.toString(contador));
			cookie.setMaxAge(60 * 60 * 24 * 30);
		}
		
		contador++;
		cookie.setValue(Integer.toString(contador));
		res.addCookie(cookie);
		res.getWriter().println(contador);
		RequestDispatcher rd = req.getRequestDispatcher("contador.html");
		rd.forward(req, res);
	}
	
}
