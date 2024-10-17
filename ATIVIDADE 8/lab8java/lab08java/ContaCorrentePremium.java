package lab8java;

import java.util.List;

public class ContaCorrentePremium extends Conta {
	private double limiteDeCredito;
	
	public ContaCorrentePremium(int numeroDaConta, String nomeTitular, String cpf, double saldoDaConta, String tipo, List<Transacao> transacoes, double limiteDeCredito) {
		super(numeroDaConta, nomeTitular, cpf, saldoDaConta, tipo, transacoes);
		this.limiteDeCredito = limiteDeCredito;
	}
	
	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}
	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	@Override
	public void saque(String data) {
		System.out.println("Digite o valor do saque: "); 
		double valorSaque = sc.nextDouble();
		sc.nextLine();
		
		if((this.saldoDaConta - valorSaque) > limiteDeCredito) {
			System.out.println("ESTE SAQUE NAO PODE SER CONCLUIDO, POIS O VALOR DO SAQUE ULTAPASSA O LIMITE DE CREDITO!!");
		} else {
			System.out.println("Digite a descricao do saque: "); 
			String descricao = sc.nextLine();
			
			this.saldoDaConta -= valorSaque;
			 
			if((this.saldoDaConta - valorSaque) < 0) {
				this.limiteDeCredito -= this.saldoDaConta;
			}
			

			valorSaque = valorSaque * (-1);

			Transacao t = new Transacao(data, valorSaque, descricao);
			this.getTransacoes().add(t);

			System.out.println("SAQUE REALIZADO COM SUCESSO!!");
		}
	}
	
	public void imprimir() {
		System.out.println("Tipo de conta: " + this.getTipo() == "CCC" ? "Conta Corrente Comum" :
            								   this.getTipo() == "CCP" ? "Conta Corrente Premium" :
								               this.getTipo() == "CP" ? "Conta Poupança" :
								               this.getTipo() == "CI" ? "Conta de Investimento" : "Tipo Desconhecido" );
		System.out.println("Numero da conta: " + this.getNumeroDaConta());
		System.out.println("Nome do Titular: " + this.getNomeTitular());
		System.out.println("CPF do Titular: " + this.getCpf());
		System.out.println("Saldo da Conta: " + this.getSaldoDaConta());
		System.out.println("Limite da Conta: " + this.limiteDeCredito);
		if(this.getTransacoes().isEmpty()) {
			System.out.println("AINDA NAO FOI REALIZADA NENHUMA TRANSACAO NESTA CONTA!!");
		} else {
			int aux = 0; 
			System.out.println("-TRANSCOES: ");
			System.out.println("- " + ++aux + "ª: ");
			for (Transacao transacao : this.getTransacoes()) {
				transacao.imprimir();
				System.out.println("--------");
			}
		}
	}
}
