#include <iostream>
#include "Pessoa.hpp"

using namespace std;

Pessoa::Pessoa() {
    this->nome = "";
    this->cpf = "";
}
Pessoa::Pessoa(string nome, string cpf) {
    this->nome = nome;
    this->cpf = cpf;
}

string Pessoa::getNome() {
    return this->nome;
}
string Pessoa::getCpf() {
    return this->cpf;
}

void Pessoa::setNome(string nome) {
    this->nome = nome;
}
void Pessoa::setCpf(string cpf) {
    this->cpf = cpf;
}

void Pessoa::imprimir() {
    cout << "Nome: " << this->nome << endl;
    cout << "CPF: " << this->cpf << endl;
}

