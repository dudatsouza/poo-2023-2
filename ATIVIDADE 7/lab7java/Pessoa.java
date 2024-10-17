package lab7java;

public class Pessoa {
	String nome; 
	String sexo; 
	String endereco; 
	String cpf; 
	String telefone; 
	String identidade; 

	public Pessoa (String nome, String sexo, String endereco, String cpf, String telefone, String identidade) {
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		this.identidade = identidade;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	
	public void imprimir() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Sexo: " + this.sexo);
		System.out.println("Endereco: " + this.endereco);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Identidade: " + this.identidade);
	}
}
