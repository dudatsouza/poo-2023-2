#include <iostream>
#include "ClienteBanco.hpp"
#include "PilhaProvas.hpp"
#include "FilaBanco.hpp"

using namespace std;

void filaBanco();
void pilhaProva();
void limpaConsole();

int main() {
    int resposta;
    do{
        cout << "\nQual exercicio voce deseja testar?" << endl;
        cout << "1 - Fila do Banco" << endl;
        cout << "2 - Pilha de Provas" << endl;
        cout << "3 - Sair" << endl;
        cin >> resposta;

        switch(resposta){
            case 1:
                filaBanco();
                break;
            case 2:
                pilhaProva();
                break;
            case 3:
                limpaConsole();
                cout << "Saindo..." << endl;
                break;
            default:
                cout << "Opcao invalida" << endl;
        }
    } while(resposta != 3);

    return 0;
}

void pilhaProva() {
    PilhaProvas pilha;
    int opcao;
    do {
        cout << "\n---PILHA DE PROVAS---";
        cout << "\n1. Empilhar prova\n2. Desempilhar prova\n3. Visualizar prova no topo\n4. Verificar se a pilha está vazia\n5. Sair\n";
        cout << "Escolha uma opção: ";
        cin >> opcao;

        switch (opcao) {
        case 1: {
            cout << "\n---Empilhando provas---\n";
            string disciplina, codigo;
            float nota;
            cout << "Digite a disciplina: ";
            cin >> disciplina;
            cout << "Digite a codigo: ";
            cin >> codigo;
            cout << "Digite a nota: ";
            cin >> nota;
            Prova* prova = new Prova(disciplina, codigo, nota, nullptr);
            pilha.empilhar(prova);
            cout << "Prova empilhada. Número de provas na pilha: " << pilha.getTamanho() << "\n";
            break;
        }
        case 2: {
            cout << "\n---Desempilhando provas---\n";
            Prova* prova = pilha.desempilhar();
            if (prova != nullptr) {
                cout << "Prova desempilhada. Disciplina: " << prova->getDisciplina() << ", Código: " << prova->getCodigoDaProva() << ", Nota: " << prova->getNota() << "\n";
                delete prova;
            }
            cout << "Número de provas na pilha: " << pilha.getTamanho() << "\n";
            break;
        }
        case 3: {
            cout << "\n---Visualizando o topo da pilhas de provas---\n";
            Prova* prova = pilha.verTopo();
            if (prova != nullptr) {
                cout << "Prova no topo. Disciplina: " << prova->getDisciplina() << ", Código: " << prova->getCodigoDaProva() << ", Nota: " << prova->getNota() << "\n";
            }
            break;
        }
        case 4: {
            cout << "\n---Verificando se a pilha de provas esta vazia---\n";
            if (pilha.estaVazia()) {
                cout << "A pilha está vazia.\n";
            } else {
                cout << "A pilha não está vazia.\n";
            }
            break;
        }
        case 5:
            limpaConsole();
            cout << "Saindo...\n";
            break;
        default:
            cout << "Opção inválida.\n";
        }
    } while (opcao != 5);
}

void filaBanco() {
    FilaBanco fila;
    int opcao;
    do {
        cout << "\n----FILA DO BANCO----";
        cout << "\n1. Adicionar cliente à fila\n2. Remover cliente da fila\n3. Listar clientes na fila\n4. Checar se a fila está vazia\n5. Inserir cliente com atendimento prioritário\n6. Sair\n";
        cout << "Escolha uma opção: ";
        cin >> opcao;

        switch (opcao) {
        case 1: {
            cout << "\n---Adicionando cliente na fila---\n";
            string nome, cpf, numeroConta, agencia;
            cout << "Digite o nome: ";
            cin >> nome;
            cout << "Digite o CPF: ";
            cin >> cpf;
            cout << "Digite o número da conta: ";
            cin >> numeroConta;
            cout << "Digite a agência: ";
            cin >> agencia;
            ClienteBanco* novoCliente = new ClienteBanco(nome, cpf, numeroConta, agencia, nullptr);
            fila.enqueue(novoCliente);
            cout << "Cliente adicionado à fila.\n";
            break;
        }
        case 2: {
            cout << "\n---Removendo cliente na fila---\n";
            if (!fila.isEmpty()) {
                ClienteBanco* cliente = fila.dequeue();
                cout << "Cliente " << cliente->getNome() << " removido da fila. \n";
                delete cliente;
            } else {
                cout << "A fila está vazia.\n";
            }
            break;
        }
        case 3: {
            cout << "\n---Listando clientes na fila---\n";
            fila.printQueue();
            break;
        }
        case 4: {
            cout << "\n---Verificando a fila---\n";
            if (fila.isEmpty()) {
                cout << "A fila está vazia.\n";
            } else {
                cout << "A fila não está vazia.\n";
            }
            break;
        }
        case 5: {
            cout << "\n---Adicionando cliente prioritario na fila---\n";
            string nome, cpf, numeroConta, agencia;
            cout << "Digite o nome: ";
            cin >> nome;
            cout << "Digite o CPF: ";
            cin >> cpf;
            cout << "Digite o número da conta: ";
            cin >> numeroConta;
            cout << "Digite a agência: ";
            cin >> agencia;
            ClienteBanco* novoCliente = new ClienteBanco(nome, cpf, numeroConta, agencia, nullptr);
            fila.enqueuePriority(novoCliente);
            cout << "Cliente com atendimento prioritário adicionado à fila.\n";
            break;
        }
        case 6: {
            limpaConsole();
            cout << "Saindo...\n";
            break;
        }
        default: {
            limpaConsole();
            cout << "Opção inválida. Tente novamente.\n";
            break;
        }
        }
    } while (opcao != 6);
}

void limpaConsole() {
    system("cls || clear");
}