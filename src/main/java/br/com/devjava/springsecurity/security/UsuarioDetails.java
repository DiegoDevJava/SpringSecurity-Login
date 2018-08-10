package br.com.devjava.springsecurity.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.devjava.springsecurity.beans.Usuario;

public class UsuarioDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UsuarioDetails(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();

		if (this.usuario != null) {
			if (this.usuario.getTipoPermissao() != null)
				authorities.add(new SimpleGrantedAuthority(this.usuario.getTipoPermissao().name()));
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		return this.usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return this.usuario.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.usuario.isAtivo();
	}

}
