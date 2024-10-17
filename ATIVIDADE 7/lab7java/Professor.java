package lab7java;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
	private String titulacao;
	private String curso;
	private List<Disciplina> disciplinas;

	public Professor(String nome, String sexo, String endereco, String cpf, String telefone, String identidade, String titulacao, String curso) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
		this.titulacao = titulacao;
		this.curso = curso;
		disciplinas = new ArrayList<Disciplina> ();
	}
	
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
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
		System.out.println("Titulacao: " + this.titulacao);
		System.out.println("Curso: " + this.curso + "\n");
		
		if(disciplinas.isEmpty()) {
			System.out.println("Esse professor nao esta cadastrado em nenhuma disciplina!"); 
		} else {
			System.out.println("Disciplinas: ");
			for(Disciplina disciplina : disciplinas) {
				System.out.println("Nome da disciplina: " + disciplina.getNome());
				System.out.println("CH: " + disciplina.getCH());
				System.out.println("----------------\n");
			}
		}	
	}
}
