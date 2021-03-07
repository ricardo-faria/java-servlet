package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		banco.remove(id);
		
		return "redirect:api?acao=ListaEmpresas";
	}
}
