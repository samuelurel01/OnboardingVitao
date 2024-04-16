package com.example.api.model;

import jakarta.persistence.*;
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    private String titulo;

    private Boolean concluida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public Task() {

    }

    public Task(Integer id, String descricao, String titulo, Boolean concluida){
        this.id = id;
        this.descricao = descricao;
        this.titulo = titulo;
        this.concluida = concluida;
    }


}
