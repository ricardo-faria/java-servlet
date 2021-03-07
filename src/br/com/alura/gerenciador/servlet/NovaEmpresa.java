package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;


//@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String nomeEmpresa = request.getParameter("nome");
		Date dataAbertura;
		try {
			dataAbertura = sdf.parse(request.getParameter("dataAbertura"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println("cadastrando nova empresa");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		empresa.setId(Banco.getNextId());
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		dispatcher.forward(request, response);
	
		response.sendRedirect("listaEmpresas");
	
	}

	

}
