package colegiado.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import colegiado.Administrativo;
import colegiado.Curso;
import colegiado.Disciplina;
import colegiado.Turma;

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
	public void testEditarCursoExistente() {
		administrativo.criarCurso(1050, "Curso", "Colegiado", 60, 200);
		
		assertTrue("Deveria retornar true, já que está tentando editar um curso existente", administrativo.editarCurso(1050, "Novo Curso", "Novo Colegiado", 40, 100));
	}
	
	@Test
	public void testEditarCursoInexistente() {
		assertFalse("Deveria retornar false, já que está tentando editar um curso inexistente", administrativo.editarCurso(1050, "Novo Curso", "Novo Colegiado", 40, 100));
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
	public void testEditarDisciplinaExistente() {
		administrativo.criarDisciplina("DSC", "Disciplina", 60, "", "");
		
		assertTrue("Deveria retornar true, já que está tentando editar uma disciplina existente", administrativo.editarDisciplina("DSC", "Nova Disciplina", 40, "pre", "pro"));
	}
	
	@Test
	public void testEditarDisciplinaInexistente() {
		assertFalse("Deveria retornar false, já que está tentando editar uma disciplina inexistente", administrativo.editarDisciplina("DSC", "Nova Disciplina", 40, "pre", "pro"));
	}
	
	@Test
	public void testExcluirDisciplinaInexistente() {
		administrativo.criarDisciplina("DSC", "Disciplina", 60, "", "");
		int quantidadeDisciplinas = administrativo.getDisciplinas().size();
		
		administrativo.excluirDisciplina("CDG");
		
		assertEquals(quantidadeDisciplinas, administrativo.getDisciplinas().size(), "O tamanho da lista de disciplinas não deveria ter diminuído");	
	}
	
	@Test
	public void testCadastrarProfessorInexistente() {
		int quantidadeProfesores = administrativo.getProfessores().size();
		administrativo.cadastrarProfessor("nome", new GregorianCalendar(1999,7,26), new ArrayList<Disciplina>(), new ArrayList<Turma>());
		
		assertEquals(quantidadeProfesores + 1, administrativo.getProfessores().size(), "O tamanho da lista de professores deveria ter aumentado uma unidade, já que foi adicionado um novo professor");
	}
	
	@Test
	public void testCadastrarProfessorJaExistente() {
		administrativo.cadastrarProfessor("nome", new GregorianCalendar(1999,7,26), new ArrayList<Disciplina>(), new ArrayList<Turma>());
		int quantidadeProfesores = administrativo.getProfessores().size();
		
		administrativo.cadastrarProfessor("nome", new GregorianCalendar(1999,7,26), new ArrayList<Disciplina>(), new ArrayList<Turma>());
		
		assertEquals(quantidadeProfesores, administrativo.getProfessores().size(), "O tamanho da lista de professores não deveria aumentar, já que está tentando adicionar um professor já existente");
	}
	
	@Test
	public void testCadastrarAlunoInexistente() {
		int quantidadeAlunos = administrativo.getAlunos().size();
		administrativo.registrarAluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
		
		assertEquals(quantidadeAlunos + 1, administrativo.getAlunos().size(), "O tamanho da lista de alunos deveria ter aumentado uma unidade, já que foi adicionado um novo aluno");
	}
	
	@Test
	public void testCadastrarAlunoJaExistente() {
		administrativo.registrarAluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
		int quantidadeAlunos = administrativo.getAlunos().size();
		
		administrativo.registrarAluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
		
		assertEquals(quantidadeAlunos, administrativo.getAlunos().size(), "O tamanho da lista de alunos não deveria aumentar, já que está tentando adicionar um aluno já existente");
	}

}
