package com.mycompany.matrizex1;

import java.util.Scanner;

public class MatrizEx2 {

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

        // Pedir ao utilizador o número da coluna a exibir
        System.out.print("\nDigite o numero da coluna que desejas exibir (1 a " + nColunas + "): ");
        int coluna = entrada.nextInt();

        // Verificação se a coluna está dentro dos limites
        if (coluna < 1 || coluna > nColunas) {
            System.out.println("Coluna invalida! Escolhe um valor entre 1 e " + nColunas);
        } else {
            System.out.println("Valores da coluna " + coluna + ":");
            for (int i = 0; i < nLinhas; i++) {
                System.out.println(matriz[i][coluna - 1]);
            }
        }
    }
}
