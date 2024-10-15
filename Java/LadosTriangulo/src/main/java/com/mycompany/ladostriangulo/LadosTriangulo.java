package com.mycompany.ladostriangulo;

import java.util.Scanner;

public class LadosTriangulo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int r1, r2, r3;

        System.out.print("Indica o lado 1: ");
        r1 = entrada.nextInt();
        System.out.print("Indica o lado 2: ");
        r2 = entrada.nextInt();
        System.out.print("Indica o lado 3: ");
        r3 = entrada.nextInt();

        // Verifica se os lados podem formar um triângulo
        if (r1 < r2 + r3 && r2 < r1 + r3 && r3 < r1 + r2) {
            System.out.println("\nPODE FORMAR UM TRIANGULO: ");

            // Verifica o tipo de triângulo
            if (r1 == r2 && r2 == r3) {
                System.out.println("EQUILATERO");
            } else if (r1 == r2 || r1 == r3 || r2 == r3) {
                System.out.println("ISOSCELES");
            } else {
                System.out.println("ESCALENO");
            }
        } else {
            System.out.println("\nNAO PODE FORMAR UM TRIANGULO");
        }
    }
}
