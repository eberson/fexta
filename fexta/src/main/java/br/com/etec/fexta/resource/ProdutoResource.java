package br.com.etec.fexta.resource;

import br.com.etec.fexta.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.fexta.service.ProdutoService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping ("/produto")
public class ProdutoResource {
    
    @Autowired
    private ProdutoService service;
    
    @RequestMapping(path = "/todos", 
                    method = RequestMethod.GET, 
                    produces = "application/json")
    public List<ProdutoDTO> searchAll(){
            return service.all();
    }
	
    @RequestMapping(path = "/find/{numero}", 
                    method = RequestMethod.GET, 
                    produces = "application/json")
    public ProdutoDTO searchOne(@PathVariable Long numero){
            return service.one(numero);
    }
	
    @RequestMapping(path = "/salva", 
                    method = RequestMethod.POST, 
                    consumes = "application/json", 
                    produces = "application/json")
    public ProdutoDTO save(@RequestBody ProdutoDTO dto){
            return service.save(dto);
    }
        
    @RequestMapping(path = "/exclui", 
                    method = RequestMethod.POST, 
                    consumes = "application/json", 
                    produces = "application/json")
    public String remove(@RequestBody ProdutoDTO dto){
        service.remove(dto);
        return String.format("Produto, %s, removido com sucessos", dto.getNome());
    }
}
