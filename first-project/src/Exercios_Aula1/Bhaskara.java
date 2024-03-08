package Exercios_Aula1;

public class Bhaskara {
    public static void main(String[] args) {
        System.out.println("========== CALCULO DE BHASKARA ====================");

        int a = 1;
        double[][] resultado = new double[100][];

        while(a <= 100) {
            resultado[a - 1] = calcularBhaskara(1, a, 6);
            a = a + 1;
        }

        for (int i = 0; i < resultado.length; i++) {
            System.out.println("Valor de: " + i + 1 + ": ");
            System.out.printf("  |  Valor de x1: %s, valor de x2: %s |  ", resultado[i][0], resultado[i][1]);
        }


        System.out.println("Fim");
    }
    public static double[] calcularBhaskara(int a, int b, int c){
        double x1 = (-b + Math.sqrt(calcularDelta(a, b, c)))/(2*a);
        double x2 = (-b - Math.sqrt(calcularDelta(a, b, c)))/(2*a);

        double[] result = {x1, x2};

        return result;
    }

    public static int calcularDelta(int a, int b, int c){
        return (b * b) - 4 * a * c;
    }
}
