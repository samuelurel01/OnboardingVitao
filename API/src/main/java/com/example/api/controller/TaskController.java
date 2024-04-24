package com.example.api.controller;

import com.example.api.model.Task;
import com.example.api.repository.TaskRepository;
import com.example.api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(){
        Conexao conexao = new Conexao("jdbc:mysql://localhost:3306/teste","root","vitor");
        this.taskService = new TaskService(new TaskRepository(conexao.criarConexao()));
    }


    @GetMapping
    public List<Task> listarTasks(){
        return taskService.listar();
    }

    @PostMapping
    public void criarTask(@RequestBody Task task){taskService.criarTask(task);}

    @PutMapping
    public void atualizarTask(@RequestBody Task taskAtualizada){
        taskService.atualizar(taskAtualizada);
    }

    @PutMapping("atualizarPorId")
    public void atualizarTituloPorId(@RequestBody Task taskAtualizada){
        taskService.atualizarTituloPorId(taskAtualizada);

    }

    @PutMapping("atualizarDescricaoPorId")
    public void atualizarDescricaoPorId(@RequestBody Task taskAtualizada){taskService.atualizarDescricaoPorId(taskAtualizada);}

    @DeleteMapping("{id}")
    public void deletarTask(@PathVariable Integer id){taskService.deletarTask(id);}

    @PutMapping("atualizarStatusConclusaoPorId/{id}")
    public void atualizarStatusDeConclusaoPorId(@PathVariable Integer id, @RequestBody Boolean concluida) {
        taskService.atualizarStatusDeConclusaoPorId(id, concluida);
    }




}


