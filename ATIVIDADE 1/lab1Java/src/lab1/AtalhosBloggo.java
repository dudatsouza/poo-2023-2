package lab1;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AtalhosBloggo {
	
	public static void alterandoParaHtml(String nomeArquivoEntrada, String nomeArquivoSaida) {
		Scanner scanner = new Scanner(System.in);
		try {
			FileReader inFile = new FileReader(nomeArquivoEntrada);
			FileWriter outFile = new FileWriter(nomeArquivoSaida);

			int cont_ast = 0;
			int cont_end = 0;
			int ch;
			
			try {
				while ((ch = inFile.read()) != -1) {
					char ch1 = (char) ch;
					if (ch1 == '*' && cont_ast == 0 && cont_end == 0) {
						cont_ast++;
						outFile.write("<b>");
					} else if (ch1 == '*' && cont_ast == 1 && cont_end == 0) {
						cont_ast = 0;
						outFile.write("</b>");
					} else if (ch1 == '_' && cont_ast == 0 && cont_end == 0) {
						cont_end++;
						outFile.write("<i>");
					} else if (ch1 == '_' && cont_ast == 0 && cont_end == 1) {
						cont_end = 0;
						outFile.write("</i>");
					} else {
						outFile.write(ch);
					}
				}
				
				inFile.close();
				outFile.close();
				scanner.close();

				FileReader outFile1 = new FileReader(nomeArquivoSaida);
				try {
					while ((ch = outFile1.read()) != -1) {
						System.out.print((char) ch);
					}
				} catch (IOException e) {
			            System.err.println("Erro ao criar ler o arquivo de saida!");
				}

				outFile1.close();
				
			} catch (IOException e) {
				System.err.println("Não foi possível abrir o arquivo de entrada ou de saida!! Saindo do programa!");
				scanner.close();
				return;
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler ou escrever no arquivo!");
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nome do arquivo de entrada: ");
		String nomeArquivoEntrada = scanner.nextLine();

		System.out.print("Nome do arquivo de saída: ");
		String nomeArquivoSaida = scanner.nextLine();
		
		alterandoParaHtml(nomeArquivoEntrada, nomeArquivoSaida);		

		scanner.close();
	}
}

