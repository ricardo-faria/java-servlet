package br.com.alura.gerenciador.servlet;

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


//@WebFilter("/api")
public class AutorizacaoFilter implements Filter {

	@Override
	public void destroy() {}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AutorizacaoFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String api = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usarioNaoLogado = sessao.getAttribute("usuario") == null;
		boolean eAcaoProtegida = !(api.equals("Login") || api.equals("LoginForm"));
		
		//verifica se usuario esta logado para acessar outras paginas
		if (eAcaoProtegida &&  usarioNaoLogado) {
			response.sendRedirect("api?acao=LoginForm");
			return;
		}
		
		
		chain.doFilter(request, response);
	}

}
