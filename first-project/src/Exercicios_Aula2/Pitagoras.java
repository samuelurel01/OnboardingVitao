package Exercicios_Aula2;

import java.util.Scanner;

public class Pitagoras {
    public static void main(String[] args) {
        realizarCalculoDePitagoras();




    }

    public static void realizarCalculoDePitagoras(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem vindo ao programa de calculo de pitagoras!");;
        System.out.println("1- Informar cateto e hipotenusa, para calcular o outro cateto");
        System.out.println("2- Informar os dois catetos, para calcular a hipotenusa");

        String opcaoInformada = scanner.nextLine();

        //Caso ele escolha 1, ele deve informar cateto e hipotenusa.
        //Caso ele escolha 2, ele deve informar o valor dos dois catetos.

        if(opcaoInformada.compareTo("1")== 0){
            System.out.println("Informe os valor do cateto:");
            double valorCateto = scanner.nextDouble();

            System.out.println("Informe o valor da hipotenusa");
            double valorHipotenusa = scanner.nextDouble();

            double outroCateto = Math.sqrt((valorHipotenusa * valorHipotenusa) - (valorCateto * valorCateto));

            System.out.println("O valor do outro cateto;" + outroCateto);


        } else if (opcaoInformada.compareTo("2")==0) {
            System.out.println("Informe o valor do primeiro cateto:");
            double valorPrimeiroCateto = scanner.nextDouble();

            System.out.println("Informe o valor do segundo cateto");
            double valorSegundoCateto = scanner.nextDouble();

            double calculoHipotenusa = Math.sqrt((valorPrimeiroCateto * valorPrimeiroCateto) + (valorSegundoCateto * valorSegundoCateto));

            System.out.println("O valor da Hipotenusa é:" + calculoHipotenusa);
        }



    }




    }
