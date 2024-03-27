package org.example;

import org.example.Model.Pessoa;
import org.example.repository.PessoaRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/teste";
        String username = "root";
        String password = "vitor";

        try(Connection connection = DriverManager.getConnection(url,username,password)){
//            System.out.println("Você conseguiu conectar o banco de dados!");
            PessoaRepository pessoaRepository = new PessoaRepository(connection);
//            pessoaRepository.criarPessoa("Victor",new Date(2000,1,3));

//            pessoaRepository.atualizar(new Pessoa(1,"João victor",new Date()));
            pessoaRepository.deletarPorId(4);

            for ( Pessoa pessoa : pessoaRepository.listar()) {
                System.out.println(pessoa);
            }

        } catch (SQLException error){
            System.out.println("Erro ao conectar ao banco de dados: " + error.getMessage());
        }
    }



}
