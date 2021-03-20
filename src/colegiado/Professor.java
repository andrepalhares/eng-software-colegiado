package colegiado;

import java.util.Calendar;
import java.util.List;

public class Professor extends Pessoa {
	private List<Disciplina> disciplinas;
	private List<Turma> turmas;
	
	public Professor(String nome, Calendar dataNascimento, List<Disciplina> disciplinas, List<Turma> turmas) {
		super(nome, dataNascimento);
		this.disciplinas = disciplinas;
		this.turmas = turmas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Turma> getTurmas() {
		return this.turmas;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public Boolean criarTurma(Disciplina disciplina, String codigo) {
		Turma turma = new Turma(codigo, disciplina);
		if(verificaSeTurmaJaEstaCadastrada(turma)) {
			if(verificaSeDisciplinaExiste(disciplina)) {
				Boolean add = this.turmas.add(turma);
				if(add) {
					System.out.println("Turma criada com sucesso.");
				} else {
					System.out.println("Não foi possível criar a turma.");
				}
				
				return add;
			}
		}
		return false;
	}
	
	public Boolean removerTurma(Turma turma) {
		if(this.turmas.contains(turma)) {
			return this.turmas.remove(turma);
		} else {
			System.out.println("Turma não existe.");
			return false;
		}
	}
	
	private Boolean verificaSeDisciplinaExiste(Disciplina disciplina) {
		if(this.disciplinas.contains(disciplina)) {
			return true;
		} else {
			System.out.println("Disciplina não existe.");
			return false;
		}
	}
	
	private Boolean verificaSeTurmaJaEstaCadastrada(Turma turma) {
		if(this.turmas.contains(turma) == true) {
			return true;
		} else {
			System.out.println("Turma já existe.");
			return false;
		}
	}
}
