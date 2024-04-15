package com.example.api.repository;

import com.example.api.model.Nota;
import com.example.api.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private Connection conexaoBanco;

    public TaskRepository(Connection conexaoBanco){this.conexaoBanco = conexaoBanco;}


    public void CriarTask(Task task){
        try {
            String query = "INSERT INTO task (descricao,titulo) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);
            preparedStatement.setString(1, task.getDescricao());
            preparedStatement.setString(2, task.getTitulo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> listar(){
        List<Task> tasks = new ArrayList<>();

        try {
            String query = "SELECT * FROM task";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                String titulo = resultSet.getString("titulo");

                tasks.add(new Task(id,descricao,titulo));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    public void atualizar(Task taskAtualizada){
        try{
            String query = "UPDATE tasks SET titulo = ?, descricao = ? where id = ?";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);
            preparedStatement.setString(1,taskAtualizada.getTitulo());
            preparedStatement.setString(2,taskAtualizada.getDescricao());
            preparedStatement.setString(3,taskAtualizada.getId().toString());

           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarTituloPorId(Task taskAtualizada){
        try{
            String query = "UPDATE notas SET titulo = ? where id = ?";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);
            preparedStatement.setString(1,taskAtualizada.getTitulo());
            preparedStatement.setString(2,taskAtualizada.getId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarDescricaoPorId(Task taskAtualizada){
        try{
            String query = "UPDATE notas SET descricao = ? where id = ?";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);
            preparedStatement.setString(1,taskAtualizada.getDescricao());
            preparedStatement.setString(2,taskAtualizada.getId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarPorId(Integer id){
        try{
            String query = "DELETE FROM notas where id = ?";
            PreparedStatement preparedStatement = conexaoBanco.prepareStatement(query);
           preparedStatement.setString(1,id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
