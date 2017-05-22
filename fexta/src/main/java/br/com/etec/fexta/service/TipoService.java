package br.com.etec.fexta.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.fexta.dto.TipoDTO;

@Service
@Transactional
public class TipoService {
    
    @Autowired
    private TipoRepository repository;
    
    public TipoDTO save(TipoDTO tipo){
        return TipoDTO.valueOf(repository.save(tipo.toTipo()));
    }
    
    public void remove(TipoDTO tipo) {
        repository.delete(tipo.toTipo());   
    }
    
    public List<TipoDTO> all() {
        return repository.findAll()
                         .stream()
                         .map(u -> TipoDTO.valueOf(u))
                         .collect(Collectors.toList());
    }
    
    public TipoDTO one(Long numero){
        return TipoDTO.valueOf(repository.findOne(numero));
    }
    
}
