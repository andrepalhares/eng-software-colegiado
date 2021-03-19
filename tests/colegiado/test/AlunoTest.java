package colegiado.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import colegiado.Aluno;
import colegiado.Curso;
import colegiado.Disciplina;
import colegiado.Turma;

class AlunoTest {
	private Aluno aluno;
	
	@BeforeEach
	public void before() {
		aluno = new Aluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
	}

	@Test
	public void testVerificaSeRetornaTrueAoAdicionarNotaCorreta() {
		assertTrue("Deveria voltar true, j� que nota est� entre 0 e 100", aluno.adicionarNotaParcial(78));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoAdicionarNotaMaiorQue100() {
		assertFalse("Deveria voltar false, j� que n�o d� para adicionar uma nota maior que 100", aluno.adicionarNotaParcial(150));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoAdicionarNotaMenorQue0() {
		assertFalse("Deveria voltar false, j� que n�o d� para adicionar uma nota menor que 0", aluno.adicionarNotaParcial(-50));
	}
	
	@Test
	public void testVerificaSeTurmaFoiAdicionadaComSucesso() {
		Turma turma = new Turma("code", new Disciplina("cod", "nome", 1, "pre", "prog"));
		aluno.adicionarTurma(turma);
		
		Set<Turma> turmas = new HashSet<Turma>();
		turmas.add(turma);
		assertEquals(turmas, aluno.getTurmas());
	}
	
	@Test
	public void testVerificaSeRetornaTrueAoRemoverTurmaComSucesso() {
		Turma turma = new Turma("code", new Disciplina("cod", "nome", 1, "pre", "prog"));
		aluno.adicionarTurma(turma);
		
		assertTrue(aluno.removerTurma(turma));
	}

	@Test
	public void testVerificaSeRetornaFalseAoTentarRemoverTurmaQueAlunoNaoEsta() {
		Disciplina disciplina = new Disciplina("cod", "nome", 1, "pre", "prog");
		Turma turma = new Turma("code", disciplina);
		Turma outraTurma = new Turma("code3", disciplina);
		aluno.adicionarTurma(turma);
		
		assertFalse(aluno.removerTurma(outraTurma));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoTentarAdicionarTurmaQueAlunoJaEsta() {
		Turma turma = new Turma("code", new Disciplina("cod", "nome", 1, "pre", "prog"));
		aluno.adicionarTurma(turma);
		
		assertFalse(aluno.adicionarTurma(turma));
	}

}
