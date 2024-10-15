package com.mycompany.verificarcodigo;

import java.util.Scanner;

public class VerificarCodigo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int codigo;
        System.out.println("-------------------");
        System.out.println("  NUMEROS  ");
        System.out.println("-------------------");
        do {
            System.out.print("Digita um numero, 1, 2 ou 3: ");
            codigo = entrada.nextInt();
            if (codigo == 1) {
                System.out.println("\nUM");
            } else if (codigo == 2) {
                System.out.println("\nDOIS");
            } else if (codigo == 3) {
                System.out.println("\nTRES");
            } else {
                System.out.println("\nCodigo invalido!");
            }
        } while (codigo > 3 || codigo < 1);

        System.out.println("\nFIM!");
    }
}
