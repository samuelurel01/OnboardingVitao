package primeirocrudSQL.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioRepository {

private Connection connection;

private final String nomeTabela = "FUNCIONARIOS";

public void FuncionarioRepository (Connection connection){
    this.connection = connection;

}

private void criarTabelaFuncionarioCasoElaNaoExista(){
    try {
        String query = "CREATE TABLE if not exists" + nomeTabela + "(" +
                "id int primary key auto_increment, " +
                "nome varchar(30), " +
                "salario decimal(10,2), " +
                "genero id_int, " +
                "foreign key (genero_id) references genero(id), " +
                "quantidade_de_vendas int";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

public void criar(String nome, Double salario, Integer quantidade_de_vendas){
    try {
        String query = "INSERT INTO " + nomeTabela + "(nome, salario, genero_id, quantiddade_de_vendas) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,nome);
        preparedStatement.setDouble(2,salario);
       preparedStatement.setInt(2,quantidade_de_vendas);




    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}


}
