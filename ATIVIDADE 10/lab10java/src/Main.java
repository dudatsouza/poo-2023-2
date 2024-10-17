package lab10java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ExcecaoSexoInvalido, ExcecaoMedicoInexistente, ExcecaoPacienteInexistente, ExcecaoConsultaInexistente {
		Scanner sc = new Scanner (System.in);
	    Consultorio consultorio = new Consultorio("Consultorio", "999999999", "Rua Qualquer Uma, 10");
		
		int resposta = 1;
		while(resposta != 0) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("| Digite a opcao desejada: ");
			System.out.println("| Digite 1: Cadastrar Medico");
			System.out.println("| Digite 2: Cadastrar Paciente");
			System.out.println("| Digite 3: Cadastrar Consulta");
			System.out.println("| Digite 4: Remover Medico");
			System.out.println("| Digite 5: Remover Paciente");
			System.out.println("| Digite 6: Remover Consulta");
			System.out.println("| Digite 7: Alterar Dados de um Medico");
			System.out.println("| Digite 8: Alterar Dados de um Paciente");
			System.out.println("| Digite 9: Alterar Dados de uma Consulta");
			System.out.println("| Digite 10: Registar um Diagnostico a uma Consulta");
			System.out.println("| Digite 11: Imprimir Dados de um Medico");
			System.out.println("| Digite 12: Imprimir Dados de um Paciente");
			System.out.println("| Digite 13: Imprimir Dados de uma Consulta em especifico");	
			System.out.println("| Digite 14: Imprimir Consultas de um Medico");	
			System.out.println("| Digite 15: Imprimir Consultas de um Paciente");			
			System.out.println("| Digite 16: Imprimir Lista de Medicos");
			System.out.println("| Digite 17: Imprimir Lista de Pacientes");
			System.out.println("| Digite 18: Imprimir Lista de Coonsultas");
			System.out.println("| Digite 19: Imprimir Dados do Consultorio");
			System.out.print("| Digite 0: Sair\n| ");
			resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("---------------------------------------------------------------\n");
			
			switch (resposta) {
				case 1: 
					System.out.println("------------CADASTRANDO MEDICO------------");
					consultorio.cadastrarMedico();
					System.out.println("------------------------------------------\n");
					break;
					
				case 2: 
					System.out.println("-----------CADASTRANDO PACIENTE-----------");
				    consultorio.cadastrarPaciente();
					System.out.println("------------------------------------------\n");
					break;
				
				case 3: 			
					System.out.println("-----------CADASTRANDO CONSULTA-----------");    
				    consultorio.cadastrarConsulta();
					System.out.println("------------------------------------------\n");
					break;

				case 4: 
					System.out.println("-------------REMOVENDO MEDICO-------------");
					consultorio.removerMedico();
					System.out.println("------------------------------------------\n");				    
					break;
				
				case 5: 
					System.out.println("------------REMOVENDO PACIENTE------------");
					consultorio.removerPaciente();
					System.out.println("------------------------------------------\n");
					break;
				
				case 6: 
					System.out.println("------------REMOVENDO CONSULTA------------");
					consultorio.removerConsulta();
					System.out.println("------------------------------------------\n");
					break;
				
				case 7: 
					System.out.println("------ALTERANDO DADOS DE UM MEDICO------");
					consultorio.alterarMedico();
					System.out.println("------------------------------------------\n");
					break;
				
				case 8: 
					System.out.println("------ALTERANDO DADOS DE UM PACIENTE------");
				    consultorio.alterarPaciente();
					System.out.println("------------------------------------------\n");
					break;
								
				case 9: 
					System.out.println("-----ALTERANDO DADOS DE UMA CONSULTA------");
					consultorio.alterarConsulta();
					System.out.println("------------------------------------------\n");				
					break;
								
				case 10: 
					System.out.println("--------REGISTRANDO UM DIAGNOSTICO--------");				
					consultorio.registrarDiagnostico();
					System.out.println("------------------------------------------\n");
					break;
					
				case 11: 
					System.out.println("-------IMPRIMINDO DADOS DE UM MEDICO------");			    
				    consultorio.imprimirMedico();
					System.out.println("------------------------------------------\n");
					break;

				case 12: 
					System.out.println("-----IMPRIMINDO DADOS DE UM PACIENTE------");			    
				    consultorio.imprimirPaciente();
					System.out.println("------------------------------------------\n");
					break;
				
				case 13: 
					System.out.println("-----IMPRIMINDO DADOS DE UMA CONSULTA-----");			    
				    consultorio.imprimirConsulta();
					System.out.println("------------------------------------------\n");
					break;
				
				case 14: 
					System.out.println("----IMPRIMINDO CONSULTAS DE UM MEDICO-----");
					consultorio.imprimirConsultasDeUmMedico();
					System.out.println("------------------------------------------\n");
					break;
					
				case 15: 
					System.out.println("----IMPRIMINDO CONSULTAS DE UM PACIENTE---");
					consultorio.imprimirConsultasDeUmPaciente();
					System.out.println("------------------------------------------\n");
					break;
				
				case 16: 
					System.out.println("-------IMPRIMINDO LISTA DE MEDICOS-------");
				    consultorio.imprimirListaDeMedicos();
					System.out.println("------------------------------------------\n");
					break;
								
				case 17: 
					System.out.println("-------IMPRIMINDO LISTA DE PACIENTES------");
					consultorio.imprimirListaDePacientes();	
					System.out.println("------------------------------------------\n");			
					break;
								
				case 18: 
					System.out.println("-------IMPRIMINDO LISTA DE CONSULTAS------");				
					consultorio.imprimirListaDeConsultas();
					System.out.println("------------------------------------------\n");
					break;
					
				case 19: 
					System.out.println("------IMPRIMINDO DADOS DO CONSULTORIO-----");	
					consultorio.imprimir();
					System.out.println("------------------------------------------\n");
					break;
								
				case 0: 
					System.out.println("\n- MUITO OBRIGADO POR USAR NOSSOS SERVICOS!");
					System.exit(0);
					break;
					
				default: 
					System.out.println("\n- OPCAO INVALIDA, TENTE NOVAMENTE!");
					break;
				}
				
			}
				
		System.gc();
		sc.close();

	}
	
}
