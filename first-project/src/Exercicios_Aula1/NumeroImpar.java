package Exercicios_Aula1;

import java.util.Arrays;
import java.util.Scanner;

public class NumeroImpar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Programa para encotrar numero impares antes do numero informado =========:");
        System.out.println("Digite um numero:");

        //Numero lido na console
        int numero = scanner.nextInt();

        int qtdImpares = 0;
        //Loop para contar quantos numeros existem na sequencia
        for (int i = 1; i <= numero; i++){

            //Condição que verifica se o numero é impar
            if (i % 2 != 0){

                //Soma na variavel + 1, que é a  conta dos numeros impares
                qtdImpares++;
            }
        }

        //Array que irá armazenar os numero impares
        int[] numerosImpar = new int[qtdImpares];

        //Loop para percorrer cada numero até o numero informado no consolo
        for (int i = 1, j = 0; i <= numero; i++){

            //Condição que verifica se o numero é impar
            if (i % 2 != 0){

                //Armazena o numero impar no arr
                numerosImpar[j] = i;
                j++;
            }
        }

        System.out.println(Arrays.toString(numerosImpar));
    }
}
