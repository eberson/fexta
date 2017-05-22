package br.com.etec.fexta.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.etec.fexta.model.Sexo;
import br.com.etec.fexta.model.Usuario;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String numero;

    private String nome;

    private String sexo;

    private Set<UsuarioDTO> contatos;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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

    public Set<UsuarioDTO> getContatos() {
        if (contatos == null) {
            contatos = new HashSet<>();
        }

        return contatos;
    }

    public void setContatos(Set<UsuarioDTO> contatos) {
        this.contatos = contatos;
    }

    public static UsuarioDTO valueOf(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDTO dto = new UsuarioDTO();

        dto.setNome(usuario.getNome());
        dto.setNumero(usuario.getNumero());
        dto.setSexo(usuario.getSexo().toString());
        
        Set<UsuarioDTO> contatos = new HashSet<>();
        
        for(Usuario usr : usuario.getContatos()){
            contatos.add(UsuarioDTO.valueOf(usr));
        }
        
        dto.setContatos(contatos);

        return dto;
    }

    public Usuario toUsuario() {
        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setNumero(numero);
        usuario.setSexo(Sexo.valueOf(sexo));
        
        Set<Usuario> contatos = new HashSet<>();
        
        for(UsuarioDTO dto : getContatos()){
            contatos.add(dto.toUsuario());
        }
        
        usuario.setContatos(contatos);

        return usuario;
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
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

}
