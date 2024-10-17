#ifndef __PESSOA_HPP
#define __PESSOA_HPP

#include <iostream>

using namespace std;

class Pessoa {
    private:
        string nome;
        string cpf;
    public:
        Pessoa();
        Pessoa(string nome, string cpf);
        string getNome();
        string getCpf();
        void setNome(string nome);
        void setCpf(string cpf);
        virtual void imprimir();
};
#endif 