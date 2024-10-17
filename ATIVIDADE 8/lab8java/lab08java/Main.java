package lab8java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static int numeroDaConta = 0;
	private static Scanner sc = new Scanner (System.in);
	private static List<Conta> contas = new ArrayList<Conta>();
	private static List<ContaCorrenteComum> comuns = new ArrayList<ContaCorrenteComum>();
	private static List<ContaCorrentePremium> premiuns = new ArrayList<ContaCorrentePremium>();
	private static List<ContaPoupanca> poupancas = new ArrayList<ContaPoupanca>();
	private static List<ContaDeInvestimento> investimentos = new ArrayList<ContaDeInvestimento>();
	private static String dataAtualHoje;
	
	public static void main(String[] args) {
		System.out.println("Digite a data de hoje: ");
		dataAtualHoje = sc.nextLine();
		
		while(true) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("| Digite a opcao desejada: ");
			System.out.println("| Digite 1: Criar Conta ");
			System.out.println("| Digite 2: Fazer Deposito");
			System.out.println("| Digite 3: Fazer Saque");
			System.out.println("| Digite 4: Visualizar Extrato");
			System.out.print("| Digite 0: Sair\n| ");
			int resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("---------------------------------------------------------------\n");
			
			
			switch (resposta) {
				case 1: {
					System.out.println("| Digite a opcao desejada: ");
					System.out.println("| Digite 1: Criar Conta Corrente Comum");
					System.out.println("| Digite 2: Criar Conta Corrente Premium");
					System.out.println("| Digite 3: Criar Conta Poupança");
					System.out.println("| Digite 4: Criar Conta de Investimento");
					System.out.println("| Digite 0: Cancelar");
					int resposta1 = sc.nextInt();
					sc.nextLine();
					
					switch(resposta1) {
						case 1: 
							criarComum();
							break;
							
						case 2: 
							criarPremium();
							break;
							
						case 3: 
							criarPoupanca();
							break;
							
						case 4: 
							criarInvestimento();
							break;
							
						case 0: 
							break;
					}
					break;
				}
				
				case 2: 
					System.out.println("Digite o numero da conta: ");
					int numConta = sc.nextInt();
					sc.nextLine();
					String tipo = encontrarConta(numConta);
					
					if(tipo == null) {
						System.out.println("CONTA NAO ENCONTRADA!");
						break;
					} else if (tipo == "CCC") {
						for(ContaCorrenteComum contaComum : comuns) {
							if(numConta == contaComum.getNumeroDaConta()) {
								contaComum.deposito(dataAtualHoje);
							}
						}
					} else if (tipo == "CCP") {
						for(ContaCorrentePremium contaPremium : premiuns) {
							if(numConta == contaPremium.getNumeroDaConta()) {
								contaPremium.deposito(dataAtualHoje);
							}
						}						
					} else if (tipo == "CP") {
						for(ContaPoupanca contaPoupanca : poupancas) {
							if(numConta == contaPoupanca.getNumeroDaConta()) {
								contaPoupanca.deposito(dataAtualHoje);
							}
						}						
					} else if (tipo == "CI") {
						for(ContaDeInvestimento contaInvestimento : investimentos) {
							if(numConta == contaInvestimento.getNumeroDaConta()) {
								contaInvestimento.deposito(dataAtualHoje);
							}
						}						
					}
					break;
					
				case 3: 
					System.out.println("Digite o numero da conta: ");
					int numConta1 = sc.nextInt();
					sc.nextLine();
					String tipo1 = encontrarConta(numConta1);
					
					if(tipo1 == null) {
						System.out.println("CONTA NAO ENCONTRADA!");
						break;
					} else if (tipo1 == "CCC") {
						for(ContaCorrenteComum contaComum : comuns) {
							if(numConta1 == contaComum.getNumeroDaConta()) {
								contaComum.saque(dataAtualHoje);
							}
						}
					} else if (tipo1 == "CCP") {
						for(ContaCorrentePremium contaPremium : premiuns) {
							if(numConta1 == contaPremium.getNumeroDaConta()) {
								contaPremium.saque(dataAtualHoje);
							}
						}						
					} else if (tipo1 == "CP") {
						for(ContaPoupanca contaPoupanca : poupancas) {
							if(numConta1 == contaPoupanca.getNumeroDaConta()) {
								contaPoupanca.saque(dataAtualHoje);
							}
						}						
					} else if (tipo1 == "CI") {
						for(ContaDeInvestimento contaInvestimento : investimentos) {
							if(numConta1 == contaInvestimento.getNumeroDaConta()) {
								contaInvestimento.saque(dataAtualHoje);
							}
						}						
					}
					break;
					
				case 4: 
					System.out.println("Digite o numero da conta: ");
					int numConta2 = sc.nextInt();
					sc.nextLine();
					String tipo2 = encontrarConta(numConta2);
					
					if(tipo2 == null) {
						System.out.println("CONTA NAO ENCONTRADA!");
						break;
					} else if (tipo2 == "CCC") {
						for(ContaCorrenteComum contaComum : comuns) {
							if(numConta2 == contaComum.getNumeroDaConta()) {
								contaComum.imprimir();
							}
						}
					} else if (tipo2 == "CCP") {
						for(ContaCorrentePremium contaPremium : premiuns) {
							if(numConta2 == contaPremium.getNumeroDaConta()) {
								contaPremium.imprimir();
							}
						}						
					} else if (tipo2 == "CP") {
						for(ContaPoupanca contaPoupanca : poupancas) {
							if(numConta2 == contaPoupanca.getNumeroDaConta()) {
								contaPoupanca.imprimir();
							}
						}						
					} else if (tipo2 == "CI") {
						for(ContaDeInvestimento contaInvestimento : investimentos) {
							if(numConta2 == contaInvestimento.getNumeroDaConta()) {
								contaInvestimento.imprimir();
							}
						}						
					}
					break;
				case 0: 
					System.out.println("MUITO OBRIGADO POR USAR NOSSOS SERVIÇOS!!");
					System.exit(0);
			}
		}
	}
	
	public static Conta criarConta(String tipo) {
		System.out.println("Digite o nome do titular da conta: ");
		String nomeTitular = sc.nextLine();

		System.out.println("Digite o CPF do titular da conta: ");
		String cpf = sc.nextLine();

		numeroDaConta++;
		double saldoDaConta = 0;
		
		Conta conta = new Conta(numeroDaConta, nomeTitular, cpf, saldoDaConta, tipo, null);
		contas.add(conta);
		return conta;
	}
	
	public static void criarComum() {
		String tipo = "CCC";
		Conta conta = criarConta(tipo);
		ContaCorrenteComum contaCorrenteComum = new ContaCorrenteComum(conta.getNumeroDaConta(), 
																	   conta.getNomeTitular(), 
																	   conta.getCpf(), 
																	   conta.getSaldoDaConta(), 
																	   tipo,
																	   new ArrayList<Transacao>());
		comuns.add(contaCorrenteComum);
		System.out.println("CONTA CORRENTE COMUM CRIADA COM SUCESSO!!");
		contaCorrenteComum.imprimir();
	}
	
	public static void criarPremium() {
		String tipo = "CCP";
		Conta conta = criarConta(tipo);
		double limiteDeCredito = 200;
		
		ContaCorrentePremium contaCorrentePremium = new ContaCorrentePremium(conta.getNumeroDaConta(), 
																			 conta.getNomeTitular(), 
																			 conta.getCpf(), 
																			 conta.getSaldoDaConta(), 
																			 tipo,
																			 new ArrayList<Transacao>(), 
																			 limiteDeCredito);
		premiuns.add(contaCorrentePremium);
		System.out.println("CONTA CORRENTE PREMIUM CRIADA COM SUCESSO!!");
		contaCorrentePremium.imprimir();
	}
	
	public static void criarPoupanca() {
		String tipo = "CP";
		Conta conta = criarConta(tipo);
		
		ContaPoupanca contaPoupanca = new ContaPoupanca(conta.getNumeroDaConta(), 
													 	conta.getNomeTitular(), 
													 	conta.getCpf(), 
													 	conta.getSaldoDaConta(), 
													 	tipo,
													 	new ArrayList<Transacao>(), 
													 	dataAtualHoje);
		poupancas.add(contaPoupanca);
		System.out.println("CONTA POUPANCA CRIADA COM SUCESSO!!");
		contaPoupanca.imprimir();
	}
	
	public static void criarInvestimento() {
		String tipo = "CI";
		Conta conta = criarConta(tipo);
		
		double taxaDeRetornoAnual;

        do {
            System.out.println("Taxa de Retorno Anual: ");
            taxaDeRetornoAnual = sc.nextDouble();
            sc.nextLine();

            if(taxaDeRetornoAnual < 0 || taxaDeRetornoAnual > 1){
                System.out.println("A taxa de retorno deve ser >= 0 e <= 1 !");
            }
        } while (taxaDeRetornoAnual < 0 || taxaDeRetornoAnual > 1);
		
		ContaDeInvestimento contaInvestimento = new ContaDeInvestimento(conta.getNumeroDaConta(), 
																			 conta.getNomeTitular(), 
																			 conta.getCpf(), 
																			 conta.getSaldoDaConta(), 
																			 tipo,
																			 new ArrayList<Transacao>(), 
																			 taxaDeRetornoAnual);
		investimentos.add(contaInvestimento);
		System.out.println("CONTA DE INVESTIMENTO CRIADA COM SUCESSO!!");
		contaInvestimento.imprimir();
	}

	public static String encontrarConta(int numConta) {
		if(contas.isEmpty()) {
			System.out.println("NAO EXISTE CONTA CADASTRADA!");
		} else {
			for(Conta conta : contas) {
				if(numConta == conta.getNumeroDaConta()) {
					String tipo =  conta.getTipo();
					return tipo;
				}
			}
		}
		return null;
	}
}
	
 