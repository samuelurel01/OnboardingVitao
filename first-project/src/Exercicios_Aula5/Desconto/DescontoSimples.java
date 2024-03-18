package Exercicios_Aula5.Desconto;

public class DescontoSimples extends Desconto{

    @Override
    public Double calcularDesconto(Double valorDeEntrada) {
        return valorDeEntrada * (getPorcentagem() / 100);
    }

}
