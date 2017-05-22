package br.com.etec.fexta.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.fexta.model.Festa;

public interface FestaRepository extends JpaRepository<Festa, Long>{
	
	
}