import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Alteração da classe main

        //Meu comentário é melhor

        //Tipos de Dados
        boolean ohBoleano = true || false;
        Date data = new Date();
        int numeroQualquer = 10;
        long numeroQualquerGrandao = 1095628948;
        double numeroQualquerComDecimais = 10.50;
        char oChar = '1';
        String textQualquer = "Eai vitão";


        Integer numeroA = 50;
        Integer numeroB = 125;

        System.out.println("========= RESULTADOS ===================");
        System.out.println("Soma de A + B = " + (numeroA + numeroB));
        System.out.println("==================================");
        System.out.println("Multiplacao de A e B = " + (numeroA * numeroB));
        System.out.println("==================================");
        System.out.println("Divisao de A e B = " + (BigDecimal.valueOf(numeroA).divide(BigDecimal.valueOf(numeroB))));
        System.out.println("==================================");



//        //Laço que repita os numeros de 1 á 50
//        for (int vitao = 1; vitao <= 50; vitao++) {
//            System.out.println(vitao);
//        }

        /*

        1 X 1 = 1     2 X 1 = 2     3 X 1 = 3
        1 X 2 = 2     2 X 2 = 4     3 X 2 = 6
        1 X 3 = 3
        1 X 4 = 4



         */

        //tabuadaExemploBom();

        //tabuadaExemploRuim();

        //x = x + y
        //funcaoX = x + y
        //funcaoX = 10 + 5
        //funcaoX = 15

        calculaMediaNotas();

    }

    //this is method
    private static void calculaMediaNotas() {
        System.out.println("Caculando a média dos alunos: ");

        BigDecimal notaA = getNota("Mensal");

        BigDecimal notaB = getNota("Bimestral");

        System.out.println("A Média do Aluno é: " + notaA.add(notaB).divide(BigDecimal.valueOf(2)) );

    }

    private static BigDecimal getNota(String qualNota) {
        Scanner inputDados = new Scanner(System.in);
        System.out.println("Informe a nota "+qualNota+": ");
        BigDecimal nota = inputDados.nextBigDecimal();

        if(!validaNumeroInformado(nota)) {
            return getNota(qualNota);
        }

        return nota;
    }

    private static boolean validaNumeroInformado(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.TEN) > 0 || valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Numero Inválido!");
            return false;
        }

        return true;
    }

    private static void tabuadaExemploBom() {
        //Faça um algoritimo que escreva a tabuada do 1 ao 10
        System.out.println(" ========= TABUADA DO 1 AO 10 ===================");

        //Faz uma repetição de 1 até a 10
        for (int i = 1; i <= 50 ; i++) {
            System.out.println(" ========= TABUADA DO " + i +" ===================");
            // fazer outra repetição de 1 ao 10
            for (int j = 1; j <= 10; j++) {

                System.out.println(String.format(" %s X %s = %s", i, j, i*j));
            }
        }
    }

    private static void tabuadaExemploRuim() {
        int tabuada = 1;
        System.out.println(" ========= TABUADA DO 1 AO 10 ===================");
        while(tabuada <= 10){

            System.out.println(" ========= TABUADA DO " + tabuada +" ===================");

            int multiplicador = 1;

            while (multiplicador <= 10) {
                System.out.println(String.format(" %s X %s = %s", tabuada, multiplicador, tabuada*multiplicador));
                multiplicador = multiplicador + 1;
            }

            tabuada = tabuada + 1;
        }
    }
}