package com.example.api.controller;

import com.example.api.model.Pessoa;
import com.example.api.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController() {
        Conexao conexao = new Conexao("jdbc:mysql://localhost:3306/teste","root","vitor");
        this.pessoaRepository = new PessoaRepository(conexao.criarConexao());
    }

    @PostMapping
    public void criarPessoa(@RequestBody Pessoa pessoa) {
        pessoaRepository.criarPessoa(pessoa.getNome(), pessoa.getDataNascimento());
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.listar();
    }

    @PutMapping("/{id}")
    public void atualizarPessoa(@PathVariable Integer id, @RequestBody Pessoa pessoaAtualizada) {
        pessoaAtualizada.setId(id);
        pessoaRepository.atualizar(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Integer id) {
        pessoaRepository.deletarPorId(id);
    }

    @GetMapping("/saudacao")
    public String realizarSaudacao(){
        return "Seja bem vindo amigo!";
    }

    @GetMapping("/saudacao/{nome}")
    public String realizarSaudacaoNome(@PathVariable String nome){
        return "Seja bem vindo " + nome;
    }
}

