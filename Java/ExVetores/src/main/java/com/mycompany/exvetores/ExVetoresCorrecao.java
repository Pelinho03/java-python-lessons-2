package com.mycompany.exvetores;

import java.util.Scanner;

public class ExVetoresCorrecao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] valoresA = new int[20];  // VETOR A
        int[] valoresB = new int[20];  // VETOR B
        int maior, menor;

        // Entrada de valores para o VETOR A
        for (int i = 0; i < 20; i++) {
            System.out.print("Insere o valor " + (i + 1) + " do vetor A: ");
            valoresA[i] = entrada.nextInt();
        }

        // Inicializar maior e menor com o primeiro valor do vetor A
        maior = valoresA[0];
        menor = valoresB[0];

        // Preencher o VETOR B com os valores invertidos do VETOR A
        for (int i = 0; i < 20; i++) {
            valoresB[i] = valoresA[19 - i];  // Inverte os valores
            // Verificar o maior valor
            if (valoresA[i] > maior) {
                maior = valoresA[i];
            }
        }

        // Saída dos resultados para o VETOR A
        System.out.println("\nVETOR A");
        System.out.println("OS VALORES INSERIDOS FORAM:");
        for (int i = 0; i < 20; i++) {
            System.out.print(" | " + valoresA[i] + " | ");
        }

        // Saída dos resultados para o VETOR B
        System.out.println("\n\nVETOR B");
        System.out.println("OS VALORES INVERTIDOS FICAM:");
        for (int i = 0; i < 20; i++) {
            System.out.print(" | " + valoresB[i] + " | ");
            // Verificar o menor valor
            if (valoresB[i] < menor) {
                menor = valoresB[i];
            }
        }

        // Saída dos resultados
        System.out.println("\n\nO maior valor do VETOR A foi: " + maior);
        System.out.println("O menor valor do VETOR B foi: " + menor);
    }
}
