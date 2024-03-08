package Exercios_Aula1;

import java.util.Arrays;

public class NumeroPrimo {

    public static void main(String[] args) {
        //é todoo numero que é divisivel somente por ele e por 1

        System.out.println(ehPrimo(3));
        System.out.println(ehPrimo(6));
        System.out.println(ehPrimo(10));
        System.out.println(ehPrimo(11));


        System.out.println(Arrays.toString(todosNumerosPrimosAteNumeroInformado(10000)));
        System.out.println(getQtdPrimos(10000));

    }


    public static int[] todosNumerosPrimosAteNumeroInformado(int numero) {
        int qtdPrimos = getQtdPrimos(numero);

        int[] numerosPrimos = new int[qtdPrimos];

        int index = 0;
        for (int i = 1; i <= numero; i++) {
            if(ehPrimo(i)) {
                numerosPrimos[index] = i;
                index++;
            }
        }

        return numerosPrimos;
    }

    private static int getQtdPrimos(int numero) {
        int qtdPrimos = 0;
        for (int i = 1; i <= numero; i++) {
            if(ehPrimo(i)) {
                qtdPrimos++;
            }
        }
        return qtdPrimos;
    }


    public static boolean ehPrimo(int numero) {
        if(numero < 3) {
            return false;
        }

        for (int i = numero; i > 2; i--) {
            if ((numero % (i - 1)) == 0) {
                return false;
            }
        }

        return true;
    }
}
