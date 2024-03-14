package Exercicios_Aula3;

import java.util.ArrayList;
import java.util.List;

public class ForClasse {

    public static void main(String[] args) {

        List<Integer> listaDeNumeros = new ArrayList<>();
        listaDeNumeros.add(10);
        listaDeNumeros.add(20);
        listaDeNumeros.add(30);
        listaDeNumeros.add(100);
        listaDeNumeros.add(203);
        listaDeNumeros.add(305);

        listaDeNumeros.remove(0);

        // Para cada elemento dessa lista ocorrerá uma repetição
        for(Integer numero : listaDeNumeros){
            System.out.println(numero);
        }

        Bicicleta novaBicicleta = new Bicicleta();
        novaBicicleta.cor = "Azul";
        novaBicicleta.marca = "Caloi";
        novaBicicleta.preco = 2000.0;

        Bicicleta bicicletaDoVictor = new Bicicleta();
        bicicletaDoVictor.cor = "Red";
        bicicletaDoVictor.marca = "Chevrolet";
        bicicletaDoVictor.preco = 10000.0;

        System.out.println(novaBicicleta);
        System.out.println(bicicletaDoVictor);

    }




}

class Bicicleta {
    public String marca;
    public String cor;
    public double preco;

    @Override
    public String toString() {
        return "{Bicleta | Marca: " + marca + " - Cor: " + cor + " - Preço: R$ "+ preco + " }";
    }
}