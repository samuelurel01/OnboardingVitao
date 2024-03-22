package Exercicios_Aula2;

public class OrdenarLista {

    // Existe uma lista numerica com valores desordenados e voce deve ordenar eles de modo crescente

    static Integer[] numeros = new Integer[]{10,3,5,1,7,2,2,5,5,7,1,8,33,5,23,77,3,4,7,8,9};

    public static void main(String[] args) {
        listar();
        System.out.println();

        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if(numeros[i] > numeros[j]){ // 10 > 3 = Verdade
                    Integer numeroPosicaoAtual = numeros[i]; // numeroPosicaoAtual = 10
                    numeros[i] = numeros[j]; // numeros[0] = 3
                    numeros[j] = numeroPosicaoAtual; // numeros[1] = 10
                }
            }
        }

        listar();

    }

    public static void listar(){
        for (Integer num: numeros) {
            System.out.print(num + " ");
        }
    }

}
