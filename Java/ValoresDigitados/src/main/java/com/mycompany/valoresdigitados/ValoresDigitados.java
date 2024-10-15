package com.mycompany.valoresdigitados;

import java.util.Scanner;

public class ValoresDigitados {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int a, b, c;
        int maior, menor;

        do {
            System.out.print("Digita o valor A (maior que 0): ");
            a = entrada.nextInt();
            System.out.print("Digita o valor B (maior que 0): ");
            b = entrada.nextInt();
            System.out.print("Digita o valor C (maior que 0): ");
            c = entrada.nextInt();

            // Verifica se algum valor é negativo ou zero
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("Valores invalidos! Digita apenas valores maiores que 0.\n");
            }
        } while (a <= 0 || b <= 0 || c <= 0);

        // Inicializa o maior e menor com o valor de A
        maior = a;
        menor = a;

        // Verifica o maior valor
        if (b > maior) {
            maior = b;
        }
        if (c > maior) {
            maior = c;
        }

        // Verifica o menor valor
        if (b < menor) {
            menor = b;
        }
        if (c < menor) {
            menor = c;
        }

        System.out.println("Maior = " + maior);
        System.out.println("Menor = " + menor);
        // Exibe o maior e o menor valor
        int conta1 = menor * maior;
        int conta2 = maior / menor;
        System.out.println("\nMenor * maior =  " + conta1);
        System.out.println("Maior / menor = " + conta2);
    }
}
