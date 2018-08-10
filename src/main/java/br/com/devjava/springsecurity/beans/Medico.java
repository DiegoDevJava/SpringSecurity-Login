package br.com.devjava.springsecurity.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String crm;
	private String especialidade;

	public Medico() {
	}

	@Column(name = "crm", length = 50)
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Column(name = "especialidade", length = 50)
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [crm=");
		builder.append(crm);
		builder.append(", especialidade=");
		builder.append(especialidade);
		builder.append(", codigo=");
		builder.append(getCodigo());
		builder.append(", login=");
		builder.append(getLogin());
		builder.append(", nome=");
		builder.append(getNome());
		builder.append(", ativo=");
		builder.append(isAtivo());
		builder.append(", tipoPermissao=");
		builder.append(getTipoPermissao());
		builder.append(", tipoUsuario=");
		builder.append(getTipoUsuario());
		builder.append("]");
		return builder.toString();
	}

}
