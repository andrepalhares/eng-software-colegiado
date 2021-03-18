package colegiado;

import java.util.List;
import java.util.Date;

public class Aluno extends Pessoa {
	private int matricula;
	private Curso curso;
	private List<Float> notasParciais;
	private float notaFinal;
	private List<Boolean> frequencia;
	
	public Aluno(String nome, Date dataNascimento, int matricula, Curso curso) {
		super(nome, dataNascimento);
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public void AdicionarNotaParcial(float nota) {
		if(nota >= 0 && nota <= 100) {
			this.notasParciais.add(nota);
			this.notaFinal += nota;
		}
	}
	
	public void AdicionarFrequencia(Boolean presenca) {
		this.frequencia.add(presenca);
	}
	
	public float ObterFrequenciaTotal() {
		if (!this.frequencia.isEmpty()) {
			return this.frequencia.stream().filter(p -> p == true).count() / this.frequencia.size();			
		} else {
			return 0;
		}
	}
	
	public boolean ChecarAprovacao() {
		return ObterFrequenciaTotal() >= 0.75 && this.notaFinal >= 60;
	}
}
