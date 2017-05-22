package br.com.etec.fexta.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.fexta.model.Categoria;



public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
