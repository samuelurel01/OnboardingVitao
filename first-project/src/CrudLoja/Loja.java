package CrudLoja;

import CrudLoja.Usuarios.AbstractUsuario;
import CrudLoja.Usuarios.Usuario;

import java.util.List;

// Deve existir um programa online, na qual será possível fazer login e usar as funcionalidades do sistema
public class Loja {

    private String nome;

    private List<Usuario> usuarios;

    private Usuario usuarioLogado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
