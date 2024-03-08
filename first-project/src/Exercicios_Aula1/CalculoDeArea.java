package Exercicios_Aula1;

import java.util.Scanner;

public class CalculoDeArea {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe a base: ");
        double base = leitor.nextDouble();

        System.out.println("Informe a altura: ");
        double altura = leitor.nextDouble();

        double area = calcularArea(base,altura);

        System.out.println("o resultado do calculo da area é:" + area);

    }

    public static double calcularArea(double base, double altura){
        double area = (base * altura)/2;
        return area;
    }




}
