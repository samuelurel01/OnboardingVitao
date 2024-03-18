package Exercicios_Aula5;

public abstract class AbstractVeiculo {

    private String modelo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public AbstractVeiculo(String modelo){
        setModelo(modelo);
    }

    @Override
    public String toString() {
        return this.modelo;
    }

    public void ligar(){
        System.out.println("Veículo ligado!");
    }


}
