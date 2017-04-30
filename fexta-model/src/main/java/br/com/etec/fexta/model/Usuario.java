package br.com.etec.fexta.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_usuario")
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
    private String numero;
    
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @ElementCollection
    @CollectionTable(name="festa_tem_itens")
    private Set<Usuario> contatos;

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Set<Usuario> getContatos() {
    	if (contatos == null){
    		contatos = new HashSet<>();
    	}
    	
		return contatos;
	}
    
    public void setContatos(Set<Usuario> contatos) {
		this.contatos = contatos;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.numero);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

}
