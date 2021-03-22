package colegiado;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Professor extends Pessoa {
	private List<Disciplina> disciplinas;
	private List<Turma> turmas;
	
	public Professor(String nome, Calendar dataNascimento, List<Disciplina> disciplinas, List<Turma> turmas) {
		super(nome, dataNascimento);
		this.disciplinas = disciplinas;
		this.turmas = turmas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Turma> getTurmas() {
		return this.turmas;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public Boolean criarTurma(Disciplina disciplina, String codigo) {
		Turma turma = new Turma(codigo, disciplina);
		if(verificaSeTurmaJaEstaCadastrada(turma)) {
			if(verificaSeDisciplinaExiste(disciplina)) {
				Boolean add = this.turmas.add(turma);
				if(add) {
					System.out.println("Turma criada com sucesso.");
				} else {
					System.out.println("Não foi possível criar a turma.");
				}
				
				return add;
			}
		}
		return false;
	}
	
	public Boolean removerTurma(Turma turma) {
		if(this.turmas.contains(turma)) {
			return this.turmas.remove(turma);
		} else {
			System.out.println("Turma não existe.");
			return false;
		}
	}
	
	private Boolean verificaSeDisciplinaExiste(Disciplina disciplina) {
		if(this.disciplinas.contains(disciplina)) {
			return true;
		} else {
			System.out.println("Disciplina não existe.");
			return false;
		}
	}
	
	private Boolean verificaSeTurmaJaEstaCadastrada(Turma turma) {
		if(this.turmas.contains(turma) == true) {
			return true;
		} else {
			System.out.println("Turma já existe.");
			return false;
		}
	}
	
	public void inserirNota(Turma turma, Aluno aluno, String atividade, int nota) {
		if (verificaSeTurmaEAlunoExistem(turma, aluno)) {
			aluno.adicionarNotaParcial(atividade, nota);
		}
	}
	
	private Boolean verificaSeTurmaEAlunoExistem(Turma turma, Aluno aluno) {
		if (this.turmas.contains(turma)) {
			if(turma.getAlunos().contains(aluno)) {
				return true;
			} else {
				System.out.println("Aluno não está nessa turma.");
				return false;
			}
		} else {
			System.out.println("Turma não existe.");
			return false;
		}
	}
	
	public void inserirFrequencia(Turma turma, Aluno aluno, Boolean presenca) {
		if (verificaSeTurmaEAlunoExistem(turma, aluno)) {
			aluno.adicionarFrequencia(presenca);
		}
	}
	
	public void gerarRelatorio(String codigo, String tipo) {
		Turma turma = acharTurmaPeloCodigo(codigo);
		if(turma != null) {
			if(tipo.equals("nota")) {
				for(Aluno aluno : turma.getAlunos()) {
					System.out.println(aluno.getNome() + ": \n");
					imprimirNotasDoAluno(aluno);
				}
			} else if(tipo.equals("frequencia")) {
				for(Aluno aluno : turma.getAlunos()) {
					System.out.println(aluno.getNome() + ": \n");
					imprimirFrequenciaDoAluno(aluno);
				}
			}
		} else {
			System.out.println("Turma não existe.");
		}
	}
	
	private void imprimirNotasDoAluno(Aluno aluno) {
		Map<String, Float> notas = aluno.getNotasParciais();
		Object[] atividades = notas.keySet().toArray();
		for(int i = 0; i <= atividades.length; i++) {
			System.out.println(atividades[i].toString() + ": " + notas.get(atividades[i].toString()) + "\n");
		}
	}
	
	private void imprimirFrequenciaDoAluno(Aluno aluno) {
		List<Boolean> frequencia = aluno.getFrequencia();
		for(Boolean freq : frequencia) {
			if(freq) {
				System.out.println("presente" + "\n");
			} else {
				System.out.println("ausente" + "\n");
			}
		}
	}
	
	private Turma acharTurmaPeloCodigo(String codigo) {
		for(Turma turma : this.turmas) {
			if(turma.getCodigo() == codigo) {
				return turma;
			}
		}
		
		return null;
	}
}
