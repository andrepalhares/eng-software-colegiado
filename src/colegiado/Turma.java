package colegiado;

import java.util.List;

public class Turma {
	private String codigo;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	
	public Turma(String codigo, Disciplina disciplina) {
		this.codigo = codigo;
		this.disciplina = disciplina;
	}
	
	public void AdicionarAluno(Aluno aluno) {
		if (this.alunos.contains(aluno) == false) {
			this.alunos.add(aluno);
		}
	}
}
