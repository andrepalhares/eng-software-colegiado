package colegiado;

import java.util.List;

public class Curso {
	private int codigo;
	private String nome;
	private String colegiado;
	private int quantidadeVagas;
	private int cargaHoraria;
	private List<Disciplina> disciplinas;
	
	public Curso(int codigo, String nome, String colegiado, int quantidadeVagas, int cargaHoraria) {
		this.codigo = codigo;
		this.nome = nome;
		this.colegiado = colegiado;
		this.quantidadeVagas = quantidadeVagas;
		this.cargaHoraria = cargaHoraria;
	}
	
	public void AdicionarDisciplina(Disciplina disciplina) {
		if (this.disciplinas.contains(disciplina) == false) {
			this.disciplinas.add(disciplina);
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
}
