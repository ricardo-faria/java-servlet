package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;


//@WebServlet("/api")
public class ControladorFilter implements Filter{
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response= (HttpServletResponse) servletResponse;
		
		String api = request.getParameter("acao");
		String link = null;
		System.out.println(api);
		
		String classeStr = "br.com.alura.gerenciador.acao." + api;
		
		//cria a classe dinamicamente atraves de reflection
		try {
			Class classe = Class.forName(classeStr);
			Acao acao = (Acao) classe.newInstance();
			link = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = link.split(":");
		
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}
	

	@Override
	public void destroy() {	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
