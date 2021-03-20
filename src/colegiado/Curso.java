package colegiado;

import java.util.List;
import java.util.ArrayList;

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
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public Boolean adicionarDisciplina(Disciplina disciplina) {
		if (this.disciplinas.contains(disciplina) == false) {
			Boolean add = this.disciplinas.add(disciplina);
			if(add) {
				System.out.println("Disciplina adicionada com sucesso.");
			} else {
				System.out.println("Não foi possível adicionar a disciplina.");
			}
			return add;
		} else {
			System.out.println("Disciplina já existe.");
			return false;
		}
	}
	
	public Boolean removerDisciplina(Disciplina disciplina) {
		if (this.disciplinas.contains(disciplina) == true) {
			Boolean remove = this.disciplinas.remove(disciplina);
			if(remove) {
				System.out.println("Disciplina removida com sucesso.");
			} else {
				System.out.println("Não foi possível remover a disciplina.");
			}
			return remove;
		} else {
			System.out.println("Disciplina não existe");
			return false;
		}
	}
	
	public Boolean removerDisciplinaLista(Disciplina disciplina) {
		Boolean remove = this.disciplinas.remove(disciplina);
		return remove;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getColegiado() {
		return this.colegiado;
	}
	
	public void setColegiado(String colegiado) {
		this.colegiado = colegiado;
	}
	
	public int getQuantidadeVagas() {
		return this.quantidadeVagas;
	}
	
	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
