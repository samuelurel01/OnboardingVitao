import Nota from "../model/Nota.js";
import NotaService from "../service/NotaService.js";

let notaService = new NotaService()


let notas = await notaService.listar()

notas.forEach( nota => {
    document.body.innerHTML += `<div class='card'>
        <p>Id: ${nota.id}</p>
        <p>Titulo: ${nota.titulo}</p>
        <p>Descrição: ${nota.descricao}</p>
    </div>
    `
})