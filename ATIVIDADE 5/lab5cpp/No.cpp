#include "No.hpp"

int No::proximoId = 1;  // Inicializa o próximo ID como 1

No::No(const std::string& _nomeArquivo, int _numPaginas, int _prioridade)
    : id(proximoId++), nomeArquivo(_nomeArquivo), numPaginas(_numPaginas), prioridade(_prioridade), proximo(nullptr) {}

int No::getId() {
    return id;
}

std::string No::getNomeArquivo() {
    return nomeArquivo;
}

int No::getNumPaginas() {
    return numPaginas;
}

int No::getPrioridade() {
    return prioridade;
}

No* No::getProximo() {
    return proximo;
}

void No::setProximo(No* _proximo) {
    proximo = _proximo;
}

void No::alterarDocumento(const std::string& _nomeArquivo, int _numPaginas, int _prioridade) {
    nomeArquivo = _nomeArquivo;
    numPaginas = _numPaginas;
    prioridade = _prioridade;
}
