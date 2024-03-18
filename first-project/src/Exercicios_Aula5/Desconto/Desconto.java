package Exercicios_Aula5.Desconto;

public abstract class Desconto {

    private Double valor;

    private Double porcentagem;

    public Double aplicarDesconto(Double valorDeEntrada){
        return valorDeEntrada * (1 - porcentagem/100);
    }

    public abstract Double calcularDesconto(Double valorDeEntrada);

    public Double getValor() {
        return valor;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }
}
