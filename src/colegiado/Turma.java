package colegiado;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private String codigo;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	
	public Turma(String codigo, Disciplina disciplina) {
		this.codigo = codigo;
		this.disciplina = disciplina;
		this.alunos = new ArrayList<Aluno>();
	}
	
	public void adicionarAluno(Aluno aluno) {
		if (this.alunos.contains(aluno) == false) {
			this.alunos.add(aluno);
			System.out.println("Aluno matriculado com sucesso.");
		} else {
			System.out.println("Aluno j? est? matriculado a turma.");
		}
	}
	
	public Boolean removerAluno(Aluno aluno) {
		if (this.alunos.contains(aluno)) {
			System.out.println("Aluno removido com sucesso.");
			return this.alunos.remove(aluno);
		} else {
			System.out.println("Aluno n?o est? matriculado nesta turma.");
			return false;
		}
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Disciplina getDisciplina() {
		return this.disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public List<Aluno> getAlunos() {
		return this.alunos;
	}
}
