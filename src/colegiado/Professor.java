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
}
