#ifndef PILHAPROVAS_HPP
#define PILHAPROVAS_HPP
#include "Prova.hpp"

using namespace std;

class PilhaProvas {
public:
    struct Nodo {
        Prova* prova;
        Nodo* proximo;
    };

    Nodo* topo;
    int tamanho;

    PilhaProvas() : topo(nullptr), tamanho(0) {}

    bool estaVazia() const { return topo == nullptr; }
    int getTamanho() const { return tamanho; }

    void empilhar(Prova* prova);
    Prova* desempilhar();
    Prova* verTopo() const;
};

#endif