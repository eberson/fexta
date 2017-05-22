package br.com.etec.fexta.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.fexta.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
