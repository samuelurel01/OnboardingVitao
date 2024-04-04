package primeirocrudSQL.application;

import java.util.Scanner;

// Nesta classe deverá existir metodos que possam receber dados do console.
// 1° Receber texto no console ok
// 2° Receber numero do console ok
// 3° Receber numero decimal do console ok
// 4° Receber texto com opções
// 5° Receber numero com opções
// 6° Numero decimal com opções
// Criar um atributo que será um scanner, que sera usado por algumas funções.


public class ScannerUtils {
    static Scanner scanner = new Scanner(System.in);


    public static String receberUmTextoDoConsole(String pergunta) {
        System.out.println(pergunta);
        String textoInformado = scanner.nextLine();

        return textoInformado;
    }

    public static int receberNumeroNoConsole(String pergunta) {
        System.out.println(pergunta);
        int numeroInformado = scanner.nextInt();


        return numeroInformado;
    }

    public static double receberDecimalNoConsole(String pergunta){
        System.out.println(pergunta);
        double numeroDecimal = scanner.nextDouble();


        return numeroDecimal;

    }



    public static String receberTextoComOpcoes(String pergunta, String[] opcoes){

        while () {
            String opcaoEscolhida = receberUmTextoDoConsole(pergunta);


        }



        return opcaoEscolhida;
    }





}
