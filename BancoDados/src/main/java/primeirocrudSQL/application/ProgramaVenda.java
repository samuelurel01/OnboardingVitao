package primeirocrudSQL.application;

import java.sql.Connection;

public class ProgramaVenda {

    private Connection minhaConexao;
    public ProgramaVenda(Connection connection){
       minhaConexao = connection;
    }

    public void executar(){
        System.out.println("Seja bem vindo(a) ao programa de vendas!");
    }

    // GeneroController
    // Criação de genero
    // Edição de genero criado anteriormente
    // Listar generos disponiveis no sistema
    // Deletar um genero do sistema

    // VendedorController
    // Criação de um vendedor(a)
    // Edição de um vendedor(a) criado anteriormente
    // Listar vendedores disponiveis no sistema
    // Deletar um vendedor(a) do sistema
    // Pegar um vendedor pelo id
    // Pegar a quantidade de vendedores cadastrados

    // RelatorioController
    // Gerar relatorios - Vamos pegar as informações do banco e gerar
    // um arquivo txt ou imprimir no terminal com os dados
}
