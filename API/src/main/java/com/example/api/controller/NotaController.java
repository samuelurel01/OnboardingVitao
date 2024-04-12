package com.example.api.controller;

import com.example.api.model.Nota;
import com.example.api.repository.NotaRepository;
import com.example.api.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController() {
        Conexao conexao = new Conexao("jdbc:mysql://localhost:3306/teste","root","vitor");
        this.notaService = new NotaService(new NotaRepository(conexao.criarConexao()));
    }

    @GetMapping
    public List<Nota> listarNotas(){
        return notaService.listar();
    }

    @PostMapping
    public void criarNota(@RequestBody Nota nota){
        notaService.criarNota(nota);
    }

    @PutMapping
    public void atualizarNota(@RequestBody Nota notaAtualizada){
        notaService.atualizar(notaAtualizada);
    }

    @PutMapping("/titulo")
    public void atualizarTituloPorId(@RequestBody Nota notaAtualizada){
        notaService.atualizarTituloPorId(notaAtualizada);
    }

    @PutMapping("/descricao")
    public void atualizarDescricaoPorId(@RequestBody Nota notaAtualizada){
        notaService.atualizarDescricaoPorId(notaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarNota(@PathVariable Integer id){
        notaService.deletarNota(id);
    }
}
