package br.edu.ifsp.dsw1.comsingleton;

public class Pessoa {
	private String nome;
	private String email;
	private String endereco;
	private int numero;
	private String cidade;
	private String cep;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String email, String endereco, int numero, String cidade, String cep) {
		this();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.numero = numero;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
