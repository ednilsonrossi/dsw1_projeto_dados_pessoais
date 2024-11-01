package br.edu.ifsp.dsw1.comsingleton;

import java.util.LinkedList;
import java.util.List;

public class Dados {
	private static Dados instance = null;
	
	private List<Pessoa> pessoas;
	
	private Dados() {
		pessoas = new LinkedList<Pessoa>();
	}
	
	public static Dados getInstance() {
		if (instance == null) {
			instance = new Dados();
		}
		return instance;
	}
	
	public void insert(Pessoa p) {
		if (p != null) {
			pessoas.add(p);
		}
	}
	
	public List<Pessoa> getAll() {
		return pessoas;
	}
}
