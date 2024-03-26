package Exercicios_Aula5.ConceitoInterface;

public enum GeneroEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino");
    private String genero;

    GeneroEnum(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return genero;
    }
}
