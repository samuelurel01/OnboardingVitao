package com.example.api.repository;

import com.example.api.model.Nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaRepository {

    private Connection conexaoBanco;

    public NotaRepository(Connection conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public void criarNota(Nota nota){
        try{
            String query = "INSERT INTO notas (descricao,titulo) VALUES (?,?)";
            PreparedStatement preparacaoDeDeclaracao = conexaoBanco.prepareStatement(query);
            preparacaoDeDeclaracao.setString(1,nota.getDescricao());
            preparacaoDeDeclaracao.setString(2,nota.getTitulo());

            preparacaoDeDeclaracao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Nota> listar(){
        List<Nota> notas = new ArrayList<>();

        try{
            String query = "SELECT * FROM notas";
            PreparedStatement preparacaoDeDeclaracao = conexaoBanco.prepareStatement(query);

            ResultSet resultSet = preparacaoDeDeclaracao.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                String titulo = resultSet.getString("titulo");

                notas.add(new Nota(id,descricao,titulo));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notas;
    }

    public void atualizar(Nota notaAtualizada){
        try{
            String query = "UPDATE notas SET titulo = ?, descricao = ? where id = ?";
            PreparedStatement preparacaoDeDeclaracao = conexaoBanco.prepareStatement(query);
            preparacaoDeDeclaracao.setString(1,notaAtualizada.getTitulo());
            preparacaoDeDeclaracao.setString(2,notaAtualizada.getDescricao());
            preparacaoDeDeclaracao.setString(3,notaAtualizada.getId().toString());

            preparacaoDeDeclaracao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarTituloPorId(Nota notaAtualizada){
        try{
            String query = "UPDATE notas SET titulo = ? where id = ?";
            PreparedStatement preparacaoDeDeclaracao = conexaoBanco.prepareStatement(query);
            preparacaoDeDeclaracao.setString(1,notaAtualizada.getTitulo());
            preparacaoDeDeclaracao.setString(2,notaAtualizada.getId().toString());

            preparacaoDeDeclaracao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarDescricaoPorId(Nota notaAtualizada){
        try{
            String query = "UPDATE notas SET descricao = ? where id = ?";
            PreparedStatement preparacaoDeDeclaracao = conexaoBanco.prepareStatement(query);
            preparacaoDeDeclaracao.setString(1,notaAtualizada.getDescricao());
            preparacaoDeDeclaracao.setString(2,notaAtualizada.getId().toString());

            preparacaoDeDeclaracao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void deletarPorId(Integer id){
        try{
            String query = "DELETE FROM notas where id = ?";
            PreparedStatement preparacaoDeDeclaracao = conexaoBanco.prepareStatement(query);
            preparacaoDeDeclaracao.setString(1,id.toString());

            preparacaoDeDeclaracao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
