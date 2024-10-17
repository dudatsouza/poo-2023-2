package lab8java;

import java.util.List;

public class ContaCorrenteComum extends Conta{

	public ContaCorrenteComum(int numeroDaConta, String nomeTitular, String cpf, double saldoDaConta, String tipo, List<Transacao> transacoes) {
		super(numeroDaConta, nomeTitular, cpf, saldoDaConta, tipo, transacoes);
	}
	
}
	