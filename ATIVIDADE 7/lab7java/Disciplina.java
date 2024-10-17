package lab7java;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private String nome;
	private String CH;
	private Professor professor;
	private List<Aluno> alunos;
	
	public Disciplina(String nome, String CH, Professor professor) {
        this.nome = nome;
        this.CH = CH;
        this.professor = professor;
        alunos = new ArrayList<Aluno>();
    }

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCH() {
		return CH;
	}
	public void setCH(String cH) {
		CH = cH;
	}

	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void imprimir () {
		System.out.println("Nome da disciplina: " + this.nome);
		System.out.println("CH: " + this.CH);
		System.out.println("Professor: " + this.getProfessor().getNome());
		System.out.println("Titulacao do professor: " + this.getProfessor().getTitulacao());
				
		if (alunos.isEmpty()) {
			System.out.println("Essa disciplinas nao tem alunos cadastrados!");
		} else {
			System.out.println("Alunos: ");
			for(Aluno aluno : alunos) {
				System.out.println("Nome do aluno: " + aluno.getNome());
				System.out.println("Numero da matricula: " + aluno.getMatricula());
				System.out.println("----------------\n");
			}
		}
	}
}
