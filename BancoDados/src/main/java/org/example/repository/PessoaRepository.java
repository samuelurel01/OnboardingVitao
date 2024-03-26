package org.example.repository;

import org.example.Model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaRepository {

    private Connection conexaoBanco;

    public PessoaRepository(Connection connection) {
        conexaoBanco = connection;
    }

    public void criarPessoa(String nome, Date nascimento){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataNascimentoFormatada = sdf.format(nascimento);
            String insertQuery = "INSERT INTO Pessoa (nome,data_nascimento) VALUES('" + nome + "','" + dataNascimentoFormatada + "')";

            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(insertQuery);
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("rowsAffected " + rowAffected + " row(s) inserted successufully!");
            System.out.println("Criado uma nova pessoa no banco!");
            preparedStatement.close();
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<Pessoa> listar(){
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Pessoa";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nome= resultSet.getString("nome");
                Date nascimento = resultSet.getDate("data_nascimento");

                pessoas.add(new Pessoa(id,nome,nascimento));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }


        return pessoas;
    }
}
