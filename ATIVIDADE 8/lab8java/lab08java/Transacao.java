package lab8java;

public class Transacao {
	private String data;
	private double valor;
	private String descricao;
	
	public Transacao (String data, double valor, String descricao) {
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void imprimir() {
		System.out.println("Data da transacao: " + this.data);
		System.out.println("Valor da transacao: R$" + this.valor);
		System.out.println("Descricao da transacao: " + this.descricao);
	}
	
}
