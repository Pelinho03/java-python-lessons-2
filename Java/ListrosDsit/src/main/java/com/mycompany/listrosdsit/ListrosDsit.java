package com.mycompany.listrosdsit;

import java.util.Scanner;

public class ListrosDsit {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        double vel_media = 0, tempo = 0;
        int consumos = 0;

        System.out.println("Digita o tempo gasto em horas: ");
        tempo = entrada.nextDouble();

        System.out.println("Digita  a velocidade media: ");
        vel_media = entrada.nextDouble();

        System.out.println("Digita o consumo medio do teu carro: ");
        consumos = entrada.nextInt();

        double distancia = tempo * vel_media;
        double total_litros = distancia / consumos;

        System.out.printf("Velocidade media:  %.2f\n", vel_media, " Km/h");
        System.out.printf("Tempo:  %.2f\n", tempo, " Hora(s)");
        System.out.printf("Gastaste cerca de:  %.2f\n", total_litros, " Litro(s)");
        System.out.printf("Distancia percorrida:  %.2f\n", distancia, " Quilómetro(s)");

    }
}
