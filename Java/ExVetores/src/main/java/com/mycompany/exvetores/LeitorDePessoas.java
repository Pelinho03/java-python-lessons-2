package com.mycompany.exvetores;

import java.util.Scanner;

public class LeitorDePessoas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int totalPessoas = 10, totalIdades = 0;
        double media;
        String[] nomes = new String[totalPessoas];
        int[] idades = new int[totalPessoas];

        for (int i = 0; i < totalPessoas; i++) {
            System.out.print("Digita o nome da pessoa " + (i + 1) + " do vetor: ");
            nomes[i] = entrada.nextLine();
            System.out.print("Insere a idade da pessoa " + (i + 1) + " do vetor: ");
            idades[i] = entrada.nextInt();

            totalIdades += idades[i];

            entrada.nextLine();
        }

        System.out.println("\nLISTA DE PESSOAS:");
        for (int i = 0; i < totalPessoas; i++) {
            System.out.println("Nome: " + nomes[i] + ", Idade: " + idades[i]);
        }

        media = totalIdades / totalPessoas;
        System.out.println("\nA media de idades foi de: " + media + " anos.\n");

        for (int i = 0; i < totalPessoas; i++) {
            if (idades[i] > media) {
                System.out.println(nomes[i] + " tem idade acima da media!");
            }
        }

    }
}
