package com.websi.filtro;

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

/* @WebFilter("/*")
public class ServiceFiltro implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) sreq;
		HttpServletResponse res = (HttpServletResponse) sres;
		String path = req.getRequestURI();
		
		if (path.contains("mvc" ) || path.contains("/resources/")) chain.doFilter(sreq, sres);
		 else res.sendRedirect(req.getContextPath() + "/mvc?logica=ReadServices");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
}
*/