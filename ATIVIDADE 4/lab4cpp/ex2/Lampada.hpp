#ifndef LAMPADA_HPP
#define LAMPADA_HPP

#include <string>
using namespace std;

class Lampada {
private:
    string modelo;
    int tensao;
    bool ligada;
    static int count; 

public:
    Lampada(string modelo, int tensao, bool ligada); 
    
    string getModelo();
    void setModelo(string novoModelo);
    int getTensao();
    void setTensao(int novaTensao);
    bool getEstado();
    void acender();
    void apagar();
    static int getCount(); 

    struct Node {
        Lampada* lampada;
        Node* next;

        Node(Lampada* l, Node* n) : lampada(l), next(n) {}
    };

    static Node* adicionarLampada(Node* lista, Lampada* novaLampada);

    static void exibirEstadoLampadas(Node* lista);

    static void ligarLampada(Node* lista, int lampadaIndex);

    static void desligarLampada(Node* lista, int lampadaIndex);

    static Node* excluirLampada(Node* lista, int lampadaIndex);

    void imprimirAtributos();

    static void consultarLampada(Node* lista, int lampadaIndex);

    static void mostrarTodasAsLampadas(Node* lista);
};

#endif
