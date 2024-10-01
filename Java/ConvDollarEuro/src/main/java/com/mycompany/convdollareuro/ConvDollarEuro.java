package com.mycompany.convdollareuro;

import java.util.Scanner;

public class ConvDollarEuro {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        double cot_euro, dollar, resultado;

        System.out.println("Digita a cotacao do euro em relacao ao dolar:");
        cot_euro = entrada.nextDouble();
        System.out.println("Digita um valor em dolares:");
        dollar = entrada.nextDouble();

        resultado = dollar * cot_euro;

        System.out.println("Valor em euros: " + resultado);
    }
}
