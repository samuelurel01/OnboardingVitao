package Exercicios_Aula4.Personagem;

import Exercicios_Aula4.GameUtil;

public class Inimigo extends PersonagemCombate{

    private Integer chanceDeDarMaisDano;

    @Override
    public Integer calcularDanoDoGolpeSimples(){
        boolean adicionarDanoExtra = GameUtil.eventoAconteceApartirDeUmaProbabilidade(chanceDeDarMaisDano);
        return getForca() + getArma().getDano() + (adicionarDanoExtra ? calcularDanoExtraDeSorte() : 0);
    }

    public Integer calcularDanoExtraDeSorte(){
        return GameUtil.gerarNumeroAleatorioEntre(0,getForca());
    }

    public Integer getChanceDeDarMaisDano() {
        return chanceDeDarMaisDano;
    }

    public void setChanceDeDarMaisDano(Integer chanceDeDarMaisDano) {
        this.chanceDeDarMaisDano = chanceDeDarMaisDano;
    }
}
