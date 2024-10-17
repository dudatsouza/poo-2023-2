#ifndef ALUNO_HPP
#define ALUNO_HPP
#include <string>
#include "Pessoa.hpp"

using namespace std;

class Aluno : public Pessoa {
    public :
    int numeroMatricula;
    string curso;

    Aluno(string nome, string cpf, int numeroMatricula, string curso);

    void imprimir() override;

    // Métodos get
    int getNumeroMatricula() const;
    string getCurso() const;

    // Métodos set
    void setNumeroMatricula(int numeroMatricula) ;
    void setCurso(string curso);
};

#endif