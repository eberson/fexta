package br.com.etec.fexta.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.etec.fexta.model.Festa;

public class FestaDTO implements Serializable{
    
	private static final long serialVersionUID = 1L;

    private Long id;
    
    private String nome;
    
    private LocalDateTime data;
    
    private String local;    
    
    private UsuarioDTO criador;
    
    private Set<UsuarioDTO> convidados;
    
    private TipoDTO tipoFesta;   
    
    private Set<ItemFestaDTO> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public UsuarioDTO getCriador() {
        return criador;
    }

    public void setCriador(UsuarioDTO criador) {
        this.criador = criador;
    }

    public Set<UsuarioDTO> getConvidados() {
    	if (convidados == null){
    		convidados = new HashSet<>();
    	}
    	
        return convidados;
    }

    public void setConvidados(Set<UsuarioDTO> convidados) {
        this.convidados = convidados;
    }

    public TipoDTO getTipoFesta() {
        return tipoFesta;
    }

    public void setTipoFesta(TipoDTO tipoFesta) {
        this.tipoFesta = tipoFesta;
    }

    public Set<ItemFestaDTO> getItens() {
    	if (itens == null){
    		itens = new HashSet<>();
    	}
    	
        return itens;
    }

    public void setItens(Set<ItemFestaDTO> itens) {
        this.itens = itens;
    }
    
    public static FestaDTO valueOf(Festa festa){
    	FestaDTO dto = new FestaDTO();
    	
    	dto.setConvidados(festa.getConvidados().stream().map(u -> UsuarioDTO.valueOf(u)).collect(Collectors.toSet()));
    	dto.setCriador(UsuarioDTO.valueOf(festa.getCriador()));
    	dto.setData(festa.getData());
    	dto.setId(festa.getId());
    	dto.setItens(festa.getItens().stream().map(i -> ItemFestaDTO.valueOf(i)).collect(Collectors.toSet()));
    	dto.setLocal(festa.getLocal());
    	dto.setNome(festa.getNome());
    	dto.setTipoFesta(TipoDTO.valueOf(festa.getTipoFesta()));
    	
    	return dto;
    }
    
    public Festa toFesta(){
    	Festa festa = new Festa();
    	
    	festa.setConvidados(getConvidados().stream().map(u -> u.toUsuario()).collect(Collectors.toSet()));
    	festa.setCriador(criador.toUsuario());
    	festa.setData(data);
    	festa.setId(id);
    	festa.setItens(getItens().stream().map(i -> i.toItemFesta()).collect(Collectors.toSet()));
    	festa.setLocal(local);
    	festa.setNome(nome);
    	festa.setTipoFesta(tipoFesta.toTipo());
    	
    	return festa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FestaDTO other = (FestaDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
