package br.com.etec.fexta.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.etec.fexta.model.Produto;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static ProdutoDTO valueOf(Produto produto){
		if (produto == null){
			return null;
		}
		
		ProdutoDTO dto = new ProdutoDTO();
		
		dto.setCodigo(produto.getCodigo());
		dto.setNome(produto.getNome());
		
		return dto;
	}
	
	public Produto toProduto(){
		Produto produto = new Produto();
		
		produto.setCodigo(codigo);
		produto.setNome(nome);
		
		return produto;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + Objects.hashCode(this.codigo);
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
		final ProdutoDTO other = (ProdutoDTO) obj;
		if (!Objects.equals(this.codigo, other.codigo)) {
			return false;
		}
		return true;
	}
}
