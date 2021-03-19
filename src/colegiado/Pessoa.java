package colegiado;

import java.util.Calendar;

public class Pessoa {
	private String nome;
	private Calendar dataNascimento;
	
	public Pessoa(String nome, Calendar dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
}
