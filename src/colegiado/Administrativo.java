package colegiado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Administrativo {
	private int codigo;
	private String colegiado;
	private List<Curso> cursos;
	private List<Disciplina> disciplinas;
	private List<Aluno> alunos;
	private List<Professor> professores;
	
	public Administrativo(int codigo, String colegiado) {
		this.codigo = codigo;
		this.colegiado = colegiado;
		this.cursos = new ArrayList<Curso>();
		this.disciplinas = new ArrayList<Disciplina>();
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
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
	
	public Boolean editarCurso(int codigo, String nome, String colegiado, int quantidadeVagas, int cargaHoraria) {
		for(Curso curso : this.cursos) {
			if(curso.getCodigo() == codigo) {
				this.cursos.remove(curso);
				this.cursos.add(new Curso(codigo, nome, colegiado, quantidadeVagas, cargaHoraria));
				System.out.println("Curso editado com sucesso.");
				return true;
			}
		}
		
		System.out.println("Curso n�o encontrado.");
		return false; 
	}
	
	public void criarDisciplina(String codigo, String nome, int cargaHoraria, String preRequisitos, String programaDisciplina) {
		if (this.disciplinas.stream().anyMatch(disciplina -> disciplina.getNome() == nome && disciplina.getCodigo() == codigo) == false) {
			Disciplina disciplina = new Disciplina(codigo, nome, cargaHoraria, preRequisitos, programaDisciplina);
			
			this.disciplinas.add(disciplina);
		} else {
			System.out.println("Disciplina j� existe.");
		}
	}
	
	public void excluirDisciplina(String codigo) {
		this.disciplinas.removeIf(disciplina -> disciplina.getCodigo() == codigo);
	}
	
	public Boolean editarDisciplina(String codigo, String nome, int cargaHoraria, String preRequisitos, String programaDisciplina) {
		for(Disciplina disciplina : this.disciplinas) {
			if(disciplina.getCodigo() == codigo) {
				this.disciplinas.remove(disciplina);
				this.disciplinas.add(new Disciplina(codigo, nome, cargaHoraria, preRequisitos, programaDisciplina));
				System.out.println("Disciplina editado com sucesso.");
				return true;
			}
		}
		
		System.out.println("Disciplina n�o encontrado.");
		return false; 
	}
	
	public void adicionarAlunoATurma(Aluno aluno, Turma turma) {
		aluno.adicionarTurma(turma);
		turma.adicionarAluno(aluno);
	}
	
	public void removerAlunoDaTurma(Aluno aluno, Turma turma) {
		aluno.removerTurma(turma);
		turma.removerAluno(aluno);
	}
	
	public void cadastrarProfessor(String nome, Calendar dataNascimento, List<Disciplina> disciplinas, List<Turma> turmas) {
		if (this.professores.stream().anyMatch(professor -> professor.getNome() == nome && professor.getDataNascimento() == dataNascimento) == false) {
			Professor professor = new Professor(nome, dataNascimento, disciplinas, turmas);
			
			this.professores.add(professor);
		} else {
			System.out.println("Professor j� existe.");
		}
	}
	
	public void registrarAluno(String nome, Calendar dataNascimento, int matricula, Curso curso) {
		if (this.alunos.stream().anyMatch(aluno -> aluno.getNome() == nome && aluno.getDataNascimento() == dataNascimento) == false) {
			Aluno aluno = new Aluno(nome, dataNascimento, matricula, curso);
			
			this.alunos.add(aluno);
		} else {
			System.out.println("Aluno j� existe.");
		}
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
