package simuladoProva;
import java.util.ArrayList;
import java.util.List;

public class Cliente {	
	private String nome;
	private String endereco;
	private int numTelefone;  
	private List<Pedido> pedidos;

	public Cliente(String nome, String endereco, int numTelefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.numTelefone = numTelefone;
	    pedidos = new ArrayList<Pedido>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getNumTelefone() {
		return numTelefone;
	}
	public void setNumTelefone(int numTelefone) {
		this.numTelefone = numTelefone;
	}

	public Cliente() {
	    pedidos = new ArrayList<Pedido>();
	}
	
	public void cadastrarPedido(int numPedido, String descricao, double valorTotal) {
		Pedido pedido = new Pedido(numPedido, descricao, valorTotal);
	    pedidos.add(pedido);
	}
	
	public void mostrarPedidosPorCliente() {
		if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("Não há pedidos.");
        } else {
		    for (Pedido pedido : pedidos) {
		        System.out.println("Numero do Pedido: " + pedido.getNumPedido());
		        System.out.println("Descricao: " + pedido.getDecricao());
		        System.out.println("Valor Total: " + pedido.getValorTotal());
		        System.out.println();
		    }
        }
	}
	
	public void mostrarClientes() {
		int quantPedidos = 0;
		System.out.println("Nome: " + this.nome);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Numero de Telefone: " + this.numTelefone);
		if (pedidos.isEmpty()) {
            System.out.println("Este cliente não há pedidos.");
        } else {
		    for (Pedido pedido : pedidos) {
		        quantPedidos++;
		    }
        }
        System.out.println("Foram feitos " + quantPedidos + " pedidos por este cliente\n");
	}
	
	
	public void mostrarPedidos() {
		System.out.println("Nome: " + this.nome);
		if (pedidos.isEmpty()) {
            System.out.println("Este cliente não há pedidos.");
        } else {
        	for (Pedido pedido : pedidos) {
		        System.out.println("Numero do Pedido: " + pedido.getNumPedido());
		        System.out.println("Descricao: " + pedido.getDecricao());
		        System.out.println("Valor Total: " + pedido.getValorTotal());
		        System.out.println();
		    }
        }
	}
	
	public double calcularValorTotal() {
		double valorTotalPorCliente = 0;
		System.out.println("Nome: " + this.nome);
		if (pedidos.isEmpty()) {
            System.out.println("Este cliente não há pedidos.");
        } else {
        	for (Pedido pedido : pedidos) {
        		valorTotalPorCliente += pedido.getValorTotal();
		    }
        }
		return valorTotalPorCliente;
	}	
	
	
}

