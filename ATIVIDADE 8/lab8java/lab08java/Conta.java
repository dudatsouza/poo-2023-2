package lab8java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
	private int numeroDaConta;
	private String nomeTitular;
	private String cpf;
	protected double saldoDaConta;
	private String tipo;
	private List<Transacao> transacoes = new ArrayList<Transacao>();
	Scanner sc = new Scanner(System.in);

	public Conta (int numeroDaConta, String nomeTitular, String cpf, double saldoDaConta, String tipo, List<Transacao> transacoes) {
		this.numeroDaConta = numeroDaConta;
		this.nomeTitular = nomeTitular;
		this.cpf = cpf;
		this.saldoDaConta = saldoDaConta;
		this.tipo = tipo;
		this.transacoes = transacoes;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}
	public void setNumeroDaConta(int numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldoDaConta() {
		return saldoDaConta;
	}
	public void setSaldoDaConta(double saldoDaConta) {
		this.saldoDaConta = saldoDaConta;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	public void deposito(String data) {
		System.out.println("Digite o valor do deposito: "); 
		double valorDeposito = sc.nextDouble();
		sc.nextLine();
		
		this.saldoDaConta += valorDeposito;

		System.out.println("Digite a descricao do deposito: "); 
		String descricao = sc.nextLine();

		Transacao t = new Transacao(data, valorDeposito, descricao);
		this.transacoes.add(t);
		System.out.println("DEPOSITO REALIZADO COM SUCESSO!!");
	}
	
	public void saque(String data) {
		System.out.println("Digite o valor do saque: "); 
		double valorSaque = sc.nextDouble();
		sc.nextLine();
		
		if((this.saldoDaConta - valorSaque) < 0) {
			System.out.println("ESTE SAQUE NAO PODE SER CONCLUIDO, POIS O VALOR DO SAQUE ULTAPASSA O SALDO DA SUA CONTA!!");
		} else {
			System.out.println("Digite a descricao do saque: "); 
			String descricao = sc.nextLine();
			this.saldoDaConta -= valorSaque;
			
			valorSaque = valorSaque * (-1);
			Transacao t = new Transacao(data, valorSaque, descricao);
			this.transacoes.add(t);
			System.out.println("SAQUE REALIZADO COM SUCESSO!!");
		}
	}
	
	public void imprimir() {
		System.out.println("Tipo de conta: " + this.tipo == "CCC" ? "Conta Corrente Comum" :
            								   this.tipo == "CCP" ? "Conta Corrente Premium" :
								               this.tipo == "CP" ? "Conta Poupança" :
								               this.tipo == "CI" ? "Conta de Investimento" : "Tipo Desconhecido" );
		System.out.println("Numero da conta: " + this.numeroDaConta);
		System.out.println("Nome do Titular: " + this.nomeTitular);
		System.out.println("CPF do Titular: " + this.cpf);
		System.out.println("Saldo da Conta: " + this.saldoDaConta);
		if(transacoes.isEmpty()) {
			System.out.println("AINDA NAO FOI REALIZADA NENHUMA TRANSACAO NESTA CONTA!!");
		} else {
			int aux = 0; 
			System.out.println("-TRANSCOES: ");
			System.out.println("- " + ++aux + "ª: ");
			for (Transacao transacao : transacoes) {
				transacao.imprimir();
				System.out.println("--------");
			}
		}
	}
}
