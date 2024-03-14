package Exercicios_Aula3.crudCarro;

public class Carro {

    private static int ultimoCodigoCriado = 0;

    // Criar atributos do carro.

    private String marca;

    private String modelo;

    private String cor;

    private int codigo;


    //Criação dos metodos acessores/ Get- Retornar o valor do atributo, Set- Define o valor do atributo.
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getCor(){
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public static int getUltimoCodigoCriado(){
        return ultimoCodigoCriado;
    }

    public Carro(String marca, String modelo, String cor){
        setMarca(marca);
        setModelo(modelo);
        setCor(cor);
        setCodigo(++ultimoCodigoCriado);


    }

    public Carro() {

    }

    @Override
    public String toString(){
        return "{Codigo: " + codigo + " Marca: " + marca + " Modelo:" + modelo + " Cor:" + cor +" }";
    }



}


