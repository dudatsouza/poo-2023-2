#include "Aluno.hpp"
#include <iostream>

using namespace std;

Aluno::Aluno(string nome, string cpf, int numeroMatricula, string curso) 
    : Pessoa(nome, cpf), numeroMatricula(numeroMatricula), curso(curso) {}

void Aluno::imprimir() {
    Pessoa::imprimir();
    cout << "Numero da matricula: " << numeroMatricula << endl;
    cout << "Curso: " << curso << endl;
}

int Aluno::getNumeroMatricula() const {
    return numeroMatricula;
}

string Aluno::getCurso() const {
    return curso;
}

void Aluno::setNumeroMatricula(int numeroMatricula) {
    this->numeroMatricula = numeroMatricula;
}

void Aluno::setCurso(string curso) {
    this->curso = curso;
}


    