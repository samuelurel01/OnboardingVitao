package Exercicios_Aula3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcularMediaPonderada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        executarProgramaDeCalculoDeMedia();
    }
    public static void executarProgramaDeCalculoDeMedia(){
        boolean programaEstaAtivo = true;

        //Criado uma lista de alunos "Baseado na claase aluno definida nesta aula"
        List<Aluno> alunos = new ArrayList<>();

        System.out.println("Seja Bem-Vindo ao programa de calculo de média!");

        while (programaEstaAtivo){

            quebrarLinhas(1);

            //Escrever as opções no console que o usuario ira escolher
            System.out.println("1 - Cadastrar aluno e suas respectivas notas");
            System.out.println("2 - Exibir média da turma");
            System.out.println("3 - Exibir média de um aluno");
            System.out.println("4 - Listar Alunos Cadastrados");
            System.out.println("5 - Encerrar Programa");

            quebrarLinhas(1);
            //Armazenar a opção escolhida pelo usuario
            String escolhaDoUsuario = pegarEscolhaDoUsuarioAPartirDasOpcoes("Escolha uma das opções a cima:", new String[]{"1","2","3","4","5"});

            // 1 - Cadastrar aluno e suas respectivas notas
            if(textoIgual(escolhaDoUsuario, "1")) {
                //Cria um alunoNovo com suas notas
                Aluno alunoNovo = cadastrarAlunoESuasNotas();

                //o metódo add, adiciona um elemento a sua lista...
                //Neste caso estamos adicionando o alunoNovo criado a lista alunos
                alunos.add(alunoNovo);


                System.out.println("Aluno " + alunoNovo.getNome() + " cadastrado com sucesso!");
            }

            // 2 - Exibir media da turma
            if(textoIgual(escolhaDoUsuario, "2")) {
                exibeMediaDaTurma(alunos, false);
            }

            // 3 - Exibir media de um aluno
            if(textoIgual(escolhaDoUsuario, "3")) {
                exibeMediaDoAluno(alunos);
            }


            if(textoIgual(escolhaDoUsuario,"4")){

                quebrarLinhas(2);
                System.out.println("Lista de Alunos!");
                quebrarLinhas(1);

                for (Aluno aluno : alunos) {
                    System.out.println(aluno);
                }

                quebrarLinhas(2);
            }


            // 5 - Caso escolher sair, encerar o programa
            if(textoIgual(escolhaDoUsuario,"5")){

                System.out.println("Programa Encerrado!");
                programaEstaAtivo = false;
            }


            quebrarLinhas(2);
        }

    }

    private static void exibeMediaDoAluno(List<Aluno> alunos) {

        System.out.println("Lista de Alunos!");

        List<Aluno> alunosEscolhidos = new ArrayList<>();

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        String alunoEscolhido = receberUmTextoDoConsole("Digite o nome do Aluno Desejado: ");

        for (Aluno aluno : alunos) {
            if (aluno.getNome().toUpperCase().equals(alunoEscolhido.toUpperCase())) {
                alunosEscolhidos.add(aluno);
            }
        }


        exibeMediaDaTurma(alunosEscolhidos, true);
    }

    private static void exibeMediaDaTurma(List<Aluno> alunos, boolean mediaAluno) {
        if(!alunos.isEmpty()) {
            System.out.println("Você quer saber a média de qual periodo: ");
            System.out.println("1 - P1: ");
            System.out.println("2 - P2: ");
            System.out.println("3 - P3: ");
            System.out.println("4 - Todas: ");
            String opcao = receberUmTextoDoConsole("Informe a opção");


            double somaNotas = 0.0;

            if(textoIgual("1", opcao)) {
                for (Aluno aluno : alunos) {
                    somaNotas = somaNotas + aluno.getNota1();
                }
            }

            if(textoIgual("2", opcao)) {
                for (Aluno aluno : alunos) {
                    somaNotas = somaNotas + aluno.getNota2();
                }
            }

            if(textoIgual("3", opcao)) {
                for (Aluno aluno : alunos) {
                    somaNotas = somaNotas + aluno.getNota3();
                }
            }

            if(textoIgual("4", opcao)) {
                for (Aluno aluno : alunos) {
                    somaNotas = somaNotas + aluno.getNota1() + aluno.getNota2() + aluno.getNota3();
                }
            }


            double media = somaNotas/alunos.size();

            System.out.println("A Média da(o) " + (mediaAluno ? "Aluno" : "Turma ") + " é: " + media);

        } else {
            System.out.println("Nenhum Aluno Encontrado!");
        }
    }

    private static Aluno cadastrarAlunoESuasNotas() {
        Aluno novoAluno = new Aluno();

        String nomeDoAluno = receberUmTextoDoConsole("Informe o Nome do Aluno: ");
        novoAluno.setNome(nomeDoAluno);
        quebrarLinhas(1);

        String turma = receberUmTextoDoConsole("Informe a Turma do Aluno: ");
        novoAluno.setTurma(turma);
        quebrarLinhas(1);


        double p1 = receberUmNumeroDoConsole("Informe a nota da p1:");
        double p2 = receberUmNumeroDoConsole("Informe a nota da p2:");
        double p3 = receberUmNumeroDoConsole("Informe a nota da p3:");

        novoAluno.setNota1(p1);
        novoAluno.setNota2(p2);
        novoAluno.setNota3(p3);

        return novoAluno;
    }

    public static boolean textoIgual(String texto1, String texto2){
        return texto1.equals(texto2);
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

