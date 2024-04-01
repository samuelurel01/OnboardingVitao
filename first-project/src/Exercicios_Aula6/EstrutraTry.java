package Exercicios_Aula6;

import Exercicios_Aula5.ConceitoInterface.Pessoa;

public class EstrutraTry {

    public static void main(String[] args) {

        // Na programação existem situações que são possíveis de erros

        try {
            Pessoa pessoa = new Pessoa();
            pessoa.getIdade().equals(18);
        }catch (Exception e){
            System.out.println("Olha amigo, você passou um objeto null para comparação!");
        }finally {
            System.out.println("Final da execução!");
        }

    }



}
