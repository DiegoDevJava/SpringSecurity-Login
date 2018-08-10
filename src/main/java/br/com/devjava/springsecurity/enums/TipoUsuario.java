package br.com.devjava.springsecurity.enums;

public enum TipoUsuario {

	ADMIN("Administrador"), MEDICO("Médico"), PACIENTE("Paciente");

	private String nome;

	private TipoUsuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
