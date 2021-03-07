package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista= new ArrayList<Empresa>();
	private static List<Usuario> usuarios= new ArrayList<Usuario>();
	private static int idSequencial = 0;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setDataAbertura(new Date());
		empresa.setId(Banco.idSequencial++);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(new Date());
		empresa2.setId(Banco.idSequencial++);
		
		lista.add(empresa);
		lista.add(empresa2);
		
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("ricardo");
		usuario1.setSenha("123");
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("luiza");
		usuario2.setSenha("123");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
		
	}

	public List<Empresa> getEmpresas(){
		return lista;
	}

	public void remove(Integer id) {
		
		Iterator<Empresa> it =  lista.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = it.next();
			
			if (empresa.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa getById(int id) {
		Empresa empresaReturn = new Empresa();
		
		for(Empresa empresa : lista) {
			if (empresa.getId() == id) {
				empresaReturn = empresa;
			}
		}
		return empresaReturn;
		
	}

	public void update(int id, String nome, Date dataAbertura) {
		
		Iterator<Empresa> it =  lista.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = it.next();
			
			if (empresa.getId() == id) {
				empresa.setNome(nome);
				empresa.setDataAbertura(dataAbertura);
			}
		}
	}
	
	public static int getNextId() {
		return Banco.idSequencial++;
	}
	
	public Usuario verificaUsuario(String login, String senha) {
		for (Usuario u : usuarios) {
			if (u.isEqual(login, senha)) {
				return u;
			}
		}
		
		return null;
	}

}
