package lab8java;

import java.util.List;

public class ContaDeInvestimento extends Conta {
	private double taxaDeRetornoAnual;
	
	public ContaDeInvestimento(int numeroDaConta, String nomeTitular, String cpf, double saldoDaConta, String tipo, List<Transacao> transacoes, double taxaDeRetornoAnual) {
		super(numeroDaConta, nomeTitular, cpf, saldoDaConta, tipo, transacoes);
		this.taxaDeRetornoAnual = taxaDeRetornoAnual;
	}

	public double getTaxaDeRetornoAnual() {
		return taxaDeRetornoAnual;
	}
	public void setTaxaDeRetornoAnual(double taxaDeRetornoAnual) {
		this.taxaDeRetornoAnual = taxaDeRetornoAnual;
	}
	
	@Override
	public void imprimir() {
		
	}
}
