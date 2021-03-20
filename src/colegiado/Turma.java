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
		} else {
			System.out.println("Aluno já está matriculado a turma.");
		}
	}
	
	public Boolean removerAluno(Aluno aluno) {
		if (this.alunos.contains(aluno)) {
			return this.alunos.remove(aluno);
		} else {
			System.out.println("Aluno não está matriculado nesta turma.");
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
}
