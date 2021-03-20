package colegiado;

public class Disciplina {
	private String codigo;
	private String nome;
	private int cargaHoraria;
	private String preRequisitos;
	private String programaDisciplina;
	
	public Disciplina(String codigo, String nome, int cargaHoraria, String preRequisitos, String programaDisciplina) {
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.preRequisitos = preRequisitos;
		this.programaDisciplina = programaDisciplina;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getPreRequisitos() {
		return this.preRequisitos;
	}
	
	public void setPreRequisitos(String preRequesitos) {
		this.preRequisitos = preRequesitos;
	}
	
	public String getProgramaDisciplina() {
		return this.programaDisciplina;
	}
	
	public void setProgramaDisciplina(String programaDisciplina) {
		this.programaDisciplina = programaDisciplina;
	}
	
	
	
	
}
