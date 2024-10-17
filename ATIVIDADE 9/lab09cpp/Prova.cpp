#include "Prova.hpp"
#include <iostream>

using namespace std;

Prova::Prova(string Disciplina, string CodigoDaProva, float Nota, Aluno* aluno) 
    : Disciplina(Disciplina), CodigoDaProva(CodigoDaProva), Nota(Nota), aluno(aluno) {}

string Prova::getDisciplina() const {
    return Disciplina;
}

string Prova::getCodigoDaProva() const {
    return CodigoDaProva;
}

float Prova::getNota() const {
    return Nota;
}

Aluno* Prova::getAluno() const {
    return aluno;
}

void Prova::setDisciplina(string Disciplina) {
    this->Disciplina = Disciplina;
}

void Prova::setCodigoDaProva(string CodigoDaProva) {
    this->CodigoDaProva = CodigoDaProva;
}

void Prova::setNota(float Nota) {
    this->Nota = Nota;
}

void Prova::setAluno(Aluno* aluno) {
    this->aluno = aluno;
}