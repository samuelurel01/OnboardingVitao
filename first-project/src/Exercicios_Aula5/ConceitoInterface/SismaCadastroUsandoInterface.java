package Exercicios_Aula5.ConceitoInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SismaCadastroUsandoInterface {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("1 - Armazenar na lista");
        System.out.println("2 - Armazenar no vetor");
        System.out.println("3 - Armazenar no map");

        Map<Integer, Cadastro> cadastroMap = new HashMap<>();
        cadastroMap.put(1, new CadastroPessoa());
        cadastroMap.put(2, new CadastroPessoaVetor());
        cadastroMap.put(3, new CadastroPessoaMap());


       int valorEscolhido = receberNumeroNoConsole("Digite qual forma você gostaria de salvar as pessoas no sistema?");
       Cadastro cadastroPessoaNoSistema = cadastroMap.get(valorEscolhido);

       cadastroPessoaNoSistema.criarNovaPessoa("Lucas",19,GeneroEnum.MASCULINO);
       cadastroPessoaNoSistema.listarPessoas();

    }

    public static int receberNumeroNoConsole(String pergunta){
        System.out.println(pergunta);
        int numeroInformado = scanner.nextInt();
        return numeroInformado;

    }

}
