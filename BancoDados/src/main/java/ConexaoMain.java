import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMain {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/teste";
        String usuario = "root";
        String senha = "vitor";

        try(Connection conexao = DriverManager.getConnection(url, usuario, senha)){

            System.out.println("Voce conseguiu conectar ao Banco de Dados teste");
        }catch (SQLException erro) {
            erro.printStackTrace();
        }

    }




}

