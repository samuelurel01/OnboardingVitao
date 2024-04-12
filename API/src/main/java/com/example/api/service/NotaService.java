package com.example.api.service;

import com.example.api.model.Nota;
import com.example.api.repository.NotaRepository;

import java.util.List;

public class NotaService {

    private NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public void criarNota(Nota nota){
        if(nota != null && nota.getDescricao() != null && nota.getTitulo() != null){
            notaRepository.criarNota(nota);
        }
    }

    public List<Nota> listar(){
        return notaRepository.listar();
    }

    public void deletarNota(Integer id){
        if(id != null){
            notaRepository.deletarPorId(id);
        }
    }

    public void atualizar(Nota notaAtualizada){
        if(notaAtualizada != null && notaAtualizada.getDescricao() != null && notaAtualizada.getTitulo() != null && notaAtualizada.getId() != null){
            notaRepository.atualizar(notaAtualizada);
        }
    }

    public void atualizarTituloPorId(Nota notaAtualizada){
        if(notaAtualizada != null){
            notaRepository.atualizarTituloPorId(notaAtualizada);
        }
    }

    public void atualizarDescricaoPorId(Nota notaAtualizada){
        if(notaAtualizada != null){
            notaRepository.atualizarDescricaoPorId(notaAtualizada);
        }
    }


}
