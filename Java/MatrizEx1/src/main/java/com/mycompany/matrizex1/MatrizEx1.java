package com.mycompany.matrizex1;

import java.util.Scanner;

public class MatrizEx1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int nLinhas = 5, nColunas = 5;
        int matriz[][] = new int[nLinhas][nColunas];

        // Preenchimento da matriz
        for (int i = 0; i < nLinhas; i++) {
            System.out.println("Linha " + (i + 1));
            for (int j = 0; j < nColunas; j++) {
                System.out.print("Digite o valor da linha " + (i + 1) + " coluna " + (j + 1) + ": ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        // Exibição da matriz
        System.out.println("\nMatriz inserida:");
        for (int i = 0; i < nLinhas; i++) {
            for (int j = 0; j < nColunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
