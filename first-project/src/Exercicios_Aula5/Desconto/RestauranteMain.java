package Exercicios_Aula5.Desconto;

import java.util.ArrayList;
import java.util.List;

public class RestauranteMain {

    public static void main(String[] args) {

        // Animal - Carnivoro - Lobo
        // Animal novoAnimal = new Lobo();


        Desconto descontoPessoas = new DescontoPessoas();
        Desconto descontoSimples = new DescontoSimples();
        Desconto descontoEmpresa = new DescontoEmpresa(10);

        List<Desconto> meusDescontos = new ArrayList<>();
        meusDescontos.add(descontoPessoas);
        meusDescontos.add(descontoSimples);
        meusDescontos.add(descontoEmpresa);

        Double valorDoAlmoco = 600.0;
        Double totalDesconto = 0.0;

        for(Desconto desconto: meusDescontos){
            desconto.setPorcentagem(2.0);
            valorDoAlmoco = desconto.aplicarDesconto(valorDoAlmoco);
            totalDesconto += desconto.calcularDesconto(valorDoAlmoco);
        }

        System.out.println(valorDoAlmoco);
        System.out.println(totalDesconto);



    }
}
