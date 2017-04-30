package br.com.etec.fexta.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.etec.fexta.model.Tipo;

public class TipoDTO implements Serializable{
    
	private static final long serialVersionUID = 1L;

    private Long codigo;
    
    private String nomeTipo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }
    
    public static TipoDTO valueOf(Tipo tipo){
    	if (tipo == null){
    		return null;
    	}
    	
    	TipoDTO dto = new TipoDTO();
    	
    	dto.setCodigo(tipo.getCodigo());
    	dto.setNomeTipo(tipo.getNomeTipo());
    	
    	return dto;
    }
    
    public Tipo toTipo(){
    	Tipo tipo = new Tipo();
    	
    	tipo.setCodigo(codigo);
    	tipo.setNomeTipo(nomeTipo);
    	
    	return tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
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
        final TipoDTO other = (TipoDTO) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
