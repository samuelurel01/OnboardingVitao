package Exercios_Aula1;

public class Fatorial {

    public static void main(String[] args) {

        System.out.println("Fatorial jeito bão: " + calculaFatorialDeUmNumero(10));
        System.out.println("Fatorial jeito bão + ou - : " + calculaFatorialDeUmNumeroMaisOuMenosBao(10));
    }


    //Jeito + ou - Bom
    public static long calculaFatorialDeUmNumeroMaisOuMenosBao(int numero) {
        long fatorial = numero;
        for (int i = numero; i > 1; i--) {
            fatorial = fatorial * (i - 1);
        }

        return fatorial;
    }

    //Jeito Bom
    public static long calculaFatorialDeUmNumero(int numero) {
        //fatorial5 = 5 * 4 * 3 * 2 * 1
        if(numero < 1) {
            return 1;
        }

        return numero * calculaFatorialDeUmNumero(numero - 1);
    }

}
