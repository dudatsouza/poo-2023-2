package lab7java;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
	private int matricula; 
	private List<Disciplina> disciplinas;

	public Aluno(String nome, String sexo, String endereco, String cpf, String telefone, String identidade, int matricula) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
		this.matricula = matricula;
		disciplinas = new ArrayList<Disciplina> ();
	}	
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Numero de matricula: " + this.matricula + "\n");
		
		if(disciplinas.isEmpty()) {
			System.out.println("Esse aluno nao esta cadastrado em nenhuma disciplina!"); 
		} else {
			System.out.println("Disciplinas: ");
			for(Disciplina disciplina : disciplinas) {
				System.out.println("Nome da disciplina: " + disciplina.getNome());
				System.out.println("CH: " + disciplina.getCH());
				System.out.println("Professor: " + disciplina.getProfessor().getNome());
				System.out.println("----------------\n");
			}
		}
	}	
}
