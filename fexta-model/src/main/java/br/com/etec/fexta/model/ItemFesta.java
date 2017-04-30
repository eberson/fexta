package br.com.etec.fexta.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemFesta implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;
    
    private double quantidadePrevista;
    private double quantidadeConfirmada;

    @Enumerated(EnumType.STRING)
    private StatusItem status;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidadePrevista() {
        return quantidadePrevista;
    }

    public void setQuantidadePrevista(double quantidadePrevista) {
        this.quantidadePrevista = quantidadePrevista;
    }

    public double getQuantidadeConfirmada() {
        return quantidadeConfirmada;
    }

    public void setQuantidadeConfirmada(double quantidadeConfirmada) {
        this.quantidadeConfirmada = quantidadeConfirmada;
    }
    
    public void confirmaQuantidade(double quantidade){
        
    }

    public StatusItem getStatus() {
        return status;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.produto);
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
        final ItemFesta other = (ItemFesta) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

}