package org.example.service;

import org.example.Model.Pessoa;
import org.example.repository.PessoaRepository;

import java.util.Date;
import java.util.List;

public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository pessoaRepository) {
        repository = pessoaRepository;
    }

    public void criarPessoa(String nome, Date dataNascimento){
        repository.criarPessoa(nome,dataNascimento);
    }

    public List<Pessoa> listar(){
       return repository.listar();
    }

    public void atualizar(Pessoa pessoaAtualizada){
        repository.atualizar(pessoaAtualizada);
    }

    public void deletarPorId(Integer id){
        repository.deletarPorId(id);
    }
}
