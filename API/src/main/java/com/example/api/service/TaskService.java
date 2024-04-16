package com.example.api.service;

import com.example.api.model.Task;
import com.example.api.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository){this.taskRepository = taskRepository;}


    public void criarTask(Task task){
        if(task != null && task.getDescricao() != null && task.getTitulo() != null && task.getConcluida() != null){
            taskRepository.criarTask(task);
        }
    }

    public List<Task> listar(){return taskRepository.listar();}


    public void deletarTask(Integer id){
        if(id != null){
            taskRepository.deletarPorId(id);
        }
    }

    public void atualizar(Task taskAtualizada){
        if(taskAtualizada != null && taskAtualizada.getDescricao() != null && taskAtualizada.getTitulo() != null);
        taskRepository.atualizar(taskAtualizada);
    }

    public void atualizarTituloPorId(Task taskAtualizada){
        if(taskAtualizada != null){
            taskRepository.atualizarTituloPorId(taskAtualizada);
        }
    }

    public void atualizarDescricaoPorId(Task taskAtualizada){
        if(taskAtualizada != null){
            taskRepository.atualizarDescricaoPorId(taskAtualizada);
        }
    }

    public void atualizarStatusDeConclusaoPorId(Integer id, Boolean concluida){
        if(id != null && concluida != null){
            taskRepository.atualizarStatusDeConclusaoPorId(id, concluida);
        }
    }
}


