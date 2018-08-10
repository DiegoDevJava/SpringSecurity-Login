package br.com.devjava.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devjava.springsecurity.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByLogin(String login);

}
