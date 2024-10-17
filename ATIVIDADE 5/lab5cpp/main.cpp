#include <iostream>
#include "FilaDeImpressao.hpp"

int main() {
    FilaDeImpressao fila;
    int escolha;

    do {
        std::cout << "\n------------------------\n";
        std::cout << "O que voce deseja fazer? \n";
        std::cout << "1. Adicionar Documento\n";
        std::cout << "2. Consultar Documento\n";
        std::cout << "3. Listar Documentos\n";
        std::cout << "4. Remover Documento\n";
        std::cout << "5. Alterar Documento\n";
        std::cout << "6. Sair\n";
        std::cout << "Escolha uma opção: ";
        std::cin >> escolha;

        switch (escolha) {
            case 1: {
                std::string nomeArquivo;
                int numPaginas, prioridade;
                std::cout << "Nome do Arquivo: ";
                std::cin >> nomeArquivo;
                std::cout << "Número de Páginas: ";
                std::cin >> numPaginas;
                std::cout << "Prioridade: ";
                std::cin >> prioridade;
                fila.adicionarDocumento(nomeArquivo, numPaginas, prioridade);
                break;
            }
            case 2: {
                int id;
                std::cout << "ID do Documento: ";
                std::cin >> id;
                fila.consultarDocumento(id);
                break;
            }
            case 3:
                fila.listarDocumentos();
                break;
            case 4: {
                int id;
                std::cout << "ID do Documento a ser removido: ";
                std::cin >> id;
                fila.removerDocumento(id);
                break;
            }
            case 5: {
                int id, novaPrioridade;
                std::string novoNomeArquivo;
                int novoNumPaginas;
                std::cout << "ID do Documento a ser alterado: ";
                std::cin >> id;
                std::cout << "Novo Nome do Arquivo: ";
                std::cin >> novoNomeArquivo;
                std::cout << "Novo Número de Páginas: ";
                std::cin >> novoNumPaginas;
                std::cout << "Nova Prioridade: ";
                std::cin >> novaPrioridade;
                fila.alterarDocumento(id, novoNomeArquivo, novoNumPaginas, novaPrioridade);
                break;
            }
            case 6:
                std::cout << "Encerrando o programa.\n";
                break;
            default:
                std::cout << "Opção inválida. Tente novamente.\n";
        }
    } while (escolha != 6);

    return 0;
}

