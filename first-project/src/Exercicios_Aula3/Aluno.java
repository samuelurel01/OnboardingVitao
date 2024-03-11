package Exercicios_Aula3;

import java.util.Date;

public class Aluno {

    private String nome;

    private Date dataNascimento;

    private String turma;

    private double nota1;
    private double nota2;
    private double nota3;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
            char[] arrayDoNome = nome.toCharArray(); // lucas -> new char[]{'l','u','c','a','s'}
            String primeraLetraMaiuscula = (arrayDoNome[0] + "").toUpperCase();
            String restoDoNome = "";

            for (int i = 1; i < nome.length(); i++) {
                restoDoNome += arrayDoNome[i];
            }

            restoDoNome = restoDoNome.toLowerCase();


            this.nome = primeraLetraMaiuscula + restoDoNome;

        }
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", turma='" + turma + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }

    public double calcularMedia(){
       return (getNota1() + getNota2() + getNota3())/3;
    }
}
