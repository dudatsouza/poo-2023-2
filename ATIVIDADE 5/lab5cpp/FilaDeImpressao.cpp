#include "FilaDeImpressao.hpp"
#include <iostream>
#include <list>

FilaDeImpressao::FilaDeImpressao() : inicio(nullptr) {}

void FilaDeImpressao::adicionarDocumento(const std::string& nomeArquivo, int numPaginas, int prioridade) {
    No* novoDocumento = new No(nomeArquivo, numPaginas, prioridade);
    
    if (!inicio) {
        inicio = novoDocumento;
    } else {
        No* atual = inicio;
        No* anterior = nullptr;

        while (atual && atual->getPrioridade() >= prioridade) {
            anterior = atual;
            atual = atual->getProximo();
        }

        if (!anterior) {
            novoDocumento->setProximo(inicio);
            inicio = novoDocumento;
        } else {
            anterior->setProximo(novoDocumento);
            novoDocumento->setProximo(atual);
        }
    }
}

void FilaDeImpressao::consultarDocumento(int id) {
    No* atual = inicio;
    while (atual) {
        if (atual->getId() == id) {
            std::cout << "Documento encontrado:\n";
            std::cout << "ID: " << atual->getId() << "\n";
            std::cout << "Nome do Arquivo: " << atual->getNomeArquivo() << "\n";
            std::cout << "Número de Páginas: " << atual->getNumPaginas() << "\n";
            std::cout << "Prioridade: " << atual->getPrioridade() << "\n";
            return;
        }
        atual = atual->getProximo();
    }

    std::cout << "Documento com ID " << id << " não encontrado na fila.\n";
}

void FilaDeImpressao::listarDocumentos() {
    std::list<No*> documentos;

    No* atual = inicio;
    while (atual) {
        documentos.push_back(atual);
        atual = atual->getProximo();
    }

    // Ordenar a lista com base na prioridade (em ordem crescente)
    documentos.sort([](No* a, No* b) {
        return a->getPrioridade() < b->getPrioridade();  // Ordem crescente de prioridade
    });

    std::cout << "Documentos na fila de impressão (ordenados por prioridade):\n";
    for (No* documento : documentos) {
        std::cout << "ID: " << documento->getId() << ", ";
        std::cout << "Nome do Arquivo: " << documento->getNomeArquivo() << ", ";
        std::cout << "Número de Páginas: " << documento->getNumPaginas() << ", ";
        std::cout << "Prioridade: " << documento->getPrioridade() << "\n";
    }
}

void FilaDeImpressao::removerDocumento(int id) {
    No* atual = inicio;
    No* anterior = nullptr;

    while (atual) {
        if (atual->getId() == id) {
            if (anterior) {
                anterior->setProximo(atual->getProximo());
            } else {
                inicio = atual->getProximo();
            }
            delete atual;
            std::cout << "Documento com ID " << id << " removido da fila.\n";
            return;
        }
        anterior = atual;
        atual = atual->getProximo();
    }

    std::cout << "Documento com ID " << id << " não encontrado na fila.\n";
}

void FilaDeImpressao::alterarDocumento(int id, const std::string& novoNomeArquivo, int novoNumPaginas, int novaPrioridade) {
    No* atual = inicio;

    while (atual) {
        if (atual->getId() == id) {
            atual->alterarDocumento(novoNomeArquivo, novoNumPaginas, novaPrioridade);
            std::cout << "Documento com ID " << id << " alterado com sucesso.\n";
            return;
        }
        atual = atual->getProximo();
    }

    std::cout << "Documento com ID " << id << " não encontrado na fila.\n";
}