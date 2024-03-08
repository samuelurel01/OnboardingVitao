package Exercicios_Aula1;

import java.util.Scanner;

public class calculoDeImc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua altura:");
        double altura = scanner.nextDouble();

        System.out.println("Digite seu peso:");
        double peso = scanner.nextDouble();

        scanner.close();

        double imc = calcularImc(altura,peso);

        System.out.println("Seu calculo de IMC é:" + imc);

    }

    public static double calcularImc(double altura, double peso){
        double imc = peso/(altura * altura);
        return imc;

    }
}



