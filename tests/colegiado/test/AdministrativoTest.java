package colegiado.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import colegiado.Administrativo;
import colegiado.Curso;

class AdministrativoTest {
	private Administrativo administrativo;
	
	@BeforeEach
	public void before() {
		administrativo = new Administrativo(10, "Colegiado");
	}

	@Test
	public void testCriarCursoInexistente() {		
		int quantidadeCursos = administrativo.getCursos().size();
		
		administrativo.criarCurso(1050, "Curso", "Colegiado", 60, 200);
		
		assertEquals(quantidadeCursos + 1, administrativo.getCursos().size(), "O tamanho da lista de cursos deveria ter aumentado uma unidade");
	}
	
	@Test
	public void testCriarCursoJaExistente() {
		administrativo.criarCurso(1050, "Curso", "Colegiado", 60, 200);
		int quantidadeCursos = administrativo.getCursos().size();
		administrativo.criarCurso(1050, "Curso", "Colegiado", 60, 200);
		
		assertEquals(quantidadeCursos, administrativo.getCursos().size(), "O tamanho da lista de cursos não deveria ter aumentado");	
	}
	
	@Test
	public void testExcluirCursoExistente() {
		administrativo.criarCurso(1050, "Curso", "Colegiado", 60, 200);
		int quantidadeCursos = administrativo.getCursos().size();
		
		administrativo.excluirCurso(1050);
		
		assertEquals(quantidadeCursos - 1, administrativo.getCursos().size(), "O tamanho da lista de cursos deveria ter diminuído");	
	}
	
	@Test
	public void testExcluirCursoInexistente() {
		administrativo.criarCurso(1050, "Curso", "Colegiado", 60, 200);
		int quantidadeCursos = administrativo.getCursos().size();
		
		administrativo.excluirCurso(399);
		
		assertEquals(quantidadeCursos, administrativo.getCursos().size(), "O tamanho da lista de cursos não deveria ter diminuído");	
	}
	
	@Test
	public void testCriarDisciplinaInexistente() {		
		int quantidadeDisciplinas = administrativo.getDisciplinas().size();
		
		administrativo.criarDisciplina("DSC", "Disciplina", 60, "", "");
		
		assertEquals(quantidadeDisciplinas + 1, administrativo.getDisciplinas().size(), "O tamanho da lista de disciplinas deveria ter aumentado uma unidade");
	}
	
	@Test
	public void testCriarDisciplinaJaExistente() {
		administrativo.criarDisciplina("DSC", "Disciplina", 60, "", "");
		int quantidadeDisciplinas = administrativo.getDisciplinas().size();
		administrativo.criarDisciplina("DSC", "Disciplina", 60, "", "");
		
		assertEquals(quantidadeDisciplinas, administrativo.getDisciplinas().size(), "O tamanho da lista de disciplinas não deveria ter aumentado");	
	}
	
	@Test
	public void testExcluirDisciplinaExistente() {
		administrativo.criarDisciplina("DSC", "Disciplina", 60, "", "");
		int quantidadeDisciplinas = administrativo.getDisciplinas().size();
		
		administrativo.excluirDisciplina("DSC");
		
		assertEquals(quantidadeDisciplinas - 1, administrativo.getDisciplinas().size(), "O tamanho da lista de disciplinas deveria ter diminuído");	
	}
	
	@Test
	public void testExcluirDisciplinaInexistente() {
		administrativo.criarDisciplina("DSC", "Disciplina", 60, "", "");
		int quantidadeDisciplinas = administrativo.getDisciplinas().size();
		
		administrativo.excluirDisciplina("CDG");
		
		assertEquals(quantidadeDisciplinas, administrativo.getDisciplinas().size(), "O tamanho da lista de disciplinas não deveria ter diminuído");	
	}

}
