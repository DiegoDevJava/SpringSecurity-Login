package br.com.devjava.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.devjava.springsecurity.beans.Usuario;
import br.com.devjava.springsecurity.repository.UsuarioRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username != null) {
			Usuario usuario = usuarioRepository.findByLogin(username);
			if (usuario != null) {
				System.out.println("Usuário logado: " + usuario.getNome());
				return new UsuarioDetails(usuario);
			}
		}

		return null;
	}

}
