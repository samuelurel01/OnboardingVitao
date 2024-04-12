import Nota from '../model/Nota.js';
import NotaService from '../service/NotaService.js'

let main = document.getElementById("main")

let service = new NotaService()

let listaDeNotas = await service.listar();



let exibirNotas = (notas) => {
    main.innerHTML = ""

    notas.forEach(nota => {
        main.appendChild(criarTemplateHTMLdeNotaComDOM(nota,false))
    });

    main.appendChild(criarTemplateHTMLdeNotaComDOM(criarUltimaNota(),true))
}

let criarUltimaNota = () => {
    let novaNota = new Nota()
    novaNota.titulo = "Titulo"
    novaNota.descricao = "Descrição"

    return novaNota
}

let criarTemplateHTMLdeNotaComDOM = (nota,essaNotaCriar) => {
    let div = document.createElement("div");
    div.classList.add("card")

    let divBorder = document.createElement("div")
    divBorder.classList.add("borderTop")

    let divContent = document.createElement("div")
    divContent.classList.add("content")

    let input = document.createElement("input")
    input.value = nota.titulo
    input.type = "text";

    let textArea = document.createElement("textarea")
    textArea.maxLength = 170
    textArea.value = nota.descricao

    if(essaNotaCriar){
        textArea.classList.add("newArea")
        input.classList.add("newInput")
    }

    let atualizarTitulo = async (event) => {
        
        let notaAtualizada = new Nota()
        notaAtualizada.titulo = event.target.value
        notaAtualizada.id = nota.id
        await service.atualizarTitulo(notaAtualizada)

        input.removeEventListener("focusout",atualizarTitulo)
        setTimeout(() => {
            input.addEventListener("focusout",atualizarTitulo)
        },100)
        
    }

    let atualizarDescricao = async (event) => {
        let notaAtualizada = new Nota()
        notaAtualizada.descricao = event.target.value
        notaAtualizada.id = nota.id
        await service.atualizarDescricao(notaAtualizada)


        textArea.removeEventListener("focusout",atualizarDescricao)
        setTimeout(() => {
            textArea.addEventListener("focusout",atualizarDescricao)
        },100)
    }

    if(!essaNotaCriar){
        input.addEventListener("focusout", atualizarTitulo )
        textArea.addEventListener("focusout", atualizarDescricao)
    }

    let button = document.createElement("button")

    let imageRemove = document.createElement("img")
    imageRemove.src= "images/delete.png"
    imageRemove.alt = "delete"

    let textButtonCriar = document.createElement("p")
    textButtonCriar.innerText = "+"

    button.appendChild(essaNotaCriar ? textButtonCriar : imageRemove)
    button.addEventListener('click', () => {
        if(essaNotaCriar){
            criarNovaNota()
        }else{
            removerNotaPorId(nota.id)
        }
    })

    divContent.appendChild(input)
    divContent.appendChild(textArea)

    div.appendChild(divBorder)
    div.appendChild(divContent)
    div.appendChild(button)

    return div;
}

let criarNovaNota = async() => {
    let input = document.querySelector(".newInput")
    let textArea = document.querySelector(".newArea")

    await service.criar(input.value,textArea.value)
    exibirNotas(await service.listar())
}

let removerNotaPorId = async (id) => {
    await service.deletarPorId(id)
    exibirNotas(await service.listar())
}

exibirNotas(listaDeNotas)