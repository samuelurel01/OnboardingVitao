package Exercicios_Aula4.TarefaHeranca;

public class Carnivoro extends Animal {

    private String alimentoCarnivoro;

    private String especieDoAnimal; // Poderia estar na classe pai

    public String getEspecieDoAnimal() {
        return especieDoAnimal;
    }

    public void setEspecieDoAnimal(String especieDoAnimal) {
        this.especieDoAnimal = especieDoAnimal;
    }



    public String getAlimentoCarnivoro() {
        return alimentoCarnivoro;
    }

    public void setAlimentoCarnivoro(String alimentoCarnivoro) {
        this.alimentoCarnivoro = alimentoCarnivoro;
    }

    @Override
    public String devolverCaracteristicas() {
        return "Isso é um animal carnivoro";
    }

    @Override
    public String toString(){
        return "{Nome: " + getNome() + " Descrição: " + getDescricao() + " Alimento: " + alimentoCarnivoro + "}";
    }
}
