package lab3Java;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		
		System.out.println("Olá, seja bem vindo a nossa biblioteca!");
		int resposta = 1;
		while (resposta != 0) {
			System.out.println("-----------------------------------");
			System.out.println("|O que você deseja fazer agora? ");
			System.out.println("|Digite 1: Adicionar livro");
			System.out.println("|Digite 2: Buscar livro");
			System.out.println("|Digite 3: Mostrar livros");
			System.out.print("|Digite 0: Sair\n|");
			resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("-----------------------------------\n");
			
			System.out.print("\n");
			switch (resposta) {
				case 1:
					System.out.println("------- ADICIONANDO LIVRO -------");
					System.out.print("Digite o nome do autor: ");
			        String nomeAutor = sc.nextLine();	
			        
			        System.out.print("Digite a data de nascimento do autor: ");
			        String dataDeNascimento = sc.nextLine();
					
					Autor autor = new Autor(nomeAutor, dataDeNascimento);
					
					System.out.print("Digite o titulo do livro: ");
			        String tituloLivro = sc.nextLine();	
			        
			        System.out.print("Digite o ISBN: ");
			        String ISBN = sc.nextLine();
				
				    Livro livro = new Livro(tituloLivro, ISBN, autor);
			
				    biblioteca.adicionarLivro(livro);
				    break;
				
				case 2:
					System.out.println("---------- BUSCANDO LIVRO ----------");
					System.out.print("Digite o nome do livro que será buscado: ");
			        String tituloBuscado = sc.nextLine();
			        
					System.out.print("Digite o nome do autor do livro que será buscado: ");
			        String nomeAutorBuscado = sc.nextLine();
			        
					System.out.print("Digite o data do nascimento do autor do livro que será buscado: ");
			        String dataDeNascimentoBuscado = sc.nextLine();
			        
			       Autor autorBuscado = new Autor(nomeAutorBuscado, dataDeNascimentoBuscado);
			       
			        
				    Livro livroEncontrado = biblioteca.buscarLivro(tituloBuscado, autorBuscado);
				    if (livroEncontrado != null) {
				        System.out.println("O livro '" + livroEncontrado.getTitulo() + "' foi encontrado.");
				    } else {
				        System.out.println("O livro '" + tituloBuscado + "' não encontrado.");
				    }
				    break;
				    
				case 3:		
					System.out.println("--------- LISTANDO LIVROS ---------");
				    biblioteca.mostrarLivros();
				    break;
				    
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
