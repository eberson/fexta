package br.com.etec.fexta.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.fexta.dto.FestaDTO;

@Service
@Transactional
public class FestaService {

    @Autowired
    private FestaRepository repository;

    public FestaDTO save(FestaDTO festa) {
        return FestaDTO.valueOf(repository.save(festa.toFesta()));
    }

    public void remove(FestaDTO festa) {
        repository.delete(festa.toFesta());
    }

    public List<FestaDTO> all() {
        return repository.findAll().stream().map(u -> FestaDTO.valueOf(u)).collect(Collectors.toList());
    }
    
    public FestaDTO one(Long numero){
        return FestaDTO.valueOf(repository.findOne(numero));
    }

}

