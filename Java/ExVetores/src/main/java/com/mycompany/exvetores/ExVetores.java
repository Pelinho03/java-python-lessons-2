package com.mycompany.exvetores;

import java.util.Scanner;

public class ExVetores {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] valores = new int[20];  // Mudado para 5, já que só estamos a usar 5 valores
        int maior, menor;

        // Entrada de valores
        for (int i = 0; i < 20; i++) {
            System.out.print("Insere o valor " + (i + 1) + " do vetor: ");
            valores[i] = entrada.nextInt();
        }

        // Inicializar maior e menor com o primeiro valor do vetor
        maior = valores[0];
        menor = valores[0];

        System.out.println("\nVETOR A");
        System.out.println("OS VALORES INSERIDOS FORAM:");
        for (int i = 0; i < 20; i++) {
            System.out.print(" | " + valores[i] + " | ");
            // Verificar o maior valor
            if (valores[i] > maior) {
                maior = valores[i];
            }
        }

        System.out.println("\n\nVETOR B");
        System.out.println("OS VALORES INVERTIDOS FICAM:");
        for (int i = 19; i >= 0; i--) {
            System.out.print(" | " + valores[i] + " | ");
            // Verificar o menor valor
            if (valores[i] < menor) {
                menor = valores[i];
            }
        }

        // Saída dos resultados
        System.out.println("\n\nO maior valor do VETOR A foi: " + maior);
        System.out.println("O menor valor do VETOR B foi: " + menor);
    }
}
