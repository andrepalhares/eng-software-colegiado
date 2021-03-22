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
		assertTrue("Deveria voltar true, já que nota está entre 0 e 100", aluno.adicionarNotaParcial("prova 1", 78));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoAdicionarNotaMaiorQue100() {
		assertFalse("Deveria voltar false, já que não dá para adicionar uma nota maior que 100", aluno.adicionarNotaParcial("prova 2", 150));
	}
	
	@Test
	public void testVerificaSeRetornaFalseAoAdicionarNotaMenorQue0() {
		assertFalse("Deveria voltar false, já que não dá para adicionar uma nota menor que 0", aluno.adicionarNotaParcial("prova 3", -50));
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
	
	@Test
	public void testChecarAprovacaoNotaInsuficiente() {
		aluno.adicionarFrequencia(Boolean.TRUE);
		aluno.adicionarNotaParcial("prova 3", 21);
		
		boolean aprovado = aluno.checarAprovacao();
		
		assertFalse("Deveria retornar FALSE pois a nota é menor que 60", aprovado);
	}
	
	@Test
	public void testChecarAprovacaoFrequenciaInsuficiente() {
		aluno.adicionarFrequencia(Boolean.FALSE);
		aluno.adicionarFrequencia(Boolean.FALSE);
		aluno.adicionarFrequencia(Boolean.TRUE);
		aluno.adicionarNotaParcial("trabalho prático 2", 61);
		
		boolean aprovado = aluno.checarAprovacao();
		
		assertFalse("Deveria retornar FALSE pois a frequência é menor que 75%", aprovado);
	}
	
	@Test
	public void testChecarAprovacaoNotaEFrequenciaSuficientes() {
		aluno.adicionarFrequencia(Boolean.FALSE);
		aluno.adicionarFrequencia(Boolean.TRUE);
		aluno.adicionarFrequencia(Boolean.TRUE);
		aluno.adicionarFrequencia(Boolean.TRUE);
		aluno.adicionarNotaParcial("trabalho prático 1", 60);
		
		boolean aprovado = aluno.checarAprovacao();
		
		assertTrue("Deveria retornar TRUE pois a frequência é menor que 75%", aprovado);
	}
	
	@Test
	public void testObterFrequenciaTotalInexistente() {
		float frequencia = aluno.obterFrequenciaTotal();
		
		assertEquals(0, frequencia, 0);
	}

}
