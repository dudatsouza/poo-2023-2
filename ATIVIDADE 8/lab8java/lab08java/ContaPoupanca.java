package lab8java;

import java.util.List;

public class ContaPoupanca extends Conta {
	private String dataDeAniversario;

	public ContaPoupanca(int numeroDaConta, String nomeTitular, String cpf, double saldoDaConta, String tipo, List<Transacao> transacoes, String dataDeAnivesario) {
		super(numeroDaConta, nomeTitular, cpf, saldoDaConta, tipo, transacoes);
		this.dataDeAniversario = dataDeAnivesario;
	}

	public String getDataDeAniversario() {
		return dataDeAniversario;
	}
	public void setDataDeAniversario(String dataDeAniversario) {
		this.dataDeAniversario = dataDeAniversario;
	}
	
	@Override
	public void imprimir() {
		
	}
}
