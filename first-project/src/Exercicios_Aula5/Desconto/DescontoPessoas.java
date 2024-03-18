package Exercicios_Aula5.Desconto;

public class DescontoPessoas extends Desconto{


    @Override
    public Double aplicarDesconto(Double valorDeEntrada) {
            return valorDeEntrada / 2;
    }

    @Override
    public Double calcularDesconto(Double valorDeEntrada) {
        return valorDeEntrada / 2;
    }

}
