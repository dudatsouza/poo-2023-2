#include "Triangulo.hpp"
#include <iostream>

using namespace std;

int main() {
    double ladoA, ladoB, ladoC;
    int s;

    while (s == 0) {
        cout << "Digite os tres lados do triangulo "<< Triangulo::getCount() + 1 << ": ";
        cin >> ladoA >> ladoB >> ladoC;

        Triangulo meuTriangulo(ladoA, ladoB, ladoC);
        if (meuTriangulo.verificarTriangulo() == true) 
            meuTriangulo.verificarTipo();
        else 
            cout << "Estes lados não formam um triangulo;" << endl;

        cout << "Número de instâncias da classe Triangulo: " << Triangulo::getCount() << endl;

        cout << "Você deseja sair do programa? " << endl;
        cout << "Digite 1: Sim" << endl;
        cout << "Digite 2: Nao" << endl;
        cin >> s;     
    }

    return 0;
}