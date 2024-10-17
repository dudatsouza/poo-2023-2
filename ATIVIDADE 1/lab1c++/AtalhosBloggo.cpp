#include <iostream> 
#include <fstream>

using namespace std;

int alterando_para_html(string nome_arquivo_entrada, string nome_arquivo_saida) {
	ifstream inFile (nome_arquivo_entrada.c_str( ) );
	if(!inFile ) {
 		cerr << "Não foi possivel abrir o arquivo de entrada : " << nome_arquivo_entrada << " Saindo do programa! \n";
 		exit(-1);
	}
	
	ofstream outFile1 (nome_arquivo_saida.c_str( ) );
	if(!outFile1 ) {
		cerr << "Não foi possivel escrever no arquivo de saida : " << nome_arquivo_saida << " Saindo do programa! \n";
		exit(-1);
	}
	
	int cont_ast = 0;
	int cont_end = 0;
	char ch;
	while (inFile.get(ch) ) { 	
		if (ch == '*' && cont_ast == 0 && cont_end == 0) {
			cont_ast++;
			outFile1 << "<b>";
		} else if (ch == '*' && cont_ast == 1 && cont_end == 0) {
			cont_ast = 0;
			outFile1 << "</b>";
		} else if (ch == '_' && cont_ast == 0 && cont_end == 0) {
			cont_end++;
			outFile1 << "<i>";
		} else if (ch == '_' && cont_ast == 0 && cont_end == 1) {
			cont_end = 0;
			outFile1 << "</i>";
		} else {
			outFile1 << ch;
		}
	}
	
	inFile.close();
	outFile1.close();
	
	ifstream outFile2 (nome_arquivo_saida.c_str( ) );
	if(!outFile2 ) {
		cerr << "Não foi possivel ler no arquivo de saida : " << nome_arquivo_saida << " Saindo do programa! \n";
		exit(-1);
	}
	
	while (outFile2.get(ch) ) {
		cout << ch;
	}
	
	outFile2.close();	
}

int main () {
	cout << "Nome do arquivo de entrada: ";
	string nome_arquivo_entrada;
	cin >> nome_arquivo_entrada;
	
	cout << "Nome do arquivo de saida: ";
	string nome_arquivo_saida;
	cin >> nome_arquivo_saida;
	
	alterando_para_html(nome_arquivo_entrada, nome_arquivo_saida);
	
	return 0;	
}
