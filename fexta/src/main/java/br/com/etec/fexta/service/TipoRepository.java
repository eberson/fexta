package br.com.etec.fexta.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.fexta.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long>{
    
}
