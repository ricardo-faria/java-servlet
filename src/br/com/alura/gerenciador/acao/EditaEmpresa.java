package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class EditaEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String idParam = request.getParameter("id");
		String nome = request.getParameter("nome");
		Date dataAbertura;
		try {
			dataAbertura = sdf.parse(request.getParameter("dataAbertura"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		int id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		banco.update(id, nome, dataAbertura);
		
		return "redirect:api?acao=ListaEmpresas";
	}
}
