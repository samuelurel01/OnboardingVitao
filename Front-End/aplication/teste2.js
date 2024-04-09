import Nota from "../model/Nota.js";
import NotaService from "../service/NotaService.js";

let notaService = new NotaService()


await notaService.criar("Estudar matematica","Devo estudar matematica")
await notaService.criar("Estudar futvolei","Devo estudar futvolei")
await notaService.criar("Dar banho no luan","Lavar meu cachorro luan")
await notaService.criar("Voar de aviao","Realizar viagem de negocio")


let notas = await notaService.listar()

notas.forEach( nota => {
    document.body.innerHTML += `<div class='card'>
        <p>Id: ${nota.id}</p>
        <p>Titulo: ${nota.titulo}</p>
        <p>Descrição: ${nota.descricao}</p>
    </div>
    `
})