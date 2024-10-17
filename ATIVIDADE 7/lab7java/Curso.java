package lab7java;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
	Scanner sc = new Scanner (System.in);

	private String nome;
	private int codCurso;
	private String descricao;
	private String duracao;

	List<Professor> professores;
	List<Aluno> alunos;
	List<Disciplina> disciplinas;
	
	public Curso (String nome, int codCurso, String descricao, String duracao) {
		this.nome = nome;
		this.codCurso = codCurso;
		this.descricao = descricao;
		this.duracao = duracao;
		professores = new ArrayList<Professor> ();
		alunos = new ArrayList<Aluno> ();
		disciplinas = new ArrayList<Disciplina> ();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public Pessoa cadastrarPessoa () {
		System.out.print("Digite o nome do medico: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite o sexo do medico: ");
		String sexo = sc.nextLine();
		
		System.out.print("Digite o endereco do medico: ");
		String endereco = sc.nextLine();
		
		System.out.print("Digite o CPF do medico: ");
		String cpf = sc.nextLine();
		
		System.out.print("Digite o telefone do medico: ");
		String telefone = sc.nextLine();
		
		System.out.print("Digite o identidade do medico: ");
		String identidade = sc.nextLine();
		
		Pessoa pessoa = new Pessoa(nome, sexo, endereco, cpf, telefone, identidade);
		return pessoa;
	}
	
	public void cadastrarProfessor() {
		Pessoa pessoa = cadastrarPessoa();
		
		System.out.print("Digite a titulacao do professor que será cadstrado neste curso: ");
		String titulacao = sc.nextLine();	
		
		Professor professor = new Professor(pessoa.getNome(), 
											pessoa.getSexo(), 
											pessoa.getEndereco(), 
											pessoa.getCpf(), 
											pessoa.getTelefone(), 
											pessoa.getIdentidade(), 
											titulacao, 
											this.nome);
		professores.add(professor);
		
		System.out.println("Professor cadastrado com sucesso!");
	}
	
	public void cadastrarAluno() {
		Pessoa pessoa = cadastrarPessoa();
		
		System.out.print("Digite a matricula do aluno que será cadstrado neste curso: ");
		int matricula = sc.nextInt();
		sc.nextLine();	
		
		Aluno aluno = new Aluno(pessoa.getNome(), 
								pessoa.getSexo(), 
								pessoa.getEndereco(), 
								pessoa.getCpf(), 
								pessoa.getTelefone(), 
								pessoa.getIdentidade(),
								matricula);
		alunos.add(aluno);
		
		System.out.println("Aluno cadastrado com sucesso!");
	}
	
	public void cadastrarDisciplina() {
		int resposta = 0;
		do {
			System.out.println("Para cadastrar uma disciplina voce precisa de um professor, voce deseja colocar um ja existente ou cadastrar um? ");
			System.out.println("Digite 1: Cadastrar um professor");
			System.out.println("Digite 0: Continuar com um existente");
			resposta = sc.nextInt();
			sc.nextLine();
			
			if (resposta == 1) {
				cadastrarProfessor();
			}
			
		} while (resposta != 0);
				
		System.out.print("Digite o nome da disciplina que será cadstrado neste curso: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite o CH da displina que será cadstrado neste curso: ");
		String CH = sc.nextLine();
		
		System.out.print("Digite o nome do professor da disciplina que será cadstrado neste curso: ");
		String nomeProfessor = sc.nextLine();
		
		System.out.print("Digite a titulacao do professor da disciplina que será cadstrado neste curso: ");
		String titulacao = sc.nextLine();
		
		Disciplina disciplina = null;
		
		boolean existeProfessor = false;
		for (Professor professor : professores) {
			if ((professor.getNome().equals(nomeProfessor)) &&
				(professor.getTitulacao().equals(titulacao))) {
					existeProfessor = true; 

					disciplina = new Disciplina(nome, CH, professor);
					disciplinas.add(disciplina);
					professor.getDisciplinas().add(disciplina);
					
					System.out.println("Aluno cadastrado com sucesso!");
					break;
			}
		}
		
		if (!existeProfessor) System.out.println("Professor nao encontrado, tente cadastrá-lo!\n");
	}
			
	public void cadastrarAlunoAUmaDisciplina () {
		int resposta = 0;
		do {
			System.out.println("Voce deseja colocar um aluno ja existente ou cadastrar um? ");
			System.out.println("Digite 1: Cadastrar um aluno");
			System.out.println("Digite 0: Continuar com um existente");
			resposta = sc.nextInt();
			sc.nextLine();
			
			if (resposta == 1) {
				cadastrarAluno();
			}
			
		} while (resposta != 0);
					
		System.out.print("Digite a matricula do aluno: ");
		int matricula = sc.nextInt();
		sc.nextLine();
		
		do {
			System.out.println("Voce deseja colocar em uma disciplina ja existente ou cadastrar uma? ");
			System.out.println("Digite 1: Cadastrar disciplina");
			System.out.println("Digite 0: Continuar com uma existente");
			resposta = sc.nextInt();
			sc.nextLine();
			
			if (resposta == 1) {
				cadastrarDisciplina();
			}
			
		} while (resposta != 0);
					
		System.out.print("Digite o nome da disciplina: ");
		String nomeDisciplina = sc.nextLine();
		
		System.out.print("Digite o nome do professor da disciplina: ");
		String nomeProfessor = sc.nextLine();		
			
		boolean existeAluno = false;
		boolean existeDisciplina = false;
		
		for (Aluno aluno : alunos) {
			if(aluno.getMatricula() == matricula) {
				existeAluno = true;
				for(Disciplina disciplina : disciplinas) {
					if ((disciplina.getNome().equals(nomeDisciplina)) && 
						(disciplina.getProfessor().getNome().equals(nomeProfessor))) {
						existeDisciplina =true;
						disciplina.getAlunos().add(aluno);
						System.out.println("Aluno cadastrado com sucesso!");
						break;
					} 
				}
			} 
		}
		
		if (!existeDisciplina) System.out.println("Disciplina nao encontrada!");
		if (!existeAluno) System.out.println("Aluno nao encontrado!");
		
	}

	public void excluirProfessor()  {
		System.out.print("Digite o nome do professor: ");
		String nomeProfessor = sc.nextLine();
		
		System.out.print("Digite a titulacao do professor: ");
		String titulacao = sc.nextLine();
		
		boolean existeProfessor = false;
		for (Professor professor : professores) {
			if ((professor.getNome().equals(nomeProfessor)) &&
				(professor.getTitulacao().equals(titulacao))) {
					existeProfessor = true; 
					professores.remove(professor);
					
					if (!professor.getDisciplinas().isEmpty()) 
						System.out.println("Para poder excluir um professor que esta cadastrado em uma disciplina, " +
										   "é necessario trocar o professor da disciplina!");
					while(!professor.getDisciplinas().isEmpty()) {
						trocarDeProfessorDeUmaDisciplina();
					}
					
					System.out.println("Professor excluido com sucesso!");
					break;
			}
		}
		
		if (!existeProfessor) System.out.println("Professor nao encontrado, tente cadastrá-lo!\n");	
	}
	
	public void excluirAluno()  {
		System.out.print("Digite a matricula do aluno: ");
		int matricula = sc.nextInt();
		sc.nextLine();
		
		boolean existeAluno = false;
		
		for (Aluno aluno : alunos) {
			if(aluno.getMatricula() == matricula) {
				existeAluno = true;
				alunos.remove(aluno);
				
				for(Disciplina disciplina : aluno.getDisciplinas()) {
					disciplina.getAlunos().remove(aluno);
				}
				
				System.out.println("Aluno excluido com sucesso!");
				break;
			} 
		}
		
		if (!existeAluno) System.out.println("Aluno nao encontrado!");
	}
	
	public void excluirDisciplina()  {
		System.out.print("Digite o nome da disciplina: ");
		String nomeDisciplina = sc.nextLine();
		
		System.out.print("Digite o nome do professor dessa disciplina: ");
		String nomeProfessor = sc.nextLine();
		
		System.out.print("Digite a titulacao do professor dessa disciplina: ");
		String titulacao = sc.nextLine();
		
		boolean existeDisciplina = false;
		
		for(Disciplina disciplina : disciplinas) {
			if((disciplina.getNome().equals(nomeDisciplina)) &&
			   (disciplina.getProfessor().getNome().equals(nomeProfessor)) && 
			   (disciplina.getProfessor().getTitulacao().equals(titulacao)) ) {
				existeDisciplina = true;
				
				disciplinas.remove(disciplina);
				
				for (Aluno aluno : alunos) {
					aluno.getDisciplinas().remove(disciplina);
				}
				
				for (Professor professor : professores) {
					professor.getDisciplinas().remove(disciplina);
				}	
				
				System.out.println("Disciplina excluida com sucesso!");
				break;
			}
		}
		
		if (!existeDisciplina) System.out.println("Disciplina nao encontrado!");
	}
	
	public void removerAlunoDeUmaDisciplina() {

		System.out.print("Digite a matricula do aluno: ");
		int matricula = sc.nextInt();
		sc.nextLine();
		
		boolean existeAluno = false;
		boolean existeDisciplina = true;
		
		for (Aluno aluno : alunos) {
			if(aluno.getMatricula() == matricula) {
				existeAluno = true;
				
				System.out.print("Digite o nome da disciplina: ");
				String nomeDisciplina = sc.nextLine();
				
				System.out.print("Digite o nome do professor dessa disciplina: ");
				String nomeProfessor = sc.nextLine();
				
				System.out.print("Digite a titulacao do professor dessa disciplina: ");
				String titulacao = sc.nextLine();
				
				existeDisciplina = false;
				for(Disciplina disciplina : disciplinas) {
					if((disciplina.getNome().equals(nomeDisciplina)) &&
					   (disciplina.getProfessor().getNome().equals(nomeProfessor)) && 
					   (disciplina.getProfessor().getTitulacao().equals(titulacao)) ) {
						existeDisciplina = true;
						
						disciplina.getAlunos().remove(aluno);
						aluno.getDisciplinas().remove(disciplina);
						
						System.out.println("Aluno removido dessa disciplina com sucesso!");
						break;
					}
				}
				
				break;
			}
		}
		
		if (!existeAluno) System.out.println("Aluno nao encontrado!");
		if (!existeDisciplina) System.out.println("Disciplina nao encontrado!");	
	}
	
	public void trocarDeProfessorDeUmaDisciplina() {
		int resposta = 0;
		do {
			System.out.println("Para que possamos trocar os professores, precisamos que ambos existam!");
			System.out.println("Digite 1: Cadastrar professor");
			System.out.println("Digite 0: Continuar com professores existentes");
			resposta = sc.nextInt();
			sc.nextLine();
			
			if (resposta == 1) {
				cadastrarProfessor();
			}
			
		} while (resposta != 0);
					
		System.out.print("Digite o nome do atual professor: ");
		String nomeProfessorAtual = sc.nextLine();
		
		System.out.print("Digite a titulacao do atual professor: ");
		String titulacaoAtual = sc.nextLine();
		
		System.out.print("Digite o nome do novo professor: ");
		String nomeProfessorNovo = sc.nextLine();
		
		System.out.print("Digite a titulacao do novo professor: ");
		String titulacaoNovo = sc.nextLine();
		
		boolean existeProfessorAtual = false;
		boolean existeProfessorNovo = true;
		boolean existeDisciplina = true;
		
		for (Professor professor : professores) {
			if ((professor.getNome().equals(nomeProfessorAtual)) &&
				(professor.getTitulacao().equals(titulacaoAtual))) {
					existeProfessorAtual = true; 
					
					existeProfessorNovo = false;
					for (Professor professor1 : professores) {
						if ((professor1.getNome().equals(nomeProfessorNovo)) &&
							(professor1.getTitulacao().equals(titulacaoNovo))) {
								existeProfessorNovo = true; 
								
								System.out.print("Digite o nome da disciplina: ");
								String nomeDisciplina = sc.nextLine();
								
								existeDisciplina = false;
								for (Disciplina disciplina : disciplinas) {
									if((disciplina.getNome().equals(nomeDisciplina)) &&
									   (disciplina.getProfessor().getNome().equals(nomeProfessorAtual)) &&
									   (disciplina.getProfessor().getTitulacao().equals(titulacaoAtual)) ) {
										existeDisciplina = true;
										
										disciplina.setProfessor(professor1);
										professor.getDisciplinas().remove(disciplina);
										
										System.out.println("Professor trocado com sucesso!");
										break;
									}
								}
								break;
						}
					}
					break;
			}
		}
		
		if(!existeProfessorAtual) System.out.println("Professor atual nao encontrado");
		if(!existeProfessorNovo) System.out.println("Professor novo nao encontrado");
		if(!existeDisciplina) System.out.println("Disciplina nao encontrada");		
					
	}
	
	public void imprimirProfessor() {
		System.out.print("Digite o nome do professor: ");
		String nomeProfessor = sc.nextLine();
		
		System.out.print("Digite a titulacao do professor: ");
		String titulacao = sc.nextLine();
		
		boolean existeProfessor = false;
		for (Professor professor : professores) {
			if ((professor.getNome().equals(nomeProfessor)) &&
				(professor.getTitulacao().equals(titulacao))) {
					existeProfessor = true; 
					professor.imprimir();
					break;
			}
		}
		
		if (!existeProfessor) System.out.println("Professor nao encontrado, tente cadastrá-lo!\n");	
	}
	
	public void imprimirAluno() {
		System.out.print("Digite a matricula do aluno: ");
		int matricula = sc.nextInt();
		sc.nextLine();
		
		boolean existeAluno = false;
		
		for (Aluno aluno : alunos) {
			if(aluno.getMatricula() == matricula) {
				existeAluno = true;
				aluno.imprimir();
				break;
			} 
		}
		
		if (!existeAluno) System.out.println("Aluno nao encontrado!");
	}

	public void imprimirDisciplina() {
		System.out.print("Digite o nome da disciplina: ");
		String nomeDisciplina = sc.nextLine();
		
		System.out.print("Digite o nome do professor dessa disciplina: ");
		String nomeProfessor = sc.nextLine();
		
		System.out.print("Digite a titulacao do professor dessa disciplina: ");
		String titulacao = sc.nextLine();
		
		boolean existeDisciplina = false;
		
		for(Disciplina disciplina : disciplinas) {
			if((disciplina.getNome().equals(nomeDisciplina)) &&
			   (disciplina.getProfessor().getNome().equals(nomeProfessor)) && 
			   (disciplina.getProfessor().getTitulacao().equals(titulacao)) ) {
				existeDisciplina = true;
				disciplina.imprimir();
				break;
			}
		}
		
		if (!existeDisciplina) System.out.println("Disciplina nao encontrado!");		
	}
	
	
	public void imprimirListaDeProfessores() {
		if (professores.isEmpty()) {
			System.out.println("A lista de professores esta vazia.\n");
	    } else {
			for(Professor professor : professores) {
				professor.imprimir();
				System.out.println("-------------------\n");
			}
	    }
	}
	
	
	public void imprimirListaDeAlunos() {
		if (alunos.isEmpty()) {
			System.out.println("A lista de alunos esta vazia.\n");
	    } else {
			for(Aluno aluno : alunos) {
				aluno.imprimir();
				System.out.println("-------------------\n");
			}
	    }
	}
	
	
	public void imprimirListaDeDisciplinas() {
		if (disciplinas.isEmpty()) {
			System.out.println("A lista de disciplinas esta vazia.\n");
	    } else {
			for(Disciplina disciplina : disciplinas) {
				disciplina.imprimir();
				System.out.println("-------------------\n");
			}
	    }
	}

	public void imprimir() {
		System.out.println("Nome do curso: " + this.nome);
		System.out.println("Codigo do curso: " + this.codCurso);
		System.out.println("Descricao: " + this.descricao);
		System.out.println("Duracao: " + this.duracao);
		
		imprimirListaDeProfessores();
		imprimirListaDeAlunos();
		imprimirListaDeDisciplinas();
		
	}

}
