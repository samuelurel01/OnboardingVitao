import Nota from "../model/Nota.js";
import NotaService from "../service/NotaService.js";

let notaService = new NotaService()
//await notaService.criar("Estudar","Devo estudar javascript")


let nota = new Nota()
nota.id = 32
nota.titulo = "Nota atualizada"
nota.descricao = "nota foi atualizada!"

//await notaService.atualizar(nota)


await notaService.deletarPorId(32)
await notaService.listar();