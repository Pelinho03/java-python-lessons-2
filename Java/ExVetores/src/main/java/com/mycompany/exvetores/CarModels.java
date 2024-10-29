package com.mycompany.exvetores;

import java.util.Scanner;

public class CarModels {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int totCarros = 5;
        String carModelMaisEconomico = "";  
        double consumoMaisEconomico = 0.0; 

        String[] carros = new String[totCarros];
        double[] consumos = new double[totCarros];

        // Entrada de dados para os modelos e consumos dos carros
        for (int i = 0; i < totCarros; i++) {
            System.out.print("Digite o modelo do carro " + (i + 1) + ": ");
            carros[i] = entrada.next();
            System.out.print("Agora insira os KMs por 1Lt de combustível: ");
            consumos[i] = entrada.nextDouble();
        }

        // Inicializar o carro mais económico com o primeiro valor de consumo
        consumoMaisEconomico = consumos[0];
        carModelMaisEconomico = carros[0];

        // Determinar o carro mais económico
        for (int i = 1; i < totCarros; i++) {
            if (consumos[i] > consumoMaisEconomico) {
                consumoMaisEconomico = consumos[i];
                carModelMaisEconomico = carros[i];
            }
        }

        // Exibir o carro mais económico
        System.out.println("\nO carro mais económico é o " + carModelMaisEconomico + " com consumo de " + consumoMaisEconomico + " km/L.");

        // Calcular e mostrar o consumo de combustível para cada carro em 100 km
        System.out.println("\nConsumo estimado para 1000 km de distância:");
        for (int i = 0; i < totCarros; i++) {
            double ltCombustivel = 1000 / consumos[i];
            System.out.println("O carro " + carros[i] + " gasta cerca de " + String.format("%.2f", ltCombustivel) + " litros para 1000 km.");
        }

        entrada.close();
    }
}
