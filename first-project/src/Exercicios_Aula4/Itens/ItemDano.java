package Exercicios_Aula4.Itens;

public class ItemDano extends Item {

    private Integer dano;

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    @Override
    public String trazerInformacoesSobre(){
        return "Esse é um item de combate e possui " + dano + " dano";
    }
}
