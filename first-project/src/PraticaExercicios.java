public class PraticaExercicios {

    public static void main(String[] args) {

    }

    // 1 - Faça uma função que recebe dois valores decimais e tambem uma operação aritimetica
    // ("+","-","/","*") e apartir disso você deve calcular e devolver o resultado

    public static double calculoAritmetico(double valor1, double valor2, char operacaoMatetmatica){
        double resultado = 0;

        if(operacaoMatetmatica == ('+')){
            resultado = valor1 + valor2;
        }else if (operacaoMatetmatica == ('-')){
            resultado = valor1 - valor2;
        } else if (operacaoMatetmatica == ('*')) {
            resultado = valor1 * valor2;
        } else if (operacaoMatetmatica == ('/')) {
            if (valor2 != 0){
                resultado = valor1 / valor2;
            }else {
                System.out.println("Erro, divisão por zero!");
            }
        }else {
            System.out.println("Operação não é valida!");
        }

            return resultado;
    }

    // 2 - Faça uma função que escreva a tabuada de um numero informado pelo usuario no terminal
    public static void escreverTabuada(int numero){

        System.out.println("Tabuada de " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }



    // 3 - Faça uma função que diz se um numero é impar ou par
    // 4 - Faça uma função que irá fazer uma pergunta ao usuario, e ele deve responder no terminal
    // mas se dentro da resposta existir qualquer numero, o usuario deve ser notificado que escreveu um numero
    // e sua resposta está invalida e o processo deve ser repetido até que ele escreva um texto sem numeros
    // E no final deve ser devolvido o texto
    // Dica: Criar duas funções uma que faça a validação do texto e outra que faça a repetição do processo


}
