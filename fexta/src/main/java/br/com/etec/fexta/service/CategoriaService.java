package br.com.etec.fexta.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.fexta.dto.CategoriaDTO;
/**
 *
 * @author Guilherme
 */
@Service
@Transactional
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;
    
    public CategoriaDTO save(CategoriaDTO categoria){
        return CategoriaDTO.valueOf(repository.save(categoria.toCategoria()));
    }
    
    public void remove(CategoriaDTO categoria){
        repository.delete(categoria.toCategoria());
    }
    
    public List<CategoriaDTO> all(){
        return repository.findAll().stream().map(u -> CategoriaDTO.valueOf(u)).collect(Collectors.toList());
    }
    
    public CategoriaDTO one(Integer numero){
        return CategoriaDTO.valueOf(repository.findOne(numero));
    }
}
