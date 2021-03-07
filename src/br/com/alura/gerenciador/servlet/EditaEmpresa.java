package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

//@WebServlet("/editaEmpresa")
public class EditaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		int id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		Empresa empresa = banco.getById(id);
		
		request.setAttribute("empresa", empresa);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/exibeEmpresa.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String idParam = req.getParameter("id");
		String nome = req.getParameter("nome");
		Date dataAbertura;
		try {
			dataAbertura = sdf.parse(req.getParameter("dataAbertura"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		int id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		banco.update(id, nome, dataAbertura);
		
		resp.sendRedirect("listaEmpresas");
	}
 
	
}
