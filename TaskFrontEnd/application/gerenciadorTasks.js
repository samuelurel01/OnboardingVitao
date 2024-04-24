import Task from '../model/Task.js';
import TaskService from '../service/TaskService.js'

let main = document.getElementById("main");

let service = new TaskService()

let listaDeTasks = await service.listar();



let exibirTasks = (tasks) => {
    main.innerHTML = ""
console.log(tasks)
    tasks.forEach(task => {
        main.appendChild(criarTemplateHTMLdeTaskComDOM(task, false))
    });

    main.appendChild(criarTemplateHTMLdeTaskComDOM(criarUltimaTask(), true))
} 

let criarUltimaTask = () => {
    let novaTask = new Task()
    novaTask.titulo = "Titulo"
    novaTask.descricao = "Descrição"

    return novaTask
}

let criarNovaTask = async() => {
    let input = document.querySelector(".newInput")
    let textArea = document.querySelector(".newArea")

    await service.criar(input.value,textArea.value)
    exibirTasks(await service.listar())
}

let removerTaskPorId = async(id) => {
    await service.deletarPorId(id)
    exibirTasks(await service.listar())
}


let criarTemplateHTMLdeTaskComDOM = (task, essaTaskCriar) => {
    let div = document.createElement("div")
    div.classList.add("tarefa")

    if(task.concluida){
        div.classList.add("tarefaConcluida")
    }

    let divBorder = document.createElement("div")
    divBorder.classList.add("cabecalho")

    let input = document.createElement("input")
    input.value = task.titulo
    input.type = "text"

    let textArea = document.createElement("textarea")
    textArea.maxLength = 170
    textArea.value = task.descricao

    if(essaTaskCriar){
        textArea.classList.add("newArea")
        input.classList.add("newInput")
    }

    let atualizarTitulo = async (event) => {

        let taskAtualizada = new Task()
        taskAtualizada.titulo = event.target.value
        taskAtualizada.id = task.id
        await service.atualizarTitulo(taskAtualizada)

        input.removeEventListener("focusout",atualizarTitulo)
        setTimeout(() => {
            input.addEventListener("focusout", atualizarTitulo)
        }, 100)
    }

    let atualizarDescricao = async (event) => {
        let taskAtualizada = new Task()
        taskAtualizada.descricao = event.target.value
        taskAtualizada.id = task.id
        await service.atualizarDescricao(taskAtualizada)


        textArea.removeEventListener("focusout",atualizarDescricao)
        setTimeout(() => {
            textArea.addEventListener("focusout",atualizarDescricao)
        }, 100)
    }

    if(!essaTaskCriar){
        input.addEventListener("focusout",atualizarTitulo)
        textArea.addEventListener("focusout",atualizarDescricao)
    }

    let button = document.createElement("button")
    button.className = essaTaskCriar ? "criar" : "remover"
    let imageRemove = document.createElement("img")
    imageRemove.src = "images/delete.png"
    imageRemove.alt = "delete"

    let textButtonCriar = document.createElement("p")
    textButtonCriar.innerText = "+"

    button.appendChild(essaTaskCriar ? textButtonCriar : imageRemove)

    button.addEventListener('click', (event) => {
    
        if(essaTaskCriar){
            criarNovaTask()
        }else{
            removerTaskPorId(task.id)
        }
    })

    let inputRadio = document.createElement("input")
    inputRadio.type = "radio"

    inputRadio.checked = task.concluida
    
    inputRadio.addEventListener('click', async (event) => {
        if(!task.concluida){
            await service.statusDeConclusao(task.id, true)
            exibirTasks(await service.listar())
        }else{
            await service.statusDeConclusao(task.id, false)
            exibirTasks(await service.listar())
        }
    })


    divBorder.appendChild(input)
    div.appendChild(divBorder)
    div.appendChild(textArea)
    div.appendChild(button)
    
    if(!essaTaskCriar){
        div.appendChild(inputRadio)
    }

    

    return div;
}


exibirTasks(listaDeTasks)