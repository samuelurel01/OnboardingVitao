import Task from "../model/Task.js"

export default class TaskService{

    async listar(){
        let tarefas = []

        await fetch('http://localhost:8080/api/tasks', {
            method: 'GET',
            headers: {
                'Content-Type' : 'application/json'
            },
        })

        .then(response => response.json())
        .then(data => {
            tarefas = data
        }).catch(erro => {
            console.log(erro)
        })

        return tarefas

    }

    async criar(titulo,descricao){
        let tarefa = new Task()
        tarefa.titulo = titulo
        tarefa.descricao = descricao
        tarefa.concluida = false
        await fetch('http://localhost:8080/api/tasks',{
            method: 'POST',
            headers: {
                'Content-Type' : 'application/json'
            },
            body: JSON.stringify(tarefa)
        }).then(response => {
            if(!response.ok){
                throw new error('Ocorreu um erro na solicitação POST')
            }

            console.log("Solicitação POST bem sucedida!")
        }).catch(erro => {
            console.error("Error: ",erro)
        })
            
    }

    async atualizar(taskAtualizada){
        await fetch('http://localhost:8080/api/tasks', {
            method: 'PUT',
            headers: {
                'Contente-Type': 'application/json'
            },
            body:JSON.stringify(taskAtualizada)
        }).then(response => {
            if(!response.ok){
                throw new error('Ocorreu um erro na solicitação PUT')
            }

            console.log("solicitação PUT bem sucedida!")
        }).catch(error => {
            console.error("",error)
        })
        
        
    }

    async atualizarTitulo(taskAtualizada){
        await fetch('http://localhost:8080/api/tasks/atualizarPorId',{
            method: "PUT",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(taskAtualizada)
        }).then(response => {
            if(!response.ok){
                throw new error('Ocorreu um erro na solicitação PUT')
            }

            console.log("Solicitação PUT bem sucedida!")
        }).catch(error =>{
            console.error("error",error)
        })
    }

    async atualizarDescricao(taskAtualizada){
        await fetch('http://localhost:8080/api/tasks/atualizarDescricaoPorId', {
            method: "PUT",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(taskAtualizada)  
        }).then(response => {
            if(!response.ok){
                throw new error('Ocorre um erro na solicitação PUT')
            }

            console.log("Solicitação PUT bem sucedida!")
        }).catch(error =>{
            console.error("error: ",error)
        })
    }

    async deletarPorId(id){
        await fetch(`http://localhost:8080/api/tasks/${id}`, {
            method: "DELETE",
        }).then(response => {
            if(!response.ok){
                throw new Error('Ocorreu um erro na sua solicitação DELETE')
            }
 
            console.log("Solicitação DELET bem sucedida!")
        }).catch(erro =>{
            console.error('error: ', erro)
        })
    }

    async statusDeConclusao(id, concluida) {
        const url = `http://localhost:8080/api/tasks/atualizarStatusConclusaoPorId/${id}`;
        try {
            const response = await fetch(url, {
                method: "PUT",
                headers: {
                    "Content-type": "application/json"
                },
                body: JSON.stringify(concluida)
            });
    
            if (!response.ok) {
                throw new Error('Ocorreu um erro na solicitação PUT');
            }
    
            console.log("Solicitação PUT bem sucedida");
        } catch (error) {
            console.error("error", error);
        }
    }

}