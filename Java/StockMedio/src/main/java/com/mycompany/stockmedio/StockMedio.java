package com.mycompany.stockmedio;

import java.util.Scanner;

public class StockMedio {

    public static void main(String[] args) {

        int quantidade_min = 0, quantidade_max = 00;
        //float stock_medio = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digita a quantidade minima de stock: ");
        quantidade_min = entrada.nextInt();
        System.out.println("Digita a quantidade maxima de stock: ");
        quantidade_max = entrada.nextInt();

        float stock_medio = (quantidade_min + quantidade_max) / 2;
        System.out.println("A quantidade minima e " + quantidade_min + ", a quantidade maxima e " + quantidade_max + " e a media e = " + stock_medio);
    }
}
