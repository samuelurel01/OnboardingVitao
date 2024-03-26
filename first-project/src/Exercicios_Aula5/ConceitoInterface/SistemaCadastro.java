package Exercicios_Aula5.ConceitoInterface;

import Exercicios_Aula4.Screen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaCadastro {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("1 - Armazenar na lista");
        System.out.println("2 - Armazenar no vetor");
        System.out.println("3 - Armazenar no map");

//        int valorEscolhido = receberNumeroNoConsole("Digite qual forma você gostaria de salvar as pessoas no sistema?");
//
//        if(valorEscolhido == 3){
//            CadastroPessoaMap cadastroPessoaMap = new CadastroPessoaMap();
//            cadastroPessoaMap.criarNovoSerHumano("Lucas",19,GeneroEnum.MASCULINO);
//        }
//
//        if(valorEscolhido == 2){
//            CadastroPessoaVetor cadastroPessoaVetor = new CadastroPessoaVetor();
//            cadastroPessoaVetor.criarNovaPessoaPremiada("Lucas",19,GeneroEnum.MASCULINO);
//        }
//
//        if(valorEscolhido == 1){
//            CadastroPessoa cadastroPessoa = new CadastroPessoa();
//            cadastroPessoa.criarNovaPessoa("Lucas",19,GeneroEnum.MASCULINO);
//        }

    }

    public static int receberNumeroNoConsole(String pergunta){
        System.out.println(pergunta);
        int numeroInformado = scanner.nextInt();
        return numeroInformado;

    }

    public static void manipulandoMap(){

        // Chave     Valor
        Map<String, Double> minhasFinancas = new HashMap<>();

        //minhasFinancas.put("Comida",1000.0);  //  { key: 'Comida' - Value: 1000.0 } Ele não achou ninguem com a chave comida então criou um novo elemento
        //minhasFinancas.put("Futebol", 100.0); //  { key: 'Futebol' - Value: 1000.0 } Mesma coisa do de cima mas para a chave Futebol
        //minhasFinancas.put("Comida",500.0);   //  { key: 'Comida' - Value: 500.0 } Substituiu o valor de Comida pois ja existia um elemento com essa chave

        minhasFinancas.put("Comida",1000.0);
        minhasFinancas.put("Futebol", 100.0);
        Double valorAntigo = minhasFinancas.get("Comida");
        minhasFinancas.put("Comida", valorAntigo + 500.0);


        for(Map.Entry<String,Double> entry : minhasFinancas.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());

        }




    }

}
