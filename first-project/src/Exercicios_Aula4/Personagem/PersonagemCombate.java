package Exercicios_Aula4.Personagem;

import Exercicios_Aula4.GameUtil;
import Exercicios_Aula4.Itens.ItemArmadura;
import Exercicios_Aula4.Itens.ItemDano;

public class PersonagemCombate {

    private String nome;

    private Integer forca;

    private Integer vida;

    private ItemDano arma;

    private ItemArmadura armadura;

    private boolean estaVivo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public ItemDano getArma() {
        return arma;
    }

    public void setArma(ItemDano arma) {
        this.arma = arma;
    }

    public ItemArmadura getArmadura() {
        return armadura;
    }

    public void setArmadura(ItemArmadura armadura) {
        this.armadura = armadura;
    }

    public Integer calcularDanoDoGolpeSimples(){
        return getForca() + getArma().getDano();
    }

    //todo - Será passada uma porcentagem de chance de acertar um golpe, e se acertar da todo dano, senão causa 0 de dano
    public Integer calcularDanoDoGolpeSimples(Integer chanceDeAcertarGolpe){
        boolean acertouAtaque = GameUtil.eventoAconteceApartirDeUmaProbabilidade(chanceDeAcertarGolpe);

        return acertouAtaque ? calcularDanoDoGolpeSimples() : 0;
    }

    public void receberDano(Integer dano){
        this.vida -= dano;

        if(this.vida < 0){
            this.vida = 0;
            this.estaVivo = false;
        }
    }
}
