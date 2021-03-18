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
	
	public String getCodigo() {
		return this.codigo;
	}
}
