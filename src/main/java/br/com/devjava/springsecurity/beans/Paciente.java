package br.com.devjava.springsecurity.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;

	public Paciente() {
	}

	@Column(name = "cpf", length = 20)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [cpf=");
		builder.append(cpf);
		builder.append(", codigo=");
		builder.append(getCodigo());
		builder.append(", login=");
		builder.append(getLogin());
		builder.append(", nome=");
		builder.append(getNome());
		builder.append(", ativo=");
		builder.append(isAtivo());
		builder.append("]");
		return builder.toString();
	}

}
