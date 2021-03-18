package colegiado;

import java.util.List;

public class Administrativo {
	private int codigo;
	private String colegiado;
	private List<Curso> cursos;
	private List<Disciplina> disciplinas;
	
	public Administrativo(int codigo, String colegiado) {
		this.codigo = codigo;
		this.colegiado = colegiado;
	}
	
	public void CriarCurso(int codigo, String nome, String colegiado, int quantidadeVagas, int cargaHoraria) {
		if (this.cursos.stream().anyMatch(curso -> curso.getNome() == nome && curso.getCodigo() == codigo) == false) {
			Curso curso = new Curso(codigo, nome, colegiado, quantidadeVagas, cargaHoraria);
			
			this.cursos.add(curso);
		}
	}
	
	public void ExcluirCurso(int codigo) {
		this.cursos.removeIf(curso -> curso.getCodigo() == codigo);
	}
	
	public void CriarDisciplina(String codigo, String nome, int cargaHoraria, String preRequisitos, String programaDisciplina) {
		if (this.disciplinas.stream().anyMatch(disciplina -> disciplina.getNome() == nome && disciplina.getCodigo() == codigo) == false) {
			Disciplina disciplina = new Disciplina(codigo, nome, cargaHoraria, preRequisitos, programaDisciplina);
			
			this.disciplinas.add(disciplina);
		}
	}
	
	public void ExcluirDisciplina(String codigo) {
		this.disciplinas.removeIf(disciplina -> disciplina.getCodigo() == codigo);
	}
}
