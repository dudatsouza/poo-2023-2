#ifndef FILADEIMPRESSAO_HPP
#define FILADEIMPRESSAO_HPP

#include "No.hpp"

class FilaDeImpressao {
private:
    No* inicio;

public:
    FilaDeImpressao();
    void adicionarDocumento(const std::string& nomeArquivo, int numPaginas, int prioridade);
    void consultarDocumento(int id);
    void listarDocumentos();
    void removerDocumento(int id);
    void alterarDocumento(int id, const std::string& novoNomeArquivo, int novoNumPaginas, int novaPrioridade);
};

#endif
