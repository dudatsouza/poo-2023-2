#ifndef FILABANCO_HPP
#define FILABANCO_HPP
#include "ClienteBanco.hpp"
#include <iostream>

using namespace std;

class FilaBanco {
    private:
        ClienteBanco* cabeca; // primeiro elemento da fila
        ClienteBanco* cauda; // ultimo elemento da fila

    public:  
        FilaBanco();
        ~FilaBanco();
        void enqueue(ClienteBanco* cliente);
        ClienteBanco* dequeue();
        void printQueue();
        bool isEmpty();
        void enqueuePriority(ClienteBanco* cliente);
};
#endif

