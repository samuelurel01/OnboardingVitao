package Exercicios_Aula3.crudCarro;

import Exercicios_Aula3.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudCarro {

    // Criar classe Carro que deve possuir as seguintes informações:
    // Código Ex: 1,2,3,4,5,6,7,8,9 (Regra: Não pode repetir)
    // Marca, Modelo e Cor

    // C(reate) - Realizar cadastro do carro OK
    // R(ead)   - Listar todos os carros OK
    // U(pdate) - Atualizar ou editar um carro pelo código Ok
    // D(elete) - Deletar um carro pelo código

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
         // Carro novoCarro = new Carro("Chevrolet","Onix", "Vermelho");
        //System.out.println(novoCarro.getCodigo());
        executarProgramaDeCrud();


    }
    static public void executarProgramaDeCrud(){
        boolean programaEstaAtivo = true;

        System.out.println("Bem vindo ao programa de cadastro de veiculos!");

        List<Carro> carros = new ArrayList<>();


        while (programaEstaAtivo) {

            quebrarLinhas(1);

            System.out.println("1 - Cadastrar veiculo");
            System.out.println("2 - Listar todos os carros");
            System.out.println("3 - Atualizar um carro pelo codigo");
            System.out.println("4 - Deletar um carro pelo codigo");
            System.out.println("5 - Encerrar programa");

            quebrarLinhas(1);

            String escolhaDoUsuario = pegarEscolhaDoUsuarioAPartirDasOpcoes("Escolha uma das opções acima:", new String[]{"1", "2", "3", "4", "5"});

            if (textoIgual(escolhaDoUsuario, "1")) {
                Carro novoCarro = cadastrarNovoCarro();

                carros.add(novoCarro);
            }

            if (textoIgual(escolhaDoUsuario, "2")) {
                listarCarros(carros);
            }

            if (textoIgual(escolhaDoUsuario, "3")){
               int codigoDoCarro = receberNumeroNoConsole("Informar codigo do carro:");
                int posicaoCarro = procurarPosicaoCarroNaListaApartirDoCodigo(codigoDoCarro, carros);
                if(posicaoCarro==-1){
                    System.out.println("Nenhum carro foi encontrado para esse codigo.");
                }else{
                    Carro carroComAtualizacoes = cadastrarNovoCarro();
                    carros.get(posicaoCarro).setMarca(carroComAtualizacoes.getMarca());
                    carros.get(posicaoCarro).setModelo(carroComAtualizacoes.getModelo());
                    carros.get(posicaoCarro).setCor(carroComAtualizacoes.getCor());
                }

            }

            //Saber qual carro quer remover Pedindo o codigo - Procurar posição - Ver se a posição é valida - Se for valido remover da lista
            //Para remover - Nome da lista list.remove(passar a posição exemplo 0)


            if(textoIgual(escolhaDoUsuario, "4")){
                int codigoDoCarroQuevaiSerRemovido = receberNumeroNoConsole("Informe o codigo do carro: ");
                int posicaoDoCarroASerRemovido = procurarPosicaoCarroNaListaApartirDoCodigo(codigoDoCarroQuevaiSerRemovido, carros);
                if(posicaoDoCarroASerRemovido== -1){
                    System.out.println("Nenhum carro foi encontrado para esse codigo ");
                }else {
                    carros.remove(posicaoDoCarroASerRemovido);

                }
            }

            if (textoIgual(escolhaDoUsuario, "5")){
                System.out.println("Programa encerrado!");
                programaEstaAtivo = false;
            }

        }

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

    public static boolean textoIgual(String texto1, String texto2){
        return texto1.equals(texto2);
    }


    public static String receberUmTextoDoConsole(String pergunta){
        System.out.println(pergunta);
        String textoInformado = scanner.nextLine();

        return textoInformado;
    }

    public static void quebrarLinhas(int numeroDeLinhas){
        for (int i = 1; i <= numeroDeLinhas; i++){
            System.out.println();

        }
    }

    private static Carro cadastrarNovoCarro(){


        String marcaDoCarro = receberUmTextoDoConsole("informe a marca do carro: ");


        String modeloDoCarro = receberUmTextoDoConsole("Informe o modelo do carro: ");


        String corDoCarro = receberUmTextoDoConsole("Informe a cor do carro: ");


        Carro novoCarro= new Carro(marcaDoCarro, modeloDoCarro, corDoCarro);

        return novoCarro;
    }

    public static void listarCarros(List<Carro>carros){
        quebrarLinhas(2);
        System.out.println("lista de carros!");

        for(Carro carro : carros){
            System.out.println(carro);
        }
    }



    public static int receberNumeroNoConsole(String pergunta){
        System.out.println(pergunta);
       int numeroInformado = scanner.nextInt();
       return numeroInformado;

    }

    public static int procurarPosicaoCarroNaListaApartirDoCodigo(int codigo, List<Carro> carros){
        for (int i = 0; i < carros.size(); i++) {
           if (carros.get(i).getCodigo() == codigo){
               return i;
           }

        }
        return -1;
    }

}
