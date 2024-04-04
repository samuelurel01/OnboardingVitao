package primeirocrudSQL.application;

import java.sql.Connection;

public class ProgramaVenda {

    private Connection miinhaConexao;
    public ProgramaVenda(Connection connection){
       miinhaConexao = connection;
    }

    public void executar(){
        System.out.println("Seja bem vindo(a) ao programa de vendas!");
    }
}
