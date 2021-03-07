package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;


//@WebServlet("/api")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String api = request.getParameter("acao");
		String link = null;
		System.out.println(api);
		
//		HttpSession sessao = request.getSession();
//		boolean usarioNaoLogado = sessao.getAttribute("usuario") == null;
//		boolean eAcaoProtegida = !(api.equals("Login") || api.equals("LoginForm"));
//		
//		//verifica se usuario esta logado para acessar outras paginas
//		if (eAcaoProtegida &&  usarioNaoLogado) {
//			response.sendRedirect("api?acao=LoginForm");
//			return;
//		}
		
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

}
