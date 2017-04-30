package br.com.etec.fexta.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.fexta.dto.UsuarioDTO;
import br.com.etec.fexta.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(path = "/todos", method = RequestMethod.GET, produces = "application/json")
	public List<UsuarioDTO> searchAll(){
		return service.all();
	}
	
	@RequestMapping(path = "/salva/{numero}/{nome}/{sexo}", method = RequestMethod.GET, produces = "application/json")
	public UsuarioDTO save(@PathVariable String numero, 
			               @PathVariable String nome, 
			               @PathVariable String sexo){
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setNome(nome);
		dto.setNumero(numero);
		dto.setSexo(sexo);
		
		return service.save(dto);
	}

}
