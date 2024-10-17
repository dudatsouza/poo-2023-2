// Corrida.hpp

#ifndef __CORRIDA_HPP
#define __CORRIDA_HPP

#include <string>
using namespace std;

class Corrida { 
private: 
    string modelo;
    string motorizacao;
    string fabricante;
    string nome;
    float kmInicial;
    float kmFinal;  

public:
    Corrida();
    ~Corrida();

    void setModelo(string modelo);
    string getModelo();
    void setMotorizacao(string motorizacao);
    string getMotorizacao();
    void setFabricante(string fabricante);
    string getFabricante();
    void setNome(string nome);
    string getNome();
    void setKmInicial(float kmInicial);
    float getKmInicial();
    void setKmFinal(float kmFinal);
    float getKmFinal();

    void imprimir();
    float calcularQuilometragemPercorrida();
    float valorFinal();
};

#endif

