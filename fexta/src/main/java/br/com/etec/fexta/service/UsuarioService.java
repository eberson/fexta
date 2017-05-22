package br.com.etec.fexta.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.fexta.dto.UsuarioDTO;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDTO save(UsuarioDTO usuario) {
        return UsuarioDTO.valueOf(repository.save(usuario.toUsuario()));
    }

    public void remove(UsuarioDTO usuario) {
        repository.delete(usuario.toUsuario());
    }

    public List<UsuarioDTO> all() {
        return repository.findAll()
                .stream()
                .map(u -> UsuarioDTO
                        .valueOf(u))
                        .collect(Collectors.toList());
    }
    
    public UsuarioDTO one(String numero){
        return UsuarioDTO.valueOf(repository.findOne(numero));
    }

}
