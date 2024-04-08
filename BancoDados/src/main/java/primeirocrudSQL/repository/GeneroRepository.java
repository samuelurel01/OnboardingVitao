package primeirocrudSQL.repository;

import primeirocrudSQL.model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe responsável por manipular o banco de dados
public class GeneroRepository {

    private Connection connection;

    private final String nomeTabela = "GENEROS";

    public GeneroRepository(Connection connection){
        this.connection = connection;
        criarTabelaGeneroCasoElaNaoExista();
    }

    private void criarTabelaGeneroCasoElaNaoExista(){
        try {
            String query = "CREATE TABLE if not exists " + nomeTabela + " ( " +
                    "        id int primary key auto_increment, " +
                    "        nome varchar(30), " +
                    "        sigla varchar(5) )";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void criar(String nome, String sigla){
        try {
            String query = "INSERT INTO " + nomeTabela + " (nome,sigla) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2,sigla);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Genero genero){
        try {
            String query = "UPDATE " + nomeTabela + " SET nome = ?, sigla = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,genero.getNome());
            preparedStatement.setString(2,genero.getSigla());
            preparedStatement.setString(3,String.valueOf(genero.getId()));

           int linhasAfetadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarPorId(Integer id){
        try {
            String query = "DELETE FROM " + nomeTabela + " WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id.toString());

            int linhasAfetadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Genero> listar(){
        List<Genero> generos = new ArrayList<>();

        try{
            String query = "SELECT * FROM " + nomeTabela;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultadoDaQuery = preparedStatement.executeQuery();

            while (resultadoDaQuery.next()){
                Integer id = resultadoDaQuery.getInt("id");
                String nome = resultadoDaQuery.getString("nome");
                String sigla = resultadoDaQuery.getString("sigla");

                Genero genero = new Genero(id,nome,sigla);
                generos.add(genero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return generos;
    }

    public Genero pegarGeneroPorId(Integer id){
        Genero genero = new Genero();

        try {
               String query = "SELECT * FROM " + nomeTabela + " WHERE id = ?";
               PreparedStatement preparedStatement = connection.prepareStatement(query);
               preparedStatement.setString(1,id.toString());
                ResultSet resultadoDaQuery = preparedStatement.executeQuery();
               if(resultadoDaQuery.next()){
                   genero.setId(resultadoDaQuery.getInt("id"));
                   genero.setNome(resultadoDaQuery.getString("nome"));
                   genero.setSigla(resultadoDaQuery.getString("sigla"));
               }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return genero;
    }





}
