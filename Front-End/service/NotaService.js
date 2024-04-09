import Nota from "../model/Nota.js"

export default class NotaService {

    async listar(){
        await fetch('http://localhost:8080/api/notas', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        })
        .then(response => response.json())
        .then(data => {
            console.log(data)
        }).catch(erro => {
            console.log(erro)
        })
    }

    async criar(titulo,descricao){
        let nota = new Nota()
        nota.titulo = titulo
        nota.descricao = descricao

        await fetch('http://localhost:8080/api/notas',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nota)
     }).then(response => {
        if(!response.ok){
            throw new Error('Ocorreu um erro na solicitação POST')
        }

        console.log("Solicitação post bem sucedida!")
     }).catch(erro => {
        console.error("Error: ",erro)
     })
    }

    async atualizar(notaAtualizada){
        await fetch('http://localhost:8080/api/notas', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(notaAtualizada)
        }).then(response => {
            if(!response.ok){
                throw new Error('Ocorreu um erro na solicitação PUT')
            }

            console.log("Solicitação put bem sucedida!")
        }).catch(error => {
            console.error('Erro: ', error)
        })
    }

    async deletarPorId(id){
        await fetch(`http://localhost:8080/api/notas/${id}`,{
            method: 'DELETE',
        }).then(response => {
            if(!response.ok){
                throw new Error('Ocorreu um erro na solicitação DELETE')
            }
            
            console.log("Solicitação delete bem sucedida!")
        }).catch(erro => {
            console.error('Error: ', erro)
        })
    }
}