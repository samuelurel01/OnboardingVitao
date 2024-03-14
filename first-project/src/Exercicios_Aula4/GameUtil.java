package Exercicios_Aula4;

public class GameUtil {

    public static boolean eventoAconteceApartirDeUmaProbabilidade(Integer chanceDeExecutarAcao){
        Integer numeroAleatorio = gerarNumeroAleatorioEntre(0,100);

        return numeroAleatorio <= chanceDeExecutarAcao;
    }

    public static Integer gerarNumeroAleatorioEntre(Integer valorMinino, Integer valorMaximo){
        double numeroAletorio = Math.random() * (valorMaximo - valorMinino + 1) + valorMinino;
        Integer numeroAletorioInteiro = (int) numeroAletorio;

        return numeroAletorioInteiro;
    }

}
