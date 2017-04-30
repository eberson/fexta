package br.com.etec.fexta.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="tb_festa")
@Table
public class Festa implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private LocalDateTime data;
    
    private String local;    
    
    @ManyToOne
    @JoinColumn(name="id_criador")
    private Usuario criador;
    
    @ManyToMany
    @JoinTable(name="festa_convidados")
    private Set<Usuario> convidados;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_festa")
    private Tipo tipoFesta;   
    
    @ElementCollection
    @CollectionTable(name="festa_tem_itens")
    private Set<ItemFesta> itens;

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

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public Set<Usuario> getConvidados() {
    	if (convidados == null){
    		convidados = new HashSet<>();
    	}
    	
        return convidados;
    }

    public void setConvidados(Set<Usuario> convidados) {
        this.convidados = convidados;
    }

    public Tipo getTipoFesta() {
        return tipoFesta;
    }

    public void setTipoFesta(Tipo tipoFesta) {
        this.tipoFesta = tipoFesta;
    }

    public Set<ItemFesta> getItens() {
    	if (itens == null){
    		itens = new HashSet<>();
    	}
    	
        return itens;
    }

    public void setItens(Set<ItemFesta> itens) {
        this.itens = itens;
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
        final Festa other = (Festa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
