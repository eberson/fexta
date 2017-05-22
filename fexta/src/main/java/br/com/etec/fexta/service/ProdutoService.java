package br.com.etec.fexta.service;

import java.util.List;


import br.com.etec.fexta.dto.ProdutoDTO;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;
    
    public ProdutoDTO save(ProdutoDTO produto){
        return ProdutoDTO.valueOf(repository.save(produto.toProduto()));
    }
    
    public void remove(ProdutoDTO produto){
        repository.delete(produto.toProduto());
    }
    
    public List<ProdutoDTO> all(){
        return repository.findAll().stream().map(p -> ProdutoDTO.valueOf(p)).collect(Collectors.toList());
    }
    
    public ProdutoDTO one(Long numero){
        return ProdutoDTO.valueOf(repository.findOne(numero));
    }
           
}
