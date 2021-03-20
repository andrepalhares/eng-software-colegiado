package colegiado.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import colegiado.Curso;
import colegiado.Disciplina;

class CursoTest {
	private Curso curso;

	@BeforeEach
	public void before() {
		curso = new Curso(0, "nome", "colegiado", 0, 0);
	}
	
	@Test
	public void testVerificaSeRetornaTrueAoAdicionarDisciplina() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		assertTrue("Deveria retornar true já que disciplina ainda não existe", curso.adicionarDisciplina(disciplina));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoAdicionarDisciplinaRepetida() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		curso.adicionarDisciplina(disciplina);
		assertFalse("Deveria retornar false, já que está tentando adicionar uma disciplina repetida", curso.adicionarDisciplina(disciplina));
	}
	
	@Test
	public void testVerificaSeRetornaTrueAoRemoverDisciplinaExistente() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		curso.adicionarDisciplina(disciplina);
		assertTrue("Deveria retornar true, já que está tentando remover uma disciplina que existe", curso.removerDisciplina(disciplina));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoRemoverDisciplinaQueNaoExiste() {
		Disciplina disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		assertFalse("Deveria retornar false, já que está tentando remover uma disciplina que não existe", curso.removerDisciplina(disciplina));
	}

}
