package trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
	private String relato;
	private String medicacaoConsumidaRegularmente;
	private List<Consulta> consultas;

	public Paciente(String nome, char sexo, String endereco, String cpf, String telefone, String identidade, String relato, String medicacaoConsumidaRegularmente) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
		this.relato = relato;
		this.medicacaoConsumidaRegularmente = medicacaoConsumidaRegularmente;
		consultas = new ArrayList<Consulta>();
	}
	
	public String getRelato() {
		return relato;
	}
	public void setRelato(String relato) {
		this.relato = relato;
	}

	public String getMedicacaoConsumidaRegularmente() {
		return medicacaoConsumidaRegularmente;
	}
	public void setMedicacaoConsumidaRegularmente(String medicacaoConsumidaRegularmente) {
		this.medicacaoConsumidaRegularmente = medicacaoConsumidaRegularmente;
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
		System.out.println("Relato: " + this.relato);
		System.out.println("Medicacao Consumida Regularmente: " + this.medicacaoConsumidaRegularmente);
		
		if(consultas.isEmpty()) System.out.println("\n- ESTE PACIENTE NAO TEM CONSULTAS CADASTRADAS!");
		else {
			int aux = 0;
			System.out.println("\n- CONSULTAS: ");
			for(Consulta consulta : consultas) {
				System.out.println("- " + ++aux + "º: ");
				consulta.imprimir();
				System.out.println("------------------");
			}
		}
		
	}
}
