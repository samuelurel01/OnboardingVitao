package Exercios_Aula1;

import java.util.Scanner;

public class CalculaImpostoRenda {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");

        System.out.println("Informe seu salário: ");
        double salario = scanner.nextDouble();
        System.out.println("\n");

        double[] valorEAliquota = calculaImpostoRenda(salario);
        System.out.println("Valor do Imposto: " + valorEAliquota[0]);
        System.out.println("Aliquota: " + valorEAliquota[1]);

        System.out.println("\n\n\n");
    }


    public static double[] calculaImpostoRenda(double salario) {
        double aliquota = 15.0;
        if(salario <= 2000) {
            aliquota = 7.5;
        }
        return new double[]{(salario * (aliquota/100)), aliquota};
    }
}
