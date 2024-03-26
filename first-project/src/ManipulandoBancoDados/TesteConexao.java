package ManipulandoBancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/teste";
        String username = "root";
        String password = "vitor";

        try(Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Vocẽ conseguiu conectar o banco de dados!");
        } catch (SQLException error){
            System.out.println("Erro ao conectar ao banco de dados: " + error.getMessage());
        }


    }
}
