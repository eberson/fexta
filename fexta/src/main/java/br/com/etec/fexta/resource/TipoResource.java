package br.com.etec.fexta.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.fexta.dto.TipoDTO;
import br.com.etec.fexta.service.TipoService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tipo")
public class TipoResource {
    
    @Autowired
    private TipoService service;
        
    @RequestMapping(path = "/todos",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public List<TipoDTO> searchAll(){
        return service.all();
    }
        
    @RequestMapping(path = "/find/{numero}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public TipoDTO searchOne(@PathVariable Long numero){
        return service.one(numero);
    }
        
    @RequestMapping(path = "/salva",
                    method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    public TipoDTO save(@RequestBody TipoDTO dto){
        return service.save(dto);
    } 
        
    @RequestMapping(path = "/exclui",
                    method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    public String remove(@RequestBody TipoDTO dto){
        service.remove(dto);
        return String.format("Tipo, %s, removido com sucesso", dto.getNomeTipo());
    }
}
