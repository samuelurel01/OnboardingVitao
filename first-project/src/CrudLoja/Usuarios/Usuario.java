package CrudLoja.Usuarios;

import CrudLoja.Produtos.Produto;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends AbstractUsuario {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


    public Usuario(String nome, String email, Integer senha, PerfilUsuario perfilUsuario) {
        setNome(nome);
        setEmail(email);
        setSenha(senha.toString());
        setPerfil(perfilUsuario);
    }
}