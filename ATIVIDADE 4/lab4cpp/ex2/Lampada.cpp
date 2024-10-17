#include "Lampada.hpp"
#include <iostream>

using namespace std;

int Lampada::count = 0; 

Lampada::Lampada(string modelo, int tensao, bool ligada) {
    this->modelo = modelo;
    this->tensao = tensao;
    this->ligada = ligada;
    count++; 
}

string Lampada::getModelo() {
    return modelo;
}

void Lampada::setModelo(string novoModelo) {
    modelo = novoModelo;
}

int Lampada::getTensao() {
    return tensao;
}
void Lampada::setTensao(int novaTensao) {
    tensao = novaTensao;
}

bool Lampada::getEstado() {
    return ligada;
}

void Lampada::acender() {
    ligada = true;
}

void Lampada::apagar() {
    ligada = false;
}

int Lampada::getCount() {
    return count;
}

Lampada::Node* Lampada::adicionarLampada(Node* lista, Lampada* novaLampada) {
    Node* newNode = new Node(novaLampada, lista);
    return newNode;
}

void Lampada::ligarLampada(Node* lista, int lampadaIndex) {
    Node* currentNode = lista;
    int currentIndex = 1;

    while (currentNode != nullptr && currentIndex < lampadaIndex) {
        currentNode = currentNode->next;
        currentIndex++;
    }

    if (currentNode != nullptr) {
        currentNode->lampada->acender();
    }
}

void Lampada::desligarLampada(Node* lista, int lampadaIndex) {
    Node* currentNode = lista;
    int currentIndex = 1;

    while (currentNode != nullptr && currentIndex < lampadaIndex) {
        currentNode = currentNode->next;
        currentIndex++;
    }

    if (currentNode != nullptr) {
        currentNode->lampada->apagar();
    }
}

Lampada::Node* Lampada::excluirLampada(Node* lista, int lampadaIndex) {
    Node* currentNode = lista;
    Node* prevNode = nullptr;
    int currentIndex = 1;

    while (currentNode != nullptr && currentIndex < lampadaIndex) {
        prevNode = currentNode;
        currentNode = currentNode->next;
        currentIndex++;
    }

    if (currentNode != nullptr) {
        if (prevNode != nullptr) {
            prevNode->next = currentNode->next;
        } else {
            lista = currentNode->next;
        }
        delete currentNode->lampada;
        delete currentNode;
    }

    return lista;
}

// Método para imprimir os atributos de uma lâmpada específica
void Lampada::imprimirAtributos() {
    cout << "\nModelo: " << getModelo() << endl;
    cout << "Tensao: " << getTensao() << "V" << endl;
    cout << "Estado: " << (getEstado() ? "Ligada" : "Desligada") << endl;
}

// Método para consultar uma lâmpada específica
void Lampada::consultarLampada(Node* lista, int lampadaIndex) {
    Node* currentNode = lista;
    int currentIndex = 1;
    bool found = false;

    while (currentNode != nullptr) {
        if (currentIndex == lampadaIndex) {
            found = true;
            cout << "\nLampada " << lampadaIndex << ": ";
            currentNode->lampada->imprimirAtributos(); 
            break;
        }

        currentNode = currentNode->next;
        currentIndex++;
    }

    if (!found) {
        cout << "\nLampada " << lampadaIndex << " nao encontrada." << endl;
    }
}

// Método para mostrar todas as lâmpadas
void Lampada::mostrarTodasAsLampadas(Node* lista) {
    if (lista == nullptr) {
        cout << "A lista está vazia." << endl;
    } else {
        cout << "----- LAMPADAS -----" << endl;
        Node* currentNode = lista;
        int lampadaIndex = 1;

        while (currentNode != nullptr) {
            cout << "Lampada " << lampadaIndex << ": ";
            currentNode->lampada->imprimirAtributos(); 
            cout << "---------------------" << endl;

            currentNode = currentNode->next;
            lampadaIndex++;
        }
    }
}
