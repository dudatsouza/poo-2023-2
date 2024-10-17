package lab10java;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {
	private int crm;
	private String especialidade;
	private List<Consulta> consultas;
	
	public Medico(String nome, char sexo, String endereco, String cpf, String telefone, String identidade, int crm, String especialidade) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
		this.crm = crm;
		this.especialidade = especialidade;
		consultas = new ArrayList<Consulta>();
	}
	
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("CRM: " + this.crm);
		System.out.println("Especialidade: " + this.especialidade);
		
		if(consultas.isEmpty()) System.out.println("\n- ESTE MEDICO NAO TEM CONSULTAS CADASTRADAS!");
		else {
			System.out.println("\n- CONSULTAS: ");
			int aux = 0;
			for(Consulta consulta : consultas) {
				System.out.println("- " + ++aux + "º: ");
				consulta.imprimir();
				System.out.println("------------------");
			}
		}
		
	}
}
