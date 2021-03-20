package colegiado.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import colegiado.Aluno;
import colegiado.Curso;
import colegiado.Disciplina;
import colegiado.Turma;

class TurmaTest {
	private Turma turma;
	private Disciplina disciplina;

	@BeforeEach
	public void before() {
		disciplina = new Disciplina("codigo", "nome", 0, "pre", "prog");
		turma = new Turma("cod", disciplina);
	}
	
	@Test
	public void testAdicionarAlunoInexistente() {
		Aluno aluno = new Aluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
		
		int tamanhoLista = turma.getAlunos().size();
		
		turma.adicionarAluno(aluno);
		
		int tamanhoEsperado = tamanhoLista + 1;
		
		assertEquals(tamanhoEsperado, turma.getAlunos().size(), "O tamanho da lista deveria ser alterado pois um novo aluno foi inserido");
	}
	
	@Test
	public void testAdicionarAlunoExistente() {
		Aluno aluno = new Aluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
		turma.adicionarAluno(aluno);
		
		int tamanhoLista = turma.getAlunos().size();
		turma.adicionarAluno(aluno);
		
		assertEquals(tamanhoLista, turma.getAlunos().size(), "O tamanho da lista não poderia ser alterado pois o aluno não foi inserido");
	}
	
	@Test
	public void testRemoverAlunoExistente() {
		Aluno aluno = new Aluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
		turma.adicionarAluno(aluno);
		
		assertTrue(turma.removerAluno(aluno), "O aluno existente deveria ter sido removido da lista de alunos");
	}
	
	@Test
	public void testRemoverAlunoInexistente() {
		Aluno aluno = new Aluno("nome", new GregorianCalendar(1999,7,26), 132123456, new Curso(0, "nome", "colegiado", 0, 0));
		
		assertFalse(turma.removerAluno(aluno), "O aluno inexistente não pode ser removido da lista de alunos");
	}

}
