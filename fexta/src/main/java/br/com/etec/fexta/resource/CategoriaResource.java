package br.com.etec.fexta.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.etec.fexta.dto.CategoriaDTO;
import br.com.etec.fexta.service.CategoriaService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService service;
    
    @RequestMapping(path = "/todos",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public List<CategoriaDTO> searchAll(){
        return service.all();
    }
    
    @RequestMapping(path = "/find/{numero}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public CategoriaDTO searchOne(@PathVariable Integer numero){
        return service.one(numero);
    }
    
        @RequestMapping(path = "/salva", 
                    method = RequestMethod.POST, 
                    consumes = "application/json", 
                    produces = "application/json")
    public CategoriaDTO save(@RequestBody CategoriaDTO dto){
            return service.save(dto);
    }
        
    @RequestMapping(path = "/exclui", 
                    method = RequestMethod.POST, 
                    consumes = "application/json", 
                    produces = "application/json")
    public String remove(@RequestBody CategoriaDTO dto){
        service.remove(dto);
        return String.format("Categoria, %s, removida com sucessos", dto.getNome());
    }
}
