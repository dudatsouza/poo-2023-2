#ifndef PROVA_HPP
#define PROVA_HPP
#include <string>
#include "Aluno.hpp"

using namespace std;

class Prova {
public:
    string Disciplina;
    string CodigoDaProva;
    float Nota;
    Aluno* aluno;

    Prova(string Disciplina, string CodigoDaProva, float Nota, Aluno* aluno);

    // Métodos get
    string getDisciplina() const;
    string getCodigoDaProva() const;
    float getNota() const;
    Aluno* getAluno() const;

    // Métodos set
    void setDisciplina(string Disciplina);
    void setCodigoDaProva(string CodigoDaProva);
    void setNota(float Nota);
    void setAluno(Aluno* aluno);
};

#endif