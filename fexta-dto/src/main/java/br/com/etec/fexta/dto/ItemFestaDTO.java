package br.com.etec.fexta.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.etec.fexta.model.ItemFesta;
import br.com.etec.fexta.model.StatusItem;

public class ItemFestaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private ProdutoDTO produto;
    
    private double quantidadePrevista;
    private double quantidadeConfirmada;

    private String status;

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public static ItemFestaDTO valueOf(ItemFesta item) {
    	if (item == null){
    		return null;
    	}
    	
		ItemFestaDTO dto = new ItemFestaDTO();
		
		dto.setProduto(ProdutoDTO.valueOf(item.getProduto()));
		dto.setQuantidadeConfirmada(item.getQuantidadeConfirmada());
		dto.setQuantidadePrevista(item.getQuantidadePrevista());
		dto.setStatus(item.getStatus().toString());
		
		return dto;
	}
    
    public ItemFesta toItemFesta(){
    	ItemFesta item = new ItemFesta();
    	
    	item.setProduto(produto.toProduto());
    	item.setQuantidadeConfirmada(quantidadeConfirmada);
    	item.setQuantidadePrevista(quantidadePrevista);
    	item.setStatus(StatusItem.valueOf(status));
    	
    	return item;
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
        final ItemFestaDTO other = (ItemFestaDTO) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

}