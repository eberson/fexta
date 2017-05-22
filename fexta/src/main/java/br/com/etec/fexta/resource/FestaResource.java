package br.com.etec.fexta.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.etec.fexta.dto.FestaDTO;
import br.com.etec.fexta.service.FestaService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/festa")
public class FestaResource {

    @Autowired
    private FestaService service;
	
    @RequestMapping(path = "/todos", 
                    method = RequestMethod.GET, 
                    produces = "application/json")
    public List<FestaDTO> searchAll(){
            return service.all();
    }
	
    @RequestMapping(path = "/find/{numero}", 
                    method = RequestMethod.GET, 
                    produces = "application/json")
    public FestaDTO searchOne(@PathVariable Long numero){
            return service.one(numero);
    }
	
    @RequestMapping(path = "/salva", 
                    method = RequestMethod.POST, 
                    consumes = "application/json", 
                    produces = "application/json")
    public FestaDTO save(@RequestBody FestaDTO dto){
            return service.save(dto);
    }
        
    @RequestMapping(path = "/exclui", 
                    method = RequestMethod.POST, 
                    consumes = "application/json", 
                    produces = "application/json")
    public String remove(@RequestBody FestaDTO dto){
        service.remove(dto);
        return String.format("Festa, %s, removida com sucessos", dto.getNome());
    }

}

