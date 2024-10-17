#include "FilaBanco.hpp"
#include <iostream>

using namespace std;

FilaBanco::FilaBanco() : cabeca(nullptr), cauda(nullptr) {}

FilaBanco::~FilaBanco() {
    while (!isEmpty()) {
        dequeue();
    }
}

void FilaBanco::enqueue(ClienteBanco* novoCliente) {
    novoCliente->proximo = nullptr;  // O novo cliente será o último na fila, então seu 'proximo' é nullptr

    if (isEmpty()) {
        cabeca = cauda = novoCliente;
    } else {
        cauda->proximo = novoCliente;
        cauda = novoCliente;
    }
}


ClienteBanco* FilaBanco::dequeue() {
    if (isEmpty()) {
        cout << "A fila está vazia." << endl;
        return nullptr;
    } else {
        ClienteBanco* clienteRemovido = cabeca;
        cabeca = cabeca->proximo;
        if (cabeca == nullptr) {
            cauda = nullptr;
        }
        return clienteRemovido;
    }
}

void FilaBanco::printQueue() {
    if (isEmpty()) {
        cout << "A fila está vazia." << endl;
    } else {
        cout << "--Clientes na fila:" << endl;
        int i = 1;
        ClienteBanco* clienteAtual = cabeca;
        while (clienteAtual != nullptr) {
            cout << "-Cliente " << i << ":" << endl;
            clienteAtual->imprimir();
            clienteAtual = clienteAtual->proximo;
            i++;
        }
    }
}

bool FilaBanco::isEmpty() {
    return cabeca == nullptr;
}

void FilaBanco::enqueuePriority(ClienteBanco* cliente) {
    if (isEmpty()) {
        cabeca = cliente;
        cauda = cliente;
    } else {
        cliente->proximo = cabeca;
        cabeca = cliente;
    }
}
