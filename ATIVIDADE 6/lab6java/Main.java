package simuladoProva;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();	
			
		System.out.println("Olá, seja bem vindo a nossa lanchonete!");
		int resposta = 1;
		while (resposta != 0) {
			System.out.println("-----------------------------------");
			System.out.println("|O que você deseja fazer agora? ");
			System.out.println("|Digite 1: Adicionar cliente");
			System.out.println("|Digite 2: Adicionar pedido");
			System.out.println("|Digite 3: Mostrar a lista todos os pedidos por cliente");
			System.out.println("|Digite 4: Mostrar a lista de todos os clientes");
			System.out.println("|Digite 5: Mostrar a lista de todos os pedidos dos clientes cadastrados");
			System.out.println("|Digite 6: Mostar o valor total gasto por um cliente");
			System.out.print("|Digite 0: Sair\n|");
			resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("-----------------------------------\n");
			
			System.out.print("\n");
			switch (resposta) {
				case 1: {
					System.out.println("------- ADICIONANDO CLIENTE -------");
					System.out.print("Digite o nome do cliente: ");
			        String nomeCliente = sc.nextLine();	

					System.out.print("Digite o endereco do cliente: ");
			        String endereco = sc.nextLine();
			        
			        System.out.print("Digite o numero do telefone do cliente (somente numeros): ");
			        int numTelefone = sc.nextInt();
					
					Cliente cliente = new Cliente(nomeCliente, endereco, numTelefone);
					clientes.add(cliente);
					
					System.out.println("Cliente adicionado com sucesso!");
					
				    break;
				}
				
				case 2: {
					System.out.println("------- ADICIONANDO PEDIDO -------");
					System.out.print("Digite o nome do cliente que será adicionado um pedido a ele: ");
			        String nomeCliente = sc.nextLine();	
			        int aux = 0;
			       
				    for (Cliente cliente : clientes) {
				    	if ((cliente.getNome().equals(nomeCliente))) {
							System.out.print("Digite o numero do pedido: ");
					        int numPedido = sc.nextInt();	
					        sc.nextLine();

							System.out.print("Digite o descricao do cliente: ");
					        String descricao = sc.nextLine();
					        
					        System.out.print("Digite o valor total deste pedido: ");
					        double valorTotal = sc.nextDouble();
							
					        cliente.cadastrarPedido(numPedido, descricao, valorTotal);
					        
							System.out.println("Pedido adicionado com sucesso!");
							aux++;
				    		break;
					    }
				    }
				    
				    if (aux == 0) {
						System.out.println("Cliente nao encontrado");				    	
				    }
			        
				    break;
				}
				
				case 3: {
					System.out.print("Digite o nome do cliente que será adicionado um pedido a ele: ");
			        String nomeCliente = sc.nextLine();
			        int aux = 0;
			       
				    for (Cliente cliente : clientes) {
				    	if ((cliente.getNome().equals(nomeCliente))) {
				    		cliente.mostrarPedidosPorCliente();
				    		aux++;
				    		break;
					    }
				    }
				    
				    if (aux == 0) {
						System.out.println("Cliente nao encontrado");				    	
				    }
				    
				    break;
				}
				    
				case 4:	 { 				       
				    for (Cliente cliente : clientes) {
				    	cliente.mostrarClientes();
				    }
				    
				    break;
				}
				
				case 5:	 { 	
					System.out.print("Digite o nome do cliente que será adicionado um pedido a ele: ");
			        String nomeCliente = sc.nextLine();	
			        int aux = 0;
			       
				    for (Cliente cliente : clientes) {
				    	if ((cliente.getNome().equals(nomeCliente))) {
				    		cliente.mostrarPedidos();
				    		aux++;
				    		break;
					    }
				    }
				    
				    if (aux == 0) {
						System.out.println("Cliente nao encontrado");				    	
				    }
				    
				    break;
				}
				
				case 6:	 { 	
					System.out.print("Digite o nome do cliente que será adicionado um pedido a ele: ");
			        String nomeCliente = sc.nextLine();
			        int aux = 0;
			       
				    for (Cliente cliente : clientes) {
				    	if ((cliente.getNome().equals(nomeCliente))) {
				    		System.out.println("O valor total gasto por " + nomeCliente + " é de R$" +cliente.calcularValorTotal());
				    		aux++;
				    		break;
					    }
				    }
				    
				    if (aux == 0) {
						System.out.println("Cliente nao encontrado");				    	
				    }


				    break;
				}
				
				case 0: 
					System.out.println("Muito obrigado por usar nossos servicos! ");
					System.exit(0);
					break;
			}

		    System.out.println("-----------------------------------\n");
		}
	    
	    sc.close();
	}

}
