package colegiado;

import java.util.Date;
import java.util.List;

public class Professor extends Pessoa {
	private List<Disciplina> disciplinas;
	
	public Professor(String nome, Date dataNascimento, List<Disciplina> disciplinas) {
		super(nome, dataNascimento);
		this.disciplinas = disciplinas;
	}
}
