/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.fexta.dto;

import br.com.etec.fexta.model.Categoria;
import br.com.etec.fexta.model.Produto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Guilherme
 */
public class CategoriaDTO implements Serializable {

    private Integer codigo;

    private String nome;

    private Set<ProdutoDTO> produtos;

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
        final CategoriaDTO other = (CategoriaDTO) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the produtos
     */
    public Set<ProdutoDTO> getProdutos() {
        if (produtos == null){
            produtos = new HashSet<>();
        }
        
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Set<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public static CategoriaDTO valueOf(Categoria categoria) {
        if (categoria == null) {
            return null;
        }

        CategoriaDTO dto = new CategoriaDTO();

        dto.setCodigo(categoria.getCodigo());
        dto.setNome(categoria.getNome());
        
        for(Produto prod : categoria.getProdutos()){
            dto.getProdutos().add(ProdutoDTO.valueOf(prod));
        }

        return dto;
    }

    public Categoria toCategoria() {
        Categoria categoria = new Categoria();

        categoria.setCodigo(codigo);
        categoria.setNome(nome);
        
        for(ProdutoDTO prod : getProdutos()){
            categoria.getProdutos().add(prod.toProduto());
        }
        
        return categoria;
    }

}
