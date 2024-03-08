package Exercicios_Aula1;

import Exercicios_Aula2.Pessoa;

import java.util.Date;

public class Exemplos {

    public static void main(String[] args) {


//        int[] teste = new int[]{};
//
//
//        teste[0] = 25;
//        teste[1] = 30;


        //teste = [25, 30]


        //Programacao Orientada a Objeto -> POO
        //Itens, elementos basico, fundamentos

        //Classes | Objetos | Atributos | Métodos | Construtores

        //Classe: eles possuem um nome
        //ela possuem a visibilidade;

        //Tipos de visibilidade: public (public), private (privada), protected (protegida)
        //Funcões

        //o que ela é ? A Classe é a definição do objetos (caracteristicas, comportamentos, etc);


        Pessoa vitor = new Pessoa("Victor Hugo Souta");


        vitor.setAltura(1.75);
        vitor.setDataNascimento(new Date());
        vitor.setCorOlhos("Azul");

        System.out.println(vitor);

    }
}
