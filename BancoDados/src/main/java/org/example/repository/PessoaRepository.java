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
            String dataNascimentoFormatada = formatarDate(nascimento);
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

    public void atualizar(Pessoa pessoaAtualizada){
        try {
            String query = "UPDATE Pessoa SET nome = ?, data_nascimento = ? where id = ?";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);
            preparedStatement.setString(1,pessoaAtualizada.getNome());
            preparedStatement.setString(2,formatarDate(pessoaAtualizada.getDataNascimento()));
            preparedStatement.setString(3,pessoaAtualizada.getId().toString());

           int linhasAfetadas = preparedStatement.executeUpdate();

           if(linhasAfetadas > 0){
               System.out.println("Pessoa atualizada com sucesso!");
           }else{
               System.out.println("Nenhuma pessoa encontrada para esse ID.");
           }
        }catch (Exception error){
            System.out.println(error);
        }
    }

    public void deletarPorId(Integer id){
        try {
            String query = "DELETE FROM Pessoa WHERE id = ?";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);
            preparedStatement.setString(1,id.toString());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if(linhasAfetadas > 0){
                System.out.println("Pessoa deletada com sucesso!");
            }else{
                System.out.println("Nenhuma pessoa encontrada para esse ID.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String formatarDate(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(data);
    }
}
