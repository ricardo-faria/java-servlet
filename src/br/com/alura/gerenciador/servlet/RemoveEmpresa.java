package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

/**
 * Servlet implementation class RemoveEmpresa
 */
//@WebServlet("/removeEmpresa")
public class RemoveEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		banco.remove(id);
		
//		RequestDispatcher dispatcher  = request.getRequestDispatcher("/listaEmpreses.jsp");
//		dispatcher.forward(request, response);
		response.sendRedirect("listaEmpresas");
	}

}
