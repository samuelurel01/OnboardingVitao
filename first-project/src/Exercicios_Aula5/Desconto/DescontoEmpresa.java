package Exercicios_Aula5.Desconto;

public class DescontoEmpresa extends Desconto {

    public Integer quantidade;

    public DescontoEmpresa(Integer quantidade){
       this.quantidade = quantidade;
    }

    @Override
    public Double aplicarDesconto(Double valorDeEntrada) {
        Double porcentagemExtra = 5.0;
        return valorDeEntrada * (1 - (getPorcentagem() + porcentagemExtra)/100);
    }




    @Override
    public Double calcularDesconto(Double valorDeEntrada) {
        Double porcentagemExtra = 5.0;
        return valorDeEntrada * ((getPorcentagem() + porcentagemExtra)/100);
    }


}
