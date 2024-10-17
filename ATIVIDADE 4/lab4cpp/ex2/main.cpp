#include "Lampada.hpp"
#include <iostream>

using namespace std;

int main() {
    Lampada::Node* listaDeLampadas = nullptr; 
    char opcao;

    do {
        cout << "MENU:" << endl;
        cout << "1. Adicionar lampada" << endl;
        cout << "2. Ligar lampada" << endl;
        cout << "3. Desligar lampada" << endl;
        cout << "4. Excluir lampada" << endl;
        cout << "5. Consultar lampada" << endl;
        cout << "6. Mostrar todas as lampadas" << endl;
        cout << "7. Sair" << endl;
        cout << "Escolha uma opcao: ";
        cin >> opcao;
        cout << endl;

        switch (opcao) {
            case '1': {
                string modelo;
                int tensao;
                bool ligada;

                cout << "Informe o modelo da lampada: ";
                cin >> modelo;
                cout << "Informe a tensao da lampada: ";
                cin >> tensao;
                cout << "A lampada esta ligada (1) ou desligada (0)? ";
                cin >> ligada;

                Lampada* novaLampada = new Lampada(modelo, tensao, ligada);
                listaDeLampadas = Lampada::adicionarLampada(listaDeLampadas, novaLampada);

                cout << Lampada::getCount() << "° Lampada adicionada com sucesso!" << endl;

                novaLampada->imprimirAtributos(); 

                break;
            }

            case '2': {
                int lampadaIndex;
                cout << "Informe o numero da lampada que deseja ligar: ";
                cin >> lampadaIndex;

                Lampada::ligarLampada(listaDeLampadas, lampadaIndex);
                cout << "Lampada " << lampadaIndex << " ligada com sucesso!" << endl;
                break;
            }

            case '3': {
                int lampadaIndex;
                cout << "Informe o numero da lampada que deseja desligar: ";
                cin >> lampadaIndex;

                Lampada::desligarLampada(listaDeLampadas, lampadaIndex);
                cout << "Lampada " << lampadaIndex << " desligada com sucesso!" << endl;
                break;
            }

            case '4': {
                int lampadaIndex;
                cout << "Informe o numero da lampada que deseja excluir: ";
                cin >> lampadaIndex;

                listaDeLampadas = Lampada::excluirLampada(listaDeLampadas, lampadaIndex);
                cout << "Lampada " << lampadaIndex << " excluida com sucesso!" << endl;
                break;
            }

            case '5': {
                int lampadaIndex;
                cout << "Informe o numero da lampada que deseja consultar: ";
                cin >> lampadaIndex;

                Lampada::consultarLampada(listaDeLampadas, lampadaIndex);
                break;
            }

            case '6': {
                Lampada::mostrarTodasAsLampadas(listaDeLampadas);
                break;
            }

            case '7': {
                Lampada::Node* currentNode = listaDeLampadas;
                while (currentNode != nullptr) {
                    Lampada::Node* nextNode = currentNode->next;
                    delete currentNode->lampada;
                    delete currentNode;
                    currentNode = nextNode;
                }

                cout << "Encerrando o programa." << endl;
                return 0;
            }

            default:
                cout << "Opcao invalida. Tente novamente." << endl;
        }

        cout << endl;
    } while (opcao != 0);

    return 0;
}
