#ifndef __CLIENTEBANCO_HPP
#define __CLIENTEBANCO_HPP
#include "Pessoa.hpp"
#include <iostream>

using namespace std;

class ClienteBanco : public Pessoa {
    public:
        string numeroConta;
        string agencia;
        ClienteBanco* proximo;
        
        ClienteBanco();
        ClienteBanco(string nome, string cpf, string numeroConta, string agencia, ClienteBanco* proximo);
        string getNumeroConta();
        string getAgencia();
        void setNumeroConta(string numeroConta);
        void setAgencia(string agencia);
        void imprimir() override;
};

#endif