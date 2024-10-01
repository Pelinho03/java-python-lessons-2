package com.mycompany.appdistributiva;

import java.util.Scanner;

public class AppDistributiva {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int[] valores = new int[4];
        String[] nomes = {"A", "B", "C", "D"};

        for (int i = 0; i < valores.length; i++) {
            System.out.println("Digita o valor " + nomes[i] + ": ");
            valores[i] = entrada.nextInt();
        }

        System.out.println("\n--- Resultados da Propriedade Distributiva ---\n");

        for (int i = 0; i < valores.length - 1; i++) {
            for (int j = i + 1; j < valores.length; j++) {
                int soma = valores[i] + valores[j];
                int produto = valores[i] * valores[j];
                System.out.printf("Soma de %s e %s: %d + %d = %d\n", nomes[i], nomes[j], valores[i], valores[j], soma);
                System.out.printf("Multiplicacao de %s e %s: %d * %d = %d\n\n", nomes[i], nomes[j], valores[i], valores[j], produto);
            }
        }
    }
}
