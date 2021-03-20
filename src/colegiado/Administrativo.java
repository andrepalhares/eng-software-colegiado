package colegiado;

import java.util.ArrayList;
import java.util.List;

public class Administrativo {
	private int codigo;
	private String colegiado;
	private List<Curso> cursos;
	private List<Disciplina> disciplinas;
	
	public Administrativo(int codigo, String colegiado) {
		this.codigo = codigo;
		this.colegiado = colegiado;
		this.cursos = new ArrayList<Curso>();
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public void criarCurso(int codigo, String nome, String colegiado, int quantidadeVagas, int cargaHoraria) {
		if (this.cursos.stream().anyMatch(curso -> curso.getNome() == nome && curso.getCodigo() == codigo) == false) {
			Curso curso = new Curso(codigo, nome, colegiado, quantidadeVagas, cargaHoraria);
			
			this.cursos.add(curso);
		}
	}
	
	public void excluirCurso(int codigo) {
		this.cursos.removeIf(curso -> curso.getCodigo() == codigo);
	}
	
	public void criarDisciplina(String codigo, String nome, int cargaHoraria, String preRequisitos, String programaDisciplina) {
		if (this.disciplinas.stream().anyMatch(disciplina -> disciplina.getNome() == nome && disciplina.getCodigo() == codigo) == false) {
			Disciplina disciplina = new Disciplina(codigo, nome, cargaHoraria, preRequisitos, programaDisciplina);
			
			this.disciplinas.add(disciplina);
		}
	}
	
	public void excluirDisciplina(String codigo) {
		this.disciplinas.removeIf(disciplina -> disciplina.getCodigo() == codigo);
	}
	
	public void adicionarAlunoATurma(Aluno aluno, Turma turma) {
		aluno.adicionarTurma(turma);
		turma.adicionarAluno(aluno);
	}
	
	public void removerAlunoDaTurma(Aluno aluno, Turma turma) {
		aluno.removerTurma(turma);
		turma.removerAluno(aluno);
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setColegiado(String colegiado) {
		this.colegiado = colegiado;
	}
	
	public String getColegiado() {
		return this.colegiado;
	}
	
	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}
	
	public List<Curso> getCursos() {
		return this.cursos;
	}
}
