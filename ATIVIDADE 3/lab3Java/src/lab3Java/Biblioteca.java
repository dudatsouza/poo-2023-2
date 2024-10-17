package lab3Java;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Livro> livros;

	public Biblioteca() {
	    livros = new ArrayList<>();
	}
	
	public void adicionarLivro(Livro livro) {
	    livros.add(livro);
	    System.out.println("Livro adicionado");
	}
	
	public Livro buscarLivro(String titulo, Autor autorBuscado) {
	    for (Livro livro : livros) {
	        if ((livro.getTitulo().equalsIgnoreCase(titulo)) && (livro.getAutor().getNome().equalsIgnoreCase(autorBuscado.getNome()) && (livro.getAutor().getDataDeNascimento().equalsIgnoreCase(autorBuscado.getDataDeNascimento())))) {
	            return livro;
	        }
	    }
	    return null; 
	}
	
	public void mostrarLivros() {
		if (livros.isEmpty()) {
            System.out.println("Não há livros na biblioteca.");
        } else {
		    for (Livro livro : livros) {
		        System.out.println("Título: " + livro.getTitulo());
		        System.out.println("ISBN: " + livro.getISBN());
		        System.out.println("Autor: " + livro.getAutor().getNome());
		        System.out.println();
		    }
        }
	}
}
