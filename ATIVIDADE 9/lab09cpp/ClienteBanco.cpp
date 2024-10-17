#include <iostream>
#include "ClienteBanco.hpp"

using namespace std;

ClienteBanco::ClienteBanco(string nome, string cpf, string numeroConta, string agencia, ClienteBanco* proximo) 
    : Pessoa(nome, cpf), numeroConta(numeroConta), agencia(agencia), proximo(nullptr) {}

ClienteBanco::ClienteBanco() {
    numeroConta = "";
    agencia = "";
    proximo = nullptr;
}

string ClienteBanco::getNumeroConta() {
    return this->numeroConta;
}

string ClienteBanco::getAgencia() {
    return this->agencia;
}

void ClienteBanco::setNumeroConta(string numeroConta) {
    this->numeroConta = numeroConta;
}

void ClienteBanco::setAgencia(string agencia) {
    this->agencia = agencia;
}

void ClienteBanco::imprimir() {
    Pessoa::imprimir();
    cout << "Numero da conta: " << this->numeroConta << endl;
    cout << "Agencia: " << this->agencia << "\n" << endl;
}