package Exercicios_Aula4.TarefaHeranca;

//1 - Criar as classes e identificar suas características OK
//2 - Criar um metodo na classe pai chamado "devolverCaracteristicas" OK
//3 - Criar um método que sobreescreva (override) em uma das classes filha OK
//
//    Criar uma classe que possua a função main pra executar tudo OK
//
//4 - Criar duas listas, uma de carnivoro e outra de herbivero OK
//5 - Vai fazer cadastro de animal e se for carnivoro vai pra lista de carnivoro, caso contrario vai pra herbivero
//6 - Listar todos os animais (listar ambas as listas) e usar o metodo devolver caracteristicas

public class Animal {

    private String nome;

    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String devolverCaracteristicas(){
        return "{ Nome: " + nome + " Descrição: " + descricao  +" }";

    }

    @Override
    public String toString(){
        return "{Nome: " + nome + " Descrição: " + descricao + "}";
    }



}
