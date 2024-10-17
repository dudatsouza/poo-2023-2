#include "Triangulo.hpp"
#include <iostream>
#include <math.h>

using namespace std;

int Triangulo::count = 0;

Triangulo::Triangulo() : a(1), b(1), c(1) {
    count++;
}

Triangulo::Triangulo(double ladoA, double ladoB, double ladoC) : a(ladoA), b(ladoB), c(ladoC) {
    count++;
}

bool Triangulo::verificarTriangulo() {
    if (((abs(b - c)) < a) && ((b + c) > a) ||
        ((abs(a - c)) < b) && ((a + c) > b) ||
        ((abs(a - b)) < c) && ((a + b) > c) ) 
        return true;
    else return false;
}

void Triangulo::verificarTipo() {
    if (a == b && b == c) {
        cout << "Triângulo equilátero." << endl;
    } else if (a == b || b == c || a == c) {
        cout << "Triângulo isósceles." << endl;
    } else {
        cout << "Triângulo escaleno." << endl;
    }
}

int Triangulo::getCount() {
    return count;
}