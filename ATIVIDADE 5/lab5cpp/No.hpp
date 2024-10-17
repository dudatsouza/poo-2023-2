#ifndef NO_HPP
#define NO_HPP

#include <string>

class Documento;

class No {
private:
    int id;
    static int proximoId;  // Variável estática para gerar IDs automaticamente
    std::string nomeArquivo;
    int numPaginas;
    int prioridade;
    No* proximo;

public:
    No(const std::string& _nomeArquivo, int _numPaginas, int _prioridade);
    int getId();
    std::string getNomeArquivo();
    int getNumPaginas();
    int getPrioridade();
    No* getProximo();
    void setProximo(No* _proximo);
    void alterarDocumento(const std::string& _nomeArquivo, int _numPaginas, int _prioridade);
};

#endif
