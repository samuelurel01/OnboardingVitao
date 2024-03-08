package Exercios_Aula1;

import java.sql.SQLOutput;

public class CalculoDeArea {
    public static void main(String[] args) {

        double base = 6.0;
        double altura = 4.0;

        double area = calcularArea(base,altura);

        System.out.println("o resultado do calculo da area é:" + area);

    }

    public static double calcularArea(double base, double altura){
        double area = (base * altura)/2;
        return area;
    }




}
