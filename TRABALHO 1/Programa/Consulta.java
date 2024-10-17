package trabalho1;

public class Consulta {
	private String data;
	private String hora;
	private String cpfPaciente;
	private int crmMedico;
	private String diagnostico;
	private String receitaMedica;
	
	public Consulta (String data, String hora, String cpfPaciente, int crmMedico, String diagnostico, String receitaMedica) {
		this.data = data;
		this.hora = hora;
		this.cpfPaciente = cpfPaciente;
		this.crmMedico = crmMedico;	
		this.diagnostico = diagnostico;
		this.receitaMedica = receitaMedica;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getCpfPaciente() {
		return cpfPaciente;
	}
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
	
	public int getCrmMedico() {
		return crmMedico;
	}
	public void setCrmMedico(int crmMedico) {
		this.crmMedico = crmMedico;
	}
	
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceitaMedica() {
		return receitaMedica;
	}
	public void setReceitaMedica(String receitaMedica) {
		this.receitaMedica = receitaMedica;
	}

	public void imprimir() {
		System.out.println("Data: " + this.data);
		System.out.println("Hora: " + this.hora);
		System.out.println("CPF do paciente: " + this.cpfPaciente);
		System.out.println("CRM do medico: " + this.crmMedico);
		System.out.println("Diagnostico: " + this.diagnostico);
		System.out.println("Receita Medica: " + this.receitaMedica);
	}
}
