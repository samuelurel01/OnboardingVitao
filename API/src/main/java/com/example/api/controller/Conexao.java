package com.example.api.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String url;
    private String usuario;
    private String senha;

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public Connection criarConexao(){
       try {
           Connection conexao = DriverManager.getConnection(url, usuario, senha);
           System.out.println("Voce conseguiu conectar ao Banco de Dados!");
           return conexao;
       }catch (SQLException error){
           error.printStackTrace();
           return null;
       }
    }

    public Conexao(String url, String usuario, String senha){
        setUrl(url);
        setUsuario(usuario);
        setSenha(senha);
    }

}
