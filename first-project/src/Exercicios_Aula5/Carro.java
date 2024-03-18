package Exercicios_Aula5;

public class Carro extends AbstractVeiculo{

    public Carro(String placa){
        super("");
        setPlaca(placa);
    }

    private DiaSemana diaQueCarro_e_lavado;

    private String placa;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public void ligar() {
        System.out.println("Ligando carro!");
    }
}
