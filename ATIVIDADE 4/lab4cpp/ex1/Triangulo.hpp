#ifndef TRIANGULO_HPP
#define TRIANGULO_HPP

class Triangulo {
private:
    double a;
    double b;
    double c;
    static int count;

public:
    Triangulo(); 
    Triangulo(double ladoA, double ladoB, double ladoC); 

    void verificarTipo();
    bool verificarTriangulo();
    static int getCount(); 
};

#endif