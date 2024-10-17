#include "PilhaProvas.hpp"
#include <iostream>

using namespace std;

void PilhaProvas::empilhar(Prova* prova) {
    Nodo* novoNodo = new Nodo;
    novoNodo->prova = prova;
    novoNodo->proximo = topo;
    topo = novoNodo;
    tamanho++;
}

Prova* PilhaProvas::desempilhar() {
    if (estaVazia()) {
        cout << "A pilha está vazia." << endl;
        return nullptr;
    } else {
        Nodo* nodoRemovido = topo;
        Prova* provaRemovida = nodoRemovido->prova;
        topo = topo->proximo;
        delete nodoRemovido;
        tamanho--;
        return provaRemovida;
    }
}

Prova* PilhaProvas::verTopo() const {
    if (estaVazia()) {
        cout << "A pilha está vazia." << endl;
        return nullptr;
    } else {
        return topo->prova;
    }
}