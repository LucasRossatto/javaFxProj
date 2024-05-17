package model;

public class Fly {
	
	private int id;
	
	private String username;
	private String password;
	
	private String nome;
	private String inicioVoo;
	private String FimVoo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInicioVoo() {
		return inicioVoo;
	}
	public void setInicioVoo(String inicioVoo) {
		this.inicioVoo = inicioVoo;
	}
	public String getFimVoo() {
		return FimVoo;
	}
	public void setFimVoo(String fimVoo) {
		FimVoo = fimVoo;
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

	
	
	
}
