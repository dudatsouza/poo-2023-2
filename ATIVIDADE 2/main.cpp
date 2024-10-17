#include <iostream>
#include "Corrida.hpp"
#include <string>
using namespace std;


int main() {
    Corrida p;

    string modelo;
    string motorizacao;
    string fabricante;
    string nome;
    float kmInicial;
    float kmFinal;  
    
    cout << "----- INFORMACOES NECESSARIAS -----\n";

    cout << "Digite o modelo: ";
    getline(cin, modelo);
    p.setModelo(modelo);

    cout << "Digite o motorizacao: ";
    getline(cin, motorizacao);
    p.setMotorizacao(motorizacao);

    cout << "Digite o fabricante: ";
    getline(cin, fabricante);
    p.setFabricante(fabricante);

    cout << "Digite o nome: ";
    getline(cin, nome);
    p.setNome(nome);

    cout << "Digite a quilometragem inicial: " ;
    cin >> kmInicial;
    p.setKmInicial(kmInicial);

    cout << "Digite a quilometragem inicial: " ;
    cin >> kmFinal;
    p.setKmFinal(kmFinal);
    
    cout << "-----------------------------------\n";
    
    
    p.imprimir();

    cout << "Quilometragem percorrida: " << p.calcularQuilometragemPercorrida() << endl;

    cout << "Valor final: " << p.valorFinal() << endl;
    
    cout << "-----------------------------------\n";

    return 0;
}

