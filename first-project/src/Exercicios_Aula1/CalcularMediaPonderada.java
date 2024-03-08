package Exercicios_Aula1;

import java.util.Scanner;

public class CalcularMediaPonderada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       executarProgramaDeCalculoDeMedia();
    }
     public static void executarProgramaDeCalculoDeMedia(){
        boolean programaEstaAtivo = true;

        while (programaEstaAtivo){
            System.out.println("Seja Bem-Vindo ao programa de calculo de média!");
            quebrarLinhas(1);

            //Escrever as opções no console que o usuario ira escolher
            System.out.println("1 - Cadastrar aluno e suas respectivas notas");
            System.out.println("2 - Exibir média da turma");
            System.out.println("3 - Exibir média de um aluno");
            System.out.println("4 - Encerrar Programa");

            quebrarLinhas(1);
            //Armazenar a opção escolhida pelo usuario
           String escolhaDoUsuario = pegarEscolhaDoUsuarioAPartirDasOpcoes("Escolha uma das opções a cima:", new String[]{"1","2","3","4"});

            // 4 - Caso escolher sair, encerar o programa
            if(textoIgual(escolhaDoUsuario,"4")){
                programaEstaAtivo = false;
            }

            // 1 - Cadastrar aluno e suas respectivas notas
            // 2 - Exibir media da turma
            // 3 - Exibir media de um aluno


        }

     }

     public static boolean textoIgual(String texto1, String texto2){
        return texto1.compareTo(texto2) == 0;
     }

     public static void quebrarLinhas(int numeroDeLinhas){
        for (int i = 1; numeroDeLinhas >= i; i++) {
            System.out.println();
        }
     }

     // Função que faz o controle de entrada das opções possíveis
    public static String pegarEscolhaDoUsuarioAPartirDasOpcoes(String pergunta,String[] opcoes){
        boolean continuarPedirEscolhaDoUsuario = true;
        String escolhaDoUsuario;

        do{
            escolhaDoUsuario = receberUmTextoDoConsole(pergunta);

            if(verificarSeOpcaoEValida(escolhaDoUsuario,opcoes)){
                continuarPedirEscolhaDoUsuario = false;
            }else{
                System.out.println("Opção invalida!");
            }

        }while(continuarPedirEscolhaDoUsuario);

        return escolhaDoUsuario;
    }

    public static boolean verificarSeOpcaoEValida(String opcao,String[] opcoes){
        for (int i = 0; i < opcoes.length; i++) {
             if(opcao.compareTo(opcoes[i]) == 0){
                 return true;
             }
        }

        return false;
    }

    // Função de entrada de dados através do scanner
    public static String receberUmTextoDoConsole(String pergunta){
        System.out.println(pergunta);
        String textoInformado = scanner.nextLine();

        return textoInformado;
    }

    public static double receberUmNumeroDoConsole(String pergunta){
        System.out.println(pergunta);
        double numeroInformado = scanner.nextDouble();
        return numeroInformado;
    }


}

