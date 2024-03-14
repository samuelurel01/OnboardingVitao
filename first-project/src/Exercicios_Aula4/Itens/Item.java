package Exercicios_Aula4.Itens;

public class Item {

    private String nome;

    private String raridade;

    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String trazerInformacoesSobre(){
        return "Esse item é um(a) " + nome + " - possui raridade [ " + raridade+ " ]";
    }
}
