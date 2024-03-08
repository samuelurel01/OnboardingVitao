package Exercicios_Aula1;

import java.util.Scanner;

public class CalcularMediaPonderada {
    public static void main(String[] args) {
       executarProgramaDeCalculoDeMedia();

    }
     public static void executarProgramaDeCalculoDeMedia(){
        boolean programaEstaAtivo = true;

        while (programaEstaAtivo){
            System.out.println("Seja Bem Vindo ao programa de calculo de média!");
            quebrarLinhas(2);

            //Escrever as opções que o usuario ira escolher
            //Armazenar a opção escolhida pelo usuario
            // 1 - Caso escolher sair, encerar o programa
            // 2 - Cadastrar aluno e suas respectivas notas
            // 3 - Exibir media da turma
            // 4 - Exibir media de um aluno

        }

     }

     public static void quebrarLinhas(int numeroDeLinhas){
        for (int i = 1; numeroDeLinhas >= i; i++) {
            System.out.println();
        }
     }





    // Função de entrada de dados através do scanner
    public static String receberUmTextoDoConsole(String pergunta){
        System.out.println(pergunta);
        Scanner scanner = new Scanner(System.in);
        String textoInformado = scanner.nextLine();
        scanner.close();
        return textoInformado;
    }
    public  static double receberUmNumeroDoConsole(String pergunta){
        System.out.println(pergunta);
        Scanner scanner = new Scanner(System.in);
        double numeroInformado = scanner.nextDouble();
        scanner.close();
        return numeroInformado;

    }


}

