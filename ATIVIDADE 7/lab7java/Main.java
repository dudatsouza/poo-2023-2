package lab7java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Curso> cursos = new ArrayList<Curso>();

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int resposta = 1;
		while(resposta != 0) {
			System.out.println("Digite a opcao desejada: ");
			System.out.println("Digite 1: Cadastrar um Curso");
			System.out.println("Digite 2: Excluir um Curso");
			System.out.println("Digite 3: Listar um Curso");
			System.out.println("Digite 4: Listar todos Curso");	
			System.out.println("Digite 5: Opcoes de um Curso");	
			System.out.println("Digite 0: Sair");
			resposta = sc.nextInt();
			sc.nextLine();
			System.out.println("\n----------------------------");
			
			switch (resposta) {
				case 1: {
					cadastrarCurso(sc);
					break;
				}
				
				case 2: {
					excluirCurso(sc);
					break;
				}
				
				case 3: {
					listarUmCurso(sc);
					break;
				}
				
				case 4: {
					listarTodosOsCursos();
					break;
				}
				
				case 5: {
					opcoesCurso(sc);
					break;
				}
				
				case 0: {
					System.out.println("Muito obrigado por usar nossos servicos!");
					System.exit(0);
					break;
				}
			}
		}
		sc.close();		

	}
	
	public static void cadastrarCurso (Scanner sc) {
		System.out.print("Digite o nome do curso: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite o codigo do curso: ");
		int codCurso = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Digite a descricao do curso: ");
		String descricao = sc.nextLine();
		
		System.out.print("Digite a duracao do curso: ");
		String duracao = sc.nextLine();
		
		Curso curso = new Curso(nome, codCurso, descricao, duracao);	

		cursos.add(curso);
		
		System.out.println("Curso cadastrado com sucesso!");
	}

	public static void excluirCurso (Scanner sc) {
		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia!");
		else {
			System.out.print("Digite o codigo do curso: ");
			int codCurso = sc.nextInt();
			sc.nextLine();
			
			boolean existeCurso = false;
			for(Curso curso : cursos) {
				if(curso.getCodCurso() == codCurso) {
					existeCurso = true;
					cursos.remove(curso);
					System.out.println("Curso removido com sucesso!");
					break;
				}
			}
			
			if(!existeCurso) System.out.println("Curso nao encontrado!");
		}
	}
	
	public static void listarUmCurso (Scanner sc) {
		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia!");
		else {
			System.out.print("Digite o codigo do curso: ");
			int codCurso = sc.nextInt();
			sc.nextLine();
			
			boolean existeCurso = false;
			for(Curso curso : cursos) {
				if(curso.getCodCurso() == codCurso) {
					existeCurso = true;
					curso.imprimir();
					break;
				}
			}
			
			if(!existeCurso) System.out.println("Curso nao encontrado!");
		}
	}
	
	public static void listarTodosOsCursos () {
		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia!");
		else for(Curso curso : cursos) curso.imprimir();
	}
	
	public static void opcoesCurso (Scanner sc) {
		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia! Cadastre um para ver as opcaoes!!");
		else {
			System.out.print("Digite o codigo do curso: ");
			int codCurso = sc.nextInt();
			sc.nextLine();
			
			boolean existeCurso = false;
			for(Curso curso : cursos) {
				if(curso.getCodCurso() == codCurso) {
					existeCurso = true;
					menuOpcoesCurso(curso, sc);
					break;
				}
			}
			
			if(!existeCurso) System.out.println("Curso nao encontrado!");
		}
	}
	
 	public static void menuOpcoesCurso (Curso curso, Scanner sc) {
		int resposta1 = 1;
		while(resposta1 != 0) {
			System.out.println("Digite a opcao desejada: ");
			System.out.println("Digite 1: Cadastrar Professor");
			System.out.println("Digite 2: Cadastrar Aluno");
			System.out.println("Digite 3: Cadastrar Disciplina");
			System.out.println("Digite 4: Cadastrar Aluno em uma Disciplina");
			System.out.println("Digite 5: Excluir Professor");
			System.out.println("Digite 6: Excluir Aluno");
			System.out.println("Digite 7: Excluir Disciplina");
			System.out.println("Digite 8: Remover Aluno em uma Disciplina");
			System.out.println("Digite 9: Trocar professor de uma Disciplina");
			System.out.println("Digite 10: Imprimir Dados de um Professor");
			System.out.println("Digite 11: Imprimir Dados de um Aluno");
			System.out.println("Digite 12: Imprimir Dados de um Disciplina");
			System.out.println("Digite 13: Imprimir Lista de Professores");
			System.out.println("Digite 14: Imprimir Lista de Alunos");
			System.out.println("Digite 15: Imprimir Lista de Disciplinas");
			System.out.println("Digite 0: Sair");
			resposta1 = sc.nextInt();
			sc.nextLine();
			System.out.println("\n----------------------------");
			
			switch (resposta1) {
				case 1: {
					curso.cadastrarProfessor();
					break;
				}
				
				case 2: {
					curso.cadastrarAluno();
					break;
				}
				
				case 3: {
					curso.cadastrarDisciplina();
					break;

				}
				
				case 4: {
					curso.cadastrarAlunoAUmaDisciplina();
					break;
				}
				
				case 5: {
					curso.excluirProfessor();
					break;

				}
				
				case 6: {
					curso.excluirAluno();
					break;
				}
				
				case 7: {
					curso.excluirDisciplina();
					break;

				}
				
				case 8: {
					curso.removerAlunoDeUmaDisciplina();
					break;
				}
				
				case 9: {
					curso.trocarDeProfessorDeUmaDisciplina();
					break;

				}
				
				case 10: {
					curso.imprimirProfessor();
					break;
				}
				
				case 11: {
					curso.imprimirAluno();
					break;

				}
				
				case 12: {
					curso.imprimirDisciplina();
					break;
				}
				
				case 13: {
					curso.imprimirListaDeProfessores();
					break;
				}
				
				case 14: {
					curso.imprimirListaDeAlunos();
					break;
				}
				
				case 15: {
					curso.imprimirListaDeDisciplinas();
					break;
				}				
			}
		}
		sc.close();	
	}
 	
}