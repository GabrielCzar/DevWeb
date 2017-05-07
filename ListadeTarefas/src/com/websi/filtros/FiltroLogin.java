package com.websi.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*") 
public class FiltroLogin implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		String path = ((HttpServletRequest) req).getRequestURI();
		
		if (path.contains("login") || (session != null && session.getAttribute("usuario") != null) 
				|| path.contains("/resources/")) 
			chain.doFilter(req, res);
		else 
			((HttpServletResponse) res).sendRedirect("form_login.html");
		
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
