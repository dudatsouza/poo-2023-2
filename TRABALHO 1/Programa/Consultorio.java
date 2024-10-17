package trabalho1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consultorio { 
	Scanner sc = new Scanner(System.in);
		
	private int contPaciente = 0; 
	private String telefone; 	
	private String nome;
	private String endereco;
	private List<Medico> medicos;
	private List<Paciente> pacientes;
	private List<Consulta> consultas;
	
	public Consultorio (String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		medicos = new ArrayList<Medico>();
		pacientes = new ArrayList<Paciente>();
		consultas = new ArrayList<Consulta>();
	}

	public int getContPaciente() {
		return contPaciente;
	}
	public void setContPaciente(int contPaciente) {
		this.contPaciente = contPaciente;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Medico procurarMedico (int crm) {
		if (medicos.isEmpty()) System.out.println("A LISTA DE MEDICOS ESTA VAZIA.\n");
	    else {
			for(Medico medico : medicos) {
				if (medico.getCrm() == crm) return medico;
			}
	    }
		System.out.println("\n- MEDICO NAO ENCONTRADO!");
		return null;
	}
	
	public Paciente procurarPaciente (String cpf) {
		if (pacientes.isEmpty()) System.out.println("A LISTA DE PACIENTES ESTA VAZIA.\n");
	    else {
			for(Paciente paciente : pacientes) {
				if (paciente.getCpf().equals(cpf)) return paciente;
			}
	    }
		System.out.println("\n- PACIENTE NAO ENCONTRADO!");
		return null;
	}

	public Consulta procurarConsulta (String data, String hora, String cpfPaciente, int crmMedico) {
		if (pacientes.isEmpty()) System.out.println("A LISTA DE CONSULTAS ESTA VAZIA.\n");
	    else {
	    	for (Consulta consulta : consultas) {
				if ((consulta.getData().equals(data)) && 
					(consulta.getHora().equals(hora)) &&
					(consulta.getCpfPaciente().equals(cpfPaciente)) &&
					(consulta.getCrmMedico() == crmMedico)) return consulta;
			}
	    }
		System.out.println("\n- CONSULTA NAO ENCONTRADO!");
		return null;
	}

	public Pessoa cadastrarPessoa () {
		System.out.print("Digite o nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite o sexo: ");
		char sexo = sc.next().charAt(0);
		sc.nextLine();
		
		System.out.print("Digite o endereco: ");
		String endereco = sc.nextLine();
		
		System.out.print("Digite o CPF: ");
		String cpf = sc.nextLine();
		
		System.out.print("Digite o telefone: ");
		String telefone = sc.nextLine();
		
		System.out.print("Digite o identidade: ");
		String identidade = sc.nextLine();
		
		Pessoa pessoa = new Pessoa(nome, sexo, endereco, cpf, telefone, identidade);
		return pessoa;
	}
	
	public void cadastrarMedico () {
		Pessoa pessoa = cadastrarPessoa();
		
		System.out.print("Digite o crm do medico: ");
		int crm = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Digite o especialidade do medico: ");
		String especialidade = sc.nextLine();					
							
		Medico medico = new Medico(pessoa.getNome(),
								   pessoa.getSexo(), 
								   pessoa.getEndereco(),
								   pessoa.getCpf(),
								   pessoa.getTelefone(),
								   pessoa.getIdentidade(),
								   crm, 
								   especialidade);
		
		medicos.add(medico);
	    
		System.out.println("\n- MEDICO CADASTRADO COM SUCESSO!");
	}
	
	public void cadastrarPaciente () {
		Pessoa pessoa = cadastrarPessoa();
		
		System.out.print("Digite o relato do paciente: ");
		String relato = sc.nextLine();
		
		System.out.print("Digite o medicacao consumida regularmente do paciente: ");
		String medicacaoConsumidaRegularmente = sc.nextLine();
							
		Paciente paciente = new Paciente(pessoa.getNome(),
								   pessoa.getSexo(), 
								   pessoa.getEndereco(),
								   pessoa.getCpf(),
								   pessoa.getTelefone(),
								   pessoa.getIdentidade(),
								   relato, 
								   medicacaoConsumidaRegularmente);
		
		pacientes.add(paciente);
		(this.contPaciente)++;
		
		System.out.println("\n- PACIENTE CADASTRADO COM SUCESSO!");
	}
		
	public void cadastrarConsulta () {
		System.out.print("Digite a data da consulta: ");
		String data = sc.nextLine();
		
		System.out.print("Digite a hora da consulta: ");
		String hora = sc.nextLine();
		
		boolean existeIgual = false;
		boolean existeMedico = true;
		for (Consulta c : consultas) {
			if((c.getData().equals(data)) && (c.getHora().equals(hora))) {
				existeIgual = true;
				break;
			}
		}
		
		if (!existeIgual) {
			System.out.print("Digite o CPF do paciente: ");
			String cpfPaciente = sc.nextLine();
			
			boolean existePaciente = false;
			for(Paciente p : pacientes) {
				if (p.getCpf().equals(cpfPaciente)) {
					existePaciente = true;
					System.out.print("Digite o CRM do medico: ");
					int crmMedico = sc.nextInt();
					sc.nextLine();	
					
					existeMedico = false;
					for (Medico m : medicos) {
						if(m.getCrm() == crmMedico) {
							existeMedico = true;
							System.out.print("Digite o diagnostico da consulta: ");
							String diagnostico = sc.nextLine();
							
							System.out.print("Digite a receita medica: ");
							String receitaMedica = sc.nextLine();				
												
							Consulta consulta = new Consulta(data, hora, cpfPaciente, crmMedico, diagnostico, receitaMedica);
						    consultas.add(consulta);
						    
						    p.getConsultas().add(consulta);
						    m.getConsultas().add(consulta);
						    
						    System.out.println("\n- CONSULTA CADASTRADA COM SUCESSO!");
							break;
						}
					}
					break;
				}
			}
			
			if(!existeMedico) System.out.println("\n- MEDICO NAO ENCONTRADO!");
			if(!existePaciente) System.out.println("\n- PACIENTE NAO ENCONTRADO!");
		} else System.out.println("EXISTE UMA CONSULTA NESTE HORARIO!");
	}
	
	public void removerMedico () {
		System.out.println("!! TODAS AS CONSULTAS DESSE MEDICO SERAO APAGADAS !!");
		System.out.print("Digite o CRM do médico que sera removido: ");
		int crmProcurado = sc.nextInt();
	    sc.nextLine();
	    Medico medico = procurarMedico(crmProcurado);
	    
	    if(medico != null) {
			if (!consultas.isEmpty()) {
				for(Consulta consulta : consultas) {
					if(consulta.getCrmMedico() == medico.getCrm()) {
						consultas.remove(consulta);
						
						for(Paciente paciente : pacientes) paciente.getConsultas().remove(consulta);
					}	
					
					medicos.remove(medico);		
					System.out.println("\n- MEDICO REMOVIDO COM SUCESSO!");
					break;
				}						
			}
	    }
		
	}
	
	public void removerPaciente () {
		System.out.println("!! TODAS AS CONSULTAS DESSE PACIENTE SERAO APAGADAS !!");
		System.out.print("Digite o CPF do paciente que sera removido: ");
		String cpfProcurado = sc.nextLine();
		Paciente paciente = procurarPaciente(cpfProcurado);
		
		if(paciente != null) {
			pacientes.remove(paciente);
				if (!consultas.isEmpty()) {
					for(Consulta consulta : consultas) {
						if(consulta.getCpfPaciente() == paciente.getCpf()) {
							consultas.remove(consulta);
							for(Medico medico : medicos) medico.getConsultas().remove(consulta);
						}		
					break;
				}						
			}
			this.contPaciente--;
			System.out.println("\n- PACIENTE REMOVIDO COM SUCESSO!");

		}

	}
	
	public void removerConsulta () {
		System.out.print("Digite a data da consulta que sera removida: ");
		String data = sc.nextLine();
		
		System.out.print("Digite a hora da consulta que sera removida: ");
		String hora = sc.nextLine();	
		
		System.out.print("Digite o CPF do paciente da consulta que sera removida: ");
		String cpfPaciente = sc.nextLine();
		
		Paciente p = procurarPaciente(cpfPaciente);
		if (p != null) {
			System.out.print("Digite o CRM do medico da consulta que sera removida: ");
			int crmMedico = sc.nextInt();
			sc.nextLine();	
			
			Medico m = procurarMedico(crmMedico);	
			if(m != null) {	
				
				Consulta consulta = procurarConsulta(data, hora, cpfPaciente, crmMedico);
				if(consulta != null) {
					consultas.remove(consulta);	
		
					p.getConsultas().remove(consulta);
					m.getConsultas().remove(consulta);	
					System.out.println("\n- CONSULTA REMOVIDA COM SUCESSO!");
				}
			}
		}
	}
	
	public void alterarMedico () {
		System.out.print("Digite o CRM do Medico que sera alterado: ");
		int crmMedico = sc.nextInt();
		sc.nextLine();
		
		Medico medico = procurarMedico(crmMedico); 
		if(medico != null) {
			System.out.println("-------------------------------");
			System.out.println("O que voce deseja alterar? ");
			System.out.println("Digite 1: Nome");
			System.out.println("Digite 2: Sexo");
			System.out.println("Digite 3: Endereco");
			System.out.println("Digite 4: CPF");
			System.out.println("Digite 5: Telefone");
			System.out.println("Digite 6: Identidade");
			System.out.println("Digite 7: CRM");
			System.out.println("Digite 8: Especialidade");
			System.out.println("Digite 9: Todas as informacoes");
			int resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("-------------------------------\n");
			
			switch(resposta) {
				case 1:
					System.out.print("Digite o novo nome: ");
					String nome = sc.nextLine();
					
					medico.setNome(nome);
					System.out.println("\n- NOME ALTERADO COM SUCESSO!");
					break;
					
				case 2:
					System.out.print("Digite o novo sexo: ");
					char sexo = sc.next().charAt(0);
					sc.nextLine();
					
					medico.setSexo(sexo);
					System.out.println("\n- SEXO ALTERADO COM SUCESSO!");
					break;
					
				case 3:
					System.out.print("Digite o novo endereco: ");
					String endereco = sc.nextLine();
					
					medico.setEndereco(endereco);
					System.out.println("\n- ENDERECO ALTERADO COM SUCESSO!");
					break;
					
				case 4:
					System.out.print("Digite o novo CPF: ");
					String cpf = sc.nextLine();
					
					medico.setCpf(cpf);
					System.out.println("\n- CPF ALTERADO COM SUCESSO!");
					break;
					
				case 5:
					System.out.print("Digite o novo telefone: ");
					String telefone = sc.nextLine();
					
					medico.setTelefone(telefone);
					System.out.println("\n- TELEFONE ALTERADO COM SUCESSO!");
					break;
					
				case 6:
					System.out.print("Digite o novo identidade: ");
					String identidade = sc.nextLine();
					
					medico.setIdentidade(identidade);
					System.out.println("\n- IDENTIDADE ALTERADA COM SUCESSO!");
					break;
					
				case 7:
					System.out.print("Digite o novo CRM: ");
					int crm = sc.nextInt();
					sc.nextLine();
					
					medico.setCrm(crm);
					System.out.println("\n- CRM ALTERADO COM SUCESSO!");
					break;
					
				case 8:
					System.out.print("Digite a nova especialidade: ");
					String especilidade = sc.nextLine();
					
					medico.setEspecialidade(especilidade);
					System.out.println("\n- ESPECIALIDADE ALTERADA COM SUCESSO!");
					break;
					
				case 9:
					System.out.print("Digite o novo nome: ");
					String nome1 = sc.nextLine();
					medico.setNome(nome1);
					
					System.out.print("Digite o novo sexo: ");
					char sexo1 = sc.next().charAt(0);
					sc.nextLine();
					medico.setSexo(sexo1);

					System.out.print("Digite o novo endereco: ");
					String endereco1 = sc.nextLine();
					medico.setEndereco(endereco1);
					
					System.out.print("Digite o novo CPF: ");
					String cpf1 = sc.nextLine();
					medico.setCpf(cpf1);

					System.out.print("Digite o novo telefone: ");
					String telefone1 = sc.nextLine();
					medico.setTelefone(telefone1);

					System.out.print("Digite o novo identidade: ");
					String identidade1 = sc.nextLine();
					medico.setIdentidade(identidade1);
					
					System.out.print("Digite o novo CRM: ");
					int crm1 = sc.nextInt();
					sc.nextLine();
					medico.setCrm(crm1);

					System.out.print("Digite a nova especialidade: ");
					String especilidade1 = sc.nextLine();
					medico.setEspecialidade(especilidade1);

					System.out.println("\n- INFORMACOES ALTERADAS COM SUCESSO!");
					break;
			}
		}
	}
	
	public void alterarPaciente () {
		System.out.print("Digite o CPF do Paciente que sera alterado: ");
		String cpfPaciente = sc.nextLine();
		
		Paciente paciente = procurarPaciente(cpfPaciente);
		if(paciente != null) {
			System.out.println("-------------------------------");				
			System.out.println("O que voce deseja alterar? ");
			System.out.println("Digite 1: Nome");
			System.out.println("Digite 2: Sexo");
			System.out.println("Digite 3: Endereco");
			System.out.println("Digite 4: CPF");
			System.out.println("Digite 5: Telefone");
			System.out.println("Digite 6: Identidade");
			System.out.println("Digite 7: Relato");
			System.out.println("Digite 8: Medicacao Consumida Regularmente");
			System.out.println("Digite 9: Todas as informacoes");
			int resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("-------------------------------\n");
			
			switch(resposta) {
				case 1:
					System.out.print("Digite o novo nome: ");
					String nome = sc.nextLine();
					
					paciente.setNome(nome);
					System.out.println("\n- NOME ALTERADO COM SUCESSO!");
					break;
					
				case 2:
					System.out.print("Digite o novo sexo: ");
					char sexo = sc.next().charAt(0);
					sc.nextLine();
					
					paciente.setSexo(sexo);
					System.out.println("\n- SEXO ALTERADO COM SUCESSO!");
					break;
					
				case 3:
					System.out.print("Digite o novo endereco: ");
					String endereco = sc.nextLine();
					
					paciente.setEndereco(endereco);
					System.out.println("\n- ENDERECO ALTERADO COM SUCESSO!");
					break;
					
				case 4:
					System.out.print("Digite o novo CPF: ");
					String cpf = sc.nextLine();
					
					paciente.setCpf(cpf);
					System.out.println("\n- CPF ALTERADO COM SUCESSO!");
					break;
					
				case 5:
					System.out.print("Digite o novo telefone: ");
					String telefone = sc.nextLine();
					
					paciente.setTelefone(telefone);
					System.out.println("\n- TELEFONE ALTERADO COM SUCESSO!");
					break;
					
				case 6:
					System.out.print("Digite o novo identidade: ");
					String identidade = sc.nextLine();
					
					paciente.setIdentidade(identidade);
					System.out.println("\n- IDENTIDADE ALTERADA COM SUCESSO!");
					break;
					
				case 7:
					System.out.print("Digite o novo relato: ");
					String relato = sc.nextLine();
					
					paciente.setRelato(relato);
					System.out.println("\n- RELATO ALTERADO COM SUCESSO!");
					break;
					
				case 8:
					System.out.print("Digite a nova Medicacao Consumida Regularmente: ");
					String medicacaoConsumidaRegularmente = sc.nextLine();
					
					paciente.setMedicacaoConsumidaRegularmente(medicacaoConsumidaRegularmente);
					System.out.println("\n- MEDICACAO CONSUMIDA REGURLAMENTE ALTERADA COM SUCESSO!");
					break;
					
				case 9:
					System.out.print("Digite o novo nome: ");
					String nome1 = sc.nextLine();
					paciente.setNome(nome1);
					
					System.out.print("Digite o novo sexo: ");
					char sexo1 = sc.next().charAt(0);
					sc.nextLine();
					paciente.setSexo(sexo1);

					System.out.print("Digite o novo endereco: ");
					String endereco1 = sc.nextLine();
					paciente.setEndereco(endereco1);
					
					System.out.print("Digite o novo CPF: ");
					String cpf1 = sc.nextLine();
					paciente.setCpf(cpf1);

					System.out.print("Digite o novo telefone: ");
					String telefone1 = sc.nextLine();
					paciente.setTelefone(telefone1);

					System.out.print("Digite o novo identidade: ");
					String identidade1 = sc.nextLine();
					paciente.setIdentidade(identidade1);

					System.out.print("Digite o novo relato: ");
					String relato1 = sc.nextLine();
					paciente.setRelato(relato1);

					System.out.print("Digite a nova Medicacao Consumida Regularmente: ");
					String medicacaoConsumidaRegularmente1 = sc.nextLine();
					paciente.setMedicacaoConsumidaRegularmente(medicacaoConsumidaRegularmente1);
					
					System.out.println("\n- INFORMACOES ALTERADAS COM SUCESSO!");
					break;
			}
		}
	}

	public void alterarConsulta () {
		System.out.print("Digite a data da consulta que sera alterada: ");
		String data = sc.nextLine();
		
		System.out.print("Digite a hora da consulta que sera alterada: ");
		String hora = sc.nextLine();	
		
		System.out.print("Digite o CPF do paciente da consulta que sera alterada: ");
		String cpfPaciente = sc.nextLine();
		
		System.out.print("Digite o CRM do medico da consulta que sera alterada: ");
		int crmMedico = sc.nextInt();
		sc.nextLine();	
		
		Consulta consulta =  procurarConsulta(data, hora, cpfPaciente, crmMedico);
		if(consulta != null) {
			System.out.println("-------------------------------");	
			System.out.println("O que voce deseja alterar? ");
			System.out.println("Digite 1: Data");
			System.out.println("Digite 2: Hora");
			System.out.println("Digite 3: CPF do Paciente");
			System.out.println("Digite 4: CRM do Médico");
			System.out.println("Digite 5: Diagnostico");
			System.out.println("Digite 6: Receita Medica");
			System.out.println("Digite 7: Todas as informacoes");
			int resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("-------------------------------\n");
			
			switch(resposta) {
				case 1:
					System.out.print("Digite a nova data: ");
					String data1 = sc.nextLine();
					
					consulta.setData(data1);
					System.out.println("\n- DATA ALTERADA COM SUCESSO!");
					break;
					
				case 2:
					System.out.print("Digite a nova hora: ");
					String hora1 = sc.nextLine();
					
					consulta.setHora(hora1);
					System.out.println("\n- HORA ALTERADA COM SUCESSO!");
					break;
					
				case 3:
					System.out.print("Digite o novo CPF do Paciente: ");
					String cpf = sc.nextLine();
					
					consulta.setCpfPaciente(cpf);
					System.out.println("\n- CPF ALTERADO COM SUCESSO!");
					break;
					
				case 4:
					System.out.print("Digite o novo CRM do Medico: ");
					int crm = sc.nextInt();
					sc.nextLine();
					
					consulta.setCrmMedico(crm);
					System.out.println("\n- CRM ALTERADO COM SUCESSO!");
					break;
					
				case 5:
					System.out.print("Digite o novo diagnostico: ");
					String diagnostico = sc.nextLine();
					
					consulta.setDiagnostico(diagnostico);
					System.out.println("\n- DIAGNOSTICO ALTERADO COM SUCESSO!");
					break;
					
				case 6:
					System.out.print("Digite o nova receita medica: ");
					String receitaMedica = sc.nextLine();
					
					consulta.setReceitaMedica(receitaMedica);
					System.out.println("\n- RECEITA MEDICA ALTERADA COM SUCESSO!");
					break;
																
				case 7:
					System.out.print("Digite a nova data: ");
					String data2 = sc.nextLine();
					consulta.setData(data2);
					
					System.out.print("Digite a nova hora: ");
					String hora2 = sc.nextLine();
					consulta.setHora(hora2);

					System.out.print("Digite o novo CPF do Paciente: ");
					String cpf1 = sc.nextLine();
					consulta.setCpfPaciente(cpf1);	

					System.out.print("Digite o novo CRM do Medico: ");
					int crm1 = sc.nextInt();
					sc.nextLine();						
					consulta.setCrmMedico(crm1);

					System.out.print("Digite o novo diagnostico: ");
					String diagnostico1 = sc.nextLine();
					consulta.setDiagnostico(diagnostico1);

					System.out.print("Digite o novo receita medica: ");
					String receitaMedica1 = sc.nextLine();
					consulta.setReceitaMedica(receitaMedica1);
					
					System.out.println("\n- INFORMACOES ALTERADAS COM SUCESSO!");
					break;
			}				
		}
	}

	public void registrarDiagnostico () {
		System.out.print("Digite a data da consulta: ");
		String data = sc.nextLine();
		
		System.out.print("Digite a hora da consulta: ");
		String hora = sc.nextLine();	
		
		System.out.print("Digite o CPF do paciente da consulta: ");
		String cpfPaciente = sc.nextLine();
		
		Paciente p = procurarPaciente(cpfPaciente);
		if (p != null) {
			System.out.print("Digite o CRM do medico da consulta: ");
			int crmMedico = sc.nextInt();
			sc.nextLine();	
			
			Medico m = procurarMedico(crmMedico);	
			if(m != null) {	
				Consulta consulta = procurarConsulta(data, hora, cpfPaciente, crmMedico);
				if(consulta != null) {
					System.out.print("Digite o novo diagnostico: ");
					String diagnostico = sc.nextLine();
					
					consulta.setDiagnostico(diagnostico);
					System.out.println("\n- DIAGNOSTICO ALTERADO COM SUCESSO!");
				}
			}
		}
	}

	public void imprimirMedico () {
		System.out.print("Digite o CRM do Medico: ");
		int crmMedico = sc.nextInt();
		sc.nextLine();
				
		Medico medico = procurarMedico(crmMedico);
		if(medico != null) {
			System.out.println(); 
			medico.imprimir();	
		}
	}
	
	public void imprimirPaciente () {
		System.out.print("Digite o CPF do Paciente: ");
		String cpfPaciente = sc.nextLine();
		
		Paciente paciente = procurarPaciente(cpfPaciente);
		if(paciente != null) {
			System.out.println(); 
			paciente.imprimir();
		}
	}
	
	public void imprimirConsulta () {
		System.out.print("Digite a data da consulta: ");
		String data = sc.nextLine();
		
		System.out.print("Digite a hora da consulta: ");
		String hora = sc.nextLine();	
		
		System.out.print("Digite o CPF do paciente da consulta: ");
		String cpfPaciente = sc.nextLine();
		
		Paciente p = procurarPaciente(cpfPaciente);
		if(p != null) {
			System.out.print("Digite o CRM do medico da consulta: ");
			int crmMedico = sc.nextInt();
			sc.nextLine();	
			
			Medico m = procurarMedico(crmMedico);
			if(m != null) {
				Consulta consulta = procurarConsulta(data, hora, cpfPaciente, crmMedico);
				if(consulta != null) {
					System.out.println(); 
					consulta.imprimir();	
				}
			}
		}
	}
	
	public void imprimirConsultasDeUmMedico () {
		System.out.print("Digite o CRM do Medico: ");
		int crmMedico = sc.nextInt();
		sc.nextLine();
		
		Medico medico = procurarMedico(crmMedico);
		if(medico != null) {
			if(medico.getConsultas().isEmpty()) System.out.println("\n- ESTE MEDICO AINDA NAO TEM CONSULTAS AGENDADAS!");
			else {
				System.out.println("\n- CONSULTAS: ");
				int aux = 0;
				for(Consulta consulta : consultas) {
					System.out.println("- " + ++aux + "º: ");
					consulta.imprimir();
				}
			}
		}
	}

	public void imprimirConsultasDeUmPaciente () {
		System.out.print("Digite o CPF do Paciente: ");
		String cpfPaciente = sc.nextLine();
		
		Paciente paciente = procurarPaciente(cpfPaciente);
		if(paciente != null) {				
			if(paciente.getConsultas().isEmpty()) System.out.println("\n- ESTE MEDICO AINDA NAO TEM CONSULTAS AGENDADAS!");
			else {
				int aux = 0;
				System.out.println("\n- CONSULTAS: ");
				for(Consulta consulta : consultas) {
					System.out.println("- " + ++aux + "º: ");
					consulta.imprimir();
				}
			}
		}
	}

	public void imprimirListaDeMedicos () {
		if (medicos.isEmpty()) {
			System.out.println("\n- NAO EXISTE MEDICOS CADASTRADOS!");
	    } else {
			System.out.println("- MEDICOS: ");
			int aux = 0;
			for(Medico medico : medicos) {
				System.out.println("- " + ++aux + "º: ");
				medico.imprimir();
				System.out.println("------------------");
			}
	    }
	}
	
	public void imprimirListaDePacientes() {
		if (pacientes.isEmpty()) {
			System.out.println("\n- NAO EXISTE PACIENTES CADASTRADOS!");
	    } else {
			System.out.println("- PACIENTES: ");
			int aux = 0;
			for(Paciente paciente : pacientes) {
				System.out.println("- " + ++aux + "º: ");
				paciente.imprimir();
				System.out.println("------------------");
			}
	    }
	}
	
	public void imprimirListaDeConsultas () {
		if (pacientes.isEmpty()) {
			System.out.println("\n- NAO EXISTE CONSULTAS CADASTRADOS!");
	    } else {
			System.out.println("- CONSULTAS: ");
			int aux = 0;
			for(Consulta consulta : consultas) {
				System.out.println("- " + ++aux + "º: ");
				consulta.imprimir();
				System.out.println("------------------");
			}
	    }
	}
	
	public void consultarConsulta(Consulta c) {
		Consulta consulta = procurarConsulta(c.getData(), c.getHora(), c.getCpfPaciente(), c.getCrmMedico());
		if(consulta != null) consulta.imprimir();							
	}
		
	public void imprimir () {
		System.out.println("Nome: " + this.nome);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Endereco: " + this.endereco);
		System.out.println("Quantidade de Pacientes: " +this.contPaciente);
		
		imprimirListaDeMedicos();
		imprimirListaDePacientes();;
		imprimirListaDeConsultas();
	}

}