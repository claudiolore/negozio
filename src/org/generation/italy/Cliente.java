package org.generation.italy;


public class Cliente {
	private String username, password, nome, cognome, tipologia;
	
	
	public Cliente(String username, String password, String nome, String cognome, String tipologia) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.tipologia = tipologia;
		
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
	
}
