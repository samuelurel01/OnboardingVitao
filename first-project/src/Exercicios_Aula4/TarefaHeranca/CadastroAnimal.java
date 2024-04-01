package Exercicios_Aula4.TarefaHeranca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroAnimal {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        executarProgramaDeCadastroDeAnimais();

    }

    public static void executarProgramaDeCadastroDeAnimais(){
        boolean programaEstaAtivo = true;

        List<Carnivoro> carnivoros = new ArrayList<>();
        List<Herbivoro> herbivoros = new ArrayList<>();

        System.out.println("Seja Bem-Vindo ao programa de cadastro de animais");

        while (programaEstaAtivo){

            quebrarLinhas(1);

            System.out.println("1 - Cadastrar animal Carnivoro");
            System.out.println("2 - Cadastrar animal Herbivoro");
            System.out.println("3 - Exibir lista de animais cadastrados");
            System.out.println("4 - Exibir lista de animais herbivoros");
            System.out.println("5 - Exibir lista de animais carnivoros");
            System.out.println("6 - Encerrar Programa");

            quebrarLinhas(1);

            String escolhaDoUsuario = pegarEscolhaDoUsuarioAPartirDasOpcoes("Escolha uma das opções acima:", new String[]{"1", "2", "3", "4", "5", "6"});

            if(textoIgual(escolhaDoUsuario, "1")){
                Carnivoro novoCarnivoro = cadastrarAnimalCarnivoro();
                carnivoros.add(novoCarnivoro);
            }

            if(textoIgual(escolhaDoUsuario, "2")){
                Herbivoro novoHerbivoro = cadastraranimalHerbivoro();
                herbivoros.add(novoHerbivoro);
            }

            if(textoIgual(escolhaDoUsuario,"3")){
                listarAnimais(carnivoros,herbivoros);
            }

            if(textoIgual(escolhaDoUsuario, "4")){
                listarHerbivoros(herbivoros);
            }

            if (textoIgual(escolhaDoUsuario, "5")){
                listarCarnivoros(carnivoros);
            }


        if (textoIgual(escolhaDoUsuario, "6")){
                System.out.println("Programa encerrado");
                programaEstaAtivo = false;
            }
        }



    }

    private static Carnivoro cadastrarAnimalCarnivoro(){
        Carnivoro novoAnimalCarnivoro = new Carnivoro();

        String nomeDoAnimal = receberUmTextoDoConsole("Informe o nome do animal:");
        novoAnimalCarnivoro.setNome(nomeDoAnimal);

        String descricaoDoAnimal = receberUmTextoDoConsole("Informe a descrição do animal:");
        novoAnimalCarnivoro.setDescricao(descricaoDoAnimal);

        String especieDoAnimal = receberUmTextoDoConsole("Informe a espécie do animal:");
        novoAnimalCarnivoro.setEspecieDoAnimal(especieDoAnimal);

        String alimentoCarnivoro = receberUmTextoDoConsole("Que tipo de alimento o animal consome?:");
        novoAnimalCarnivoro.setAlimentoCarnivoro(alimentoCarnivoro);


        return novoAnimalCarnivoro ;

    }

    private static Herbivoro cadastraranimalHerbivoro(){
        Herbivoro novoanimalHerbivoro = new Herbivoro();

        String nomeDoAnimal = receberUmTextoDoConsole("Informe o nome do animal:");
        novoanimalHerbivoro.setNome(nomeDoAnimal);

        String descricaoDoAnimal = receberUmTextoDoConsole("Informe a descrição do animal:");
        novoanimalHerbivoro.setDescricao(descricaoDoAnimal);

        String especieDoAnimal = receberUmTextoDoConsole("Informe a especie do animal:");
        novoanimalHerbivoro.setEspecieDoAnimal(especieDoAnimal);

        String alimentoHerbivoro = receberUmTextoDoConsole("Que tipo de alimento o animal consome?:");
        novoanimalHerbivoro.setAlimentoHerbivoro(alimentoHerbivoro);

        return novoanimalHerbivoro;

    }

    public static String receberUmTextoDoConsole(String pergunta) {
        System.out.println(pergunta);
        String textoInformado = scanner.nextLine();

        return textoInformado;
    }

    public static void quebrarLinhas(int numeroDeLinhas){
        for (int i = 1; numeroDeLinhas >= i; i++) {
            System.out.println();
        }
    }

    public static boolean textoIgual(String texto1, String texto2){
        return texto1.equals(texto2);
    }

    public static boolean verificarSeOpcaoEValida(String opcao, String[] opcoes ){
        for (int i = 0; i < opcoes.length; i++){
            if (opcao.equals(opcoes[i])){
                return true;

            }
        }
        return false;
    }

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

    public static void listarAnimais(List<Carnivoro> carnivoros, List<Herbivoro> herbivoros){
        quebrarLinhas(2);

        System.out.println("Lista de animais!");

        for(Carnivoro carnivoro : carnivoros){
            System.out.println(carnivoro);
        }

        for(Herbivoro herbivoro : herbivoros){
            System.out.println(herbivoro);
        }


    }

    public static void listarCarnivoros(List<Carnivoro>carnivoros){
        quebrarLinhas(2);

        System.out.println("Lista de animais carnivoros!");

        for(Carnivoro carnivoro : carnivoros){
            System.out.println(carnivoro);
        }
    }

    public static void listarHerbivoros(List<Herbivoro>herbivoros){
        quebrarLinhas(2);

        System.out.println("Lista de animais Herbivoros");

        for(Herbivoro herbivoro : herbivoros){
            System.out.println(herbivoro);
        }
    }

}








