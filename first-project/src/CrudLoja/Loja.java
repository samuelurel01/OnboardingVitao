package CrudLoja;

import CrudLoja.Produtos.Produto;
import CrudLoja.Usuarios.AbstractUsuario;
import CrudLoja.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;

// Deve existir um programa online, na qual será possível fazer login e usar as funcionalidades do sistema
public class Loja {

    public Loja(String nome){
        setNome(nome);
        setProdutos(new ArrayList<>());
        setUsuarios(new ArrayList<>());
    }
    private List<Produto> produtos;

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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
