package br.com.etec.fexta.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.fexta.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	
}
