package com.websi.servlets;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/mega")
public class MegaSena extends HttpServlet{
	private ArrayList<Integer> numeros;
	private static final long serialVersionUID = 1L;
	
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws javax.servlet.ServletException ,java.io.IOException {
		numeros = new ArrayList<>();
		Random random = new Random();
		while (numeros.size() < 6) {
			int x = random.nextInt(60) + 1;
			if (!numeros.contains(x))
				numeros.add(x);
		}
		res.getWriter().print("Numeros: ");
		for (Integer value : numeros) 
			res.getWriter().print(value + " ");
	};
}
