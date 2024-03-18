package Exercicios_Aula5;

public enum DiaSemana {
    DOMINGO("Domingo"),
    SEGUNDA("Segunda"),
    TERCA("Terça"),
    QUARTA("Quarta"),
    QUINTA("Quinta"),
    SEXTA("Sexta"),
    SABADO("Sábado");

    private String diaSemana;

    DiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    @Override
    public String toString() {
        return diaSemana;
    }
}
