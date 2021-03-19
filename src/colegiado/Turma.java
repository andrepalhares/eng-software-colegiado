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
		}
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
