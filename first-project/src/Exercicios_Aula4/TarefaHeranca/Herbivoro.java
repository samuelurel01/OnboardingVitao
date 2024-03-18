package Exercicios_Aula4.TarefaHeranca;

public class Herbivoro extends Animal {

    private String alimentoHerbivoro;

    private String especieDoAnimal; // Poderia estar na classe pai

    public String getEspecieDoAnimal() {
        return especieDoAnimal;
    }

    public void setEspecieDoAnimal(String especieDoAnimal) {
        this.especieDoAnimal = especieDoAnimal;
    }



    public String getAlimentoHerbivoro() {
        return alimentoHerbivoro;
    }

    public void setAlimentoHerbivoro(String alimentoHerbivoro) {
        this.alimentoHerbivoro = alimentoHerbivoro;
    }
}
