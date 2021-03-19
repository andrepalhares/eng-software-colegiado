package colegiado;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class Aluno extends Pessoa {
	private int matricula;
	private Curso curso;
	private List<Float> notasParciais;
	private float notaFinal;
	private List<Boolean> frequencia;
	private Set<Turma> turmas;
	
	public Aluno(String nome, Calendar dataNascimento, int matricula, Curso curso) {
		super(nome, dataNascimento);
		this.matricula = matricula;
		this.curso = curso;
		this.notasParciais = new ArrayList<Float>();
		this.turmas = new HashSet<Turma>();
	}
	
	public boolean adicionarNotaParcial(float nota) {
		if(nota >= 0 && nota <= 100) {
			this.notasParciais.add(nota);
			this.notaFinal += nota;
			return true;
		} else {
			System.out.println("Nota inválida.");
			return false;
		}
	}
	
	public List<Float> getNotasParciais() {
		return this.notasParciais;
	}
	
	public void adicionarFrequencia(Boolean presenca) {
		this.frequencia.add(presenca);
	}
	
	public float obterFrequenciaTotal() {
		if (!this.frequencia.isEmpty()) {
			return this.frequencia.stream().filter(p -> p == true).count() / this.frequencia.size();			
		} else {
			return 0;
		}
	}
	
	public boolean checarAprovacao() {
		return obterFrequenciaTotal() >= 0.75 && this.notaFinal >= 60;
	}
	
	public boolean adicionarTurma(Turma turma) {
		return this.turmas.add(turma);
	}
	
	public boolean removerTurma(Turma turma) {
		Boolean remove = this.turmas.remove(turma);
		if(remove) {
			System.out.println("Turma removida com sucesso.");
		} else {
			System.out.println("Este aluno não está matriculado nesta turma.");
		}
		return remove;
	}
	
	public int getMatricula() {
		return this.matricula;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public Set<Turma> getTurmas() {
		return this.turmas;
	}
}
