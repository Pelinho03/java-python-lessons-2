package com.mycompany.javatemperaturas;

import java.util.Scanner;

public class JavaTemperaturas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        double c, f, k, re, ra;

        System.out.println("Insere uma temperatura em C: ");
        c = entrada.nextDouble();

        f = c * 1.8 + 32;
        k = c + 273.15;
        re = c * 0.8;
        ra = c * 1.8 + 32 + 459.67;

        System.out.printf("A temperatura em Fahrenheit = %.2f\n", f);
        System.out.printf("A temperatura em Kelvin = %.2f\n", k);
        System.out.printf("A temperatura em Reamur = %.2f\n", re);
        System.out.printf("A temperatura em Rankine = %.2f\n", ra);

        entrada.close();
    }
}
