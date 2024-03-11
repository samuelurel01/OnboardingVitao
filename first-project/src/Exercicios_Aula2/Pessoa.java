package Exercicios_Aula2;

import java.util.Date;

public class Pessoa {

    //Atributos da classe pessoa, (propriedades, caracteristicas, etc)
    private String nome;

    private Date dataNascimento;

    private double altura;

    private String corOlhos;


    public Pessoa() {

    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getCorOlhos() {
        return corOlhos;
    }

    public void setCorOlhos(String corOlhos) {
        this.corOlhos = corOlhos;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", altura=" + altura +
                ", corOlhos='" + corOlhos + '\'' +
                '}';
    }
}
