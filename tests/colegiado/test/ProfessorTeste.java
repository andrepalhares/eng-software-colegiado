package colegiado.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import colegiado.Disciplina;
import colegiado.Professor;
import colegiado.Turma;

class ProfessorTeste {
	private Professor professor;
	
	@BeforeEach
	public void before() {
		professor = new Professor("nome", new GregorianCalendar(1999,7,26), new ArrayList<Disciplina>(), new ArrayList<Turma>());
	}

	@Test
	public void testVerificaSeRetornaTrueAoCriarNovaTurma() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(disciplina);
		professor.setDisciplinas(disciplinas);
		assertTrue("Deveria retornar true, j� que est� criando uma turma com disciplina v�lida e que ainda n�o existe", professor.criarTurma(disciplina, "cod"));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoTentarCriarTurmaComDisciplinaInvalida() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		assertFalse("Deveria retornar false, j� que est� criando uma turma com disciplina que n�o existe", professor.criarTurma(disciplina, "cod"));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoTentarCriarTurmaQueJaExiste() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(disciplina);
		professor.setDisciplinas(disciplinas);
		Turma turma = new Turma("cod", disciplina);
		List<Turma> turmas = new ArrayList<Turma>();
		turmas.add(turma);
		professor.setTurmas(turmas);
		assertFalse("Deveria retornar false, j� que est� tentando criar uma turma que j� existe", professor.criarTurma(disciplina, "cod"));
	}
	
	@Test
	public void testVerificaSeRertornaTrueAoRemoverTurmaExistente() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(disciplina);
		professor.setDisciplinas(disciplinas);
		professor.criarTurma(disciplina, "cod");
		Turma turma = new Turma("cod", disciplina);
		assertTrue("Deveria retornar true, j� que est� tentando remover uma turma existente", professor.removerTurma(turma));
		
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoRemoverTurmaInexistente() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		Turma turma = new Turma("cod", disciplina);
		assertFalse("Deveria retornar false, j� que est� tentando remover uma turma que n�o existe", professor.removerTurma(turma));
	}
	
	@Test
	public void testRemoverTurmaExistente() {
		
	}

}
