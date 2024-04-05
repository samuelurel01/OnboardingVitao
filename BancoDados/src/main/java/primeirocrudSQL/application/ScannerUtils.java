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

    // Receber uma resposta do usuario
    // Validar se a resposta é uma das opções possiveis, sendo que para validar devemos ver se a opção escolhida(resposta) é igual a uma das opções disponiveis
    // Devolver caso a resposta seja valida, caso contrario iremos repetir a pergunta e validar novamente
    public static String receberTextoComOpcoes(String pergunta, String[] opcoes){
        boolean possoContinuarPedirRespostaDoUsuario = true; // Variavel auxiliar que controla se o processo deve-se repetir
        String valorInformadoNoConsolePeloUsuario = "";

        while(possoContinuarPedirRespostaDoUsuario) {// LOOP PARA REPETIR O PROCESSO
            valorInformadoNoConsolePeloUsuario = receberUmTextoDoConsole(pergunta); // A função devolve uma string informada pelo usuario e armazenamos em uma variavel

            if(opcaoEstaValida(valorInformadoNoConsolePeloUsuario,opcoes)){ // Verificamos se nossa resposta do usuario é igual a umas das opções disponiveis
                return valorInformadoNoConsolePeloUsuario; // Devolvemos quando é valido
            }else{
                System.out.println("Opção informada não é valida!"); // Informamos que a opção está invalida e o processo se repete
            }
        }

        return valorInformadoNoConsolePeloUsuario;
    }

    public static int receberNumeroComOpcoes(String pergunta, String [] opcoes){
        boolean possoContinuarPedirRespostaDoUsuario = true;
        int valorInformadoPeloUsuario = 0;

        while (possoContinuarPedirRespostaDoUsuario){
            valorInformadoPeloUsuario = receberNumeroNoConsole(pergunta);

            if(opcaoEstaValidaInt(String.valueOf(valorInformadoPeloUsuario), opcoes)){
                return valorInformadoPeloUsuario;
            }else {
                System.out.println("Opção informada não é valida!");
            }

        }
        return valorInformadoPeloUsuario;
    }

    public static double opcaoEstaValidaDouble(String opcaoDoubleInformada, String[] opcoes){
        boolean possoContinuarPedirRespostaUsuario = true;
        double valorInformadoPeloUsuario = 0.0;

        while (possoContinuarPedirRespostaUsuario){
        valorInformadoPeloUsuario = receberDecimalNoConsole(opcaoDoubleInformada);

        if(opcaoValidaDecimal(opcaoDoubleInformada,opcoes)){
            return valorInformadoPeloUsuario;
        }else {
            System.out.println("Opção informada não é valida!");
        }

        }

        return valorInformadoPeloUsuario;
    }

    public static boolean opcaoEstaValida(String opcaoInformada,String[] opcoes){
        for (int i = 0; i < opcoes.length; i++) {
            if(opcaoInformada.equals(opcoes[i])){
                return true;
            }
        }

        return false;
    }

    public static boolean opcaoEstaValidaInt(String opcaoNumericaInformada, String[] opcoes) {
        for (int i = 0; i < opcaoNumericaInformada.length(); i++) {
            if(opcaoNumericaInformada.equals(opcoes[i])){
                return true;
            }

        }

        return false;
    }

    public static boolean opcaoValidaDecimal(String opcaoDecimalInformada, String[] opcoes){
        for (int i = 0; i < opcaoDecimalInformada.length(); i++) {
            if(opcaoDecimalInformada.equals(opcoes[i])){
                return true;
            }
        }

        return false;
    }


}
