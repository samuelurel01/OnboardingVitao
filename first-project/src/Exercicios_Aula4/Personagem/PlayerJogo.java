package Exercicios_Aula4.Personagem;

import Exercicios_Aula4.Itens.ItemCura;

import java.util.List;

public class PlayerJogo extends PersonagemCombate{

    private Integer vidaMaxima;

    private Integer velocidade;

    private Integer defesa;

    private List<ItemCura> itensDeCura;

    public Integer getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(Integer vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public List<ItemCura> getItensDeCura() {
        return itensDeCura;
    }

    public void setItensDeCura(List<ItemCura> itensDeCura) {
        this.itensDeCura = itensDeCura;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }


    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer calcularDanoGolpeEspecial(){
        return (this.getForca() * 2) + this.getArma().getDano();
    }

    public void curarVidaDoPlayer(Integer quantidadeDeVidaParaRestaurar){
        this.setVida(getVida() + quantidadeDeVidaParaRestaurar);

        if(this.getVida() > vidaMaxima){
            this.setVida(vidaMaxima);
        }
    }


}
