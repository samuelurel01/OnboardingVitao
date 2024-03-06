package LoopDeRepeticao;

import java.util.Scanner;

public class LoopRepeticaoMain {

    public static void main(String[] args) {
        // Toda vez que um determinado código precisar ser repetido vamos utilizar loops de repetição


        int numeroTabuada = 5;

        // 5 x 1 = 5
        // 5 x 2 = 10
        // 5 x 3 = 15
        // 5 x 4 = 20

        // Variavel Auxiliar - Condição de repetição - Controle da variavel
        for (int index = 1; index <= 10; index++){
            int resultado = numeroTabuada * index;
            System.out.println(numeroTabuada + " x " + index + " = " +  resultado );
        }

        boolean possoContinuarWhile = true;
        int numeroInformadoPeloUsuario;

        Scanner scanner = new Scanner(System.in);

        // Só precisa da condição de repetição
        while (possoContinuarWhile){
            System.out.println("Digite um numero de 1 a 10: ");
            numeroInformadoPeloUsuario = scanner.nextInt();

            if(numeroInformadoPeloUsuario > 10 || numeroInformadoPeloUsuario < 1){
                System.out.println("Numero invalido!");
            }else{
                System.out.println("Numero válido!");
                possoContinuarWhile = false;
            }
        }

        // Ele executa pelo menos uma vez
        do{
            System.out.println("Executou");
        }while (false);
    }


}
