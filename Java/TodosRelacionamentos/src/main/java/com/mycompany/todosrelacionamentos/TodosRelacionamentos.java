package com.mycompany.todosrelacionamentos;

import java.util.Scanner;

public class TodosRelacionamentos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int maior = 0, menor = 0;
        String resp;

        do {
            System.out.println("Digita o 1 valor: ");
            int valor1 = entrada.nextInt();
            System.out.println("Digita o 2 valor: ");
            int valor2 = entrada.nextInt();

            if (valor1 != valor2) {
                if (valor1 < valor2) {
                    maior = valor2;
                    menor = valor1;
                } else {
                    maior = valor1;
                    menor = valor2;
                }

                System.out.println("Os valores nao sao iguais.");
                System.out.println("Maior = " + maior
                        + "\nMenor = " + menor);
                System.out.println("O " + maior + " e > que " + menor);
            } else {
                System.out.println("Os valores sao iguais: " + valor1);
            }

            System.out.println("Queres continuar? [S/N]");
            resp = entrada.next();

        } while (!resp.equalsIgnoreCase("n"));
    }
}
