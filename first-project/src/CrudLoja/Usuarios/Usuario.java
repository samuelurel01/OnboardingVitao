package CrudLoja.Usuarios;

import CrudLoja.Produtos.Produto;

import java.util.List;

public class Usuario extends AbstractUsuario{

    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
