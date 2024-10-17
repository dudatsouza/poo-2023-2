package simuladoProva;

public class Pedido {	
	private int numPedido; 
	private String decricao;
	private double valorTotal; 

	public Pedido(int numPedido, String descricao, double valorTotal) {
        this.numPedido = numPedido;
        this.decricao = descricao;
        this.valorTotal = valorTotal;
	}

	public int getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public String getDecricao() {
		return decricao;
	}
	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	
	
}
