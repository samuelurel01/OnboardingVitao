package Funcoes;

public class FuncoesMain {
    /* Na programação precisamos resolver diversos problemas, sendo comum
       precisar resolver uma mesma situação diversas vezes.

       Exemplo: Imprimir um texto com as letras MAISCULAS

       System.out.println("texto a ser convertido para maiusculo".toUpperCase());

       Para resolver

       1 - Usamos a função println() que irá imprimir o texto passado
       2 - E utilizamos a função toUpperCase() para deixar em maisculo o texto

        Em um primeiro momento vemos que o problema pode ser resolvido dessa forma

        Imaginemos que vamos precisar utilizar essa mesma lógica em diversos lugares
        Precisariamos repetir esse mesmo trecho todas as vezes, para escrever nosso texto
        em maiusculo.

        Mas será que não existe uma maneira mais facil de resolver esse problema sem repetir
        esse código toda vez?

    */


    public static void main(String[] args) {
        String valorTexto = transformarTextoEmMaiusculo("asdasdas");

        imprimeUmTextoComLetrasMaiusculas("Seja bem-vindo");

        imprimeUmTextoComLetrasMaiusculas("lucas");


    }

    // Função que recebe parametro
    public static void imprimeUmTextoComLetrasMaiusculas(String texto){
        System.out.println(transformarTextoEmMaiusculo(texto));
    }

    // Função que recebe parametro e retorna valor
    public static String transformarTextoEmMaiusculo(String texto){
        String textoEmMaiusculo = texto.toUpperCase();
        return textoEmMaiusculo;
    }

}
