#include "Corrida.hpp"
#include <iostream>

Corrida::Corrida() {}
Corrida::~Corrida() {}

void Corrida::setModelo (string a) {
    modelo = a;
}
string Corrida::getModelo() {
    return modelo;
}

void Corrida::setMotorizacao (string b) {
    motorizacao = b;
}
string Corrida::getMotorizacao() {
    return motorizacao;
}

void Corrida::setFabricante (string c) {
   fabricante = c;
}
string Corrida::getFabricante() {
    return fabricante;
}

void Corrida::setNome (string d) {
    nome = d;
}
string Corrida::getNome() {
    return nome;
}

void Corrida::setKmInicial(float in) {
    kmInicial = in;
}
float Corrida::getKmInicial() {
    return kmInicial;
}
void Corrida::setKmFinal(float fi) {
    kmFinal = fi;
}
float Corrida::getKmFinal() {
    return kmFinal;
}

void Corrida::imprimir() {
	cout << "\n----- IMPRIMINDO RESULTADOS -----";
	cout << "\nModelo: " << modelo << "\nMotorizacao: " << motorizacao << "\nFabricante: " << fabricante << "\nNome: " << nome << "\nQuilometragem Inicial: " << kmInicial << "\nQuilometragem Inicial: " << kmFinal << endl;
}

float Corrida::calcularQuilometragemPercorrida() {
    return (kmFinal - kmInicial);
}

float Corrida::valorFinal() {
    return ((kmFinal - kmInicial) * (3.75));
}

