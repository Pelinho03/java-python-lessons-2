package com.mycompany.verificarcodigoprof;

import java.util.Scanner;

public class VerificarCodigoProf {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int codigo;

        System.out.println("-------------------");
        System.out.println("  NUMEROS  ");
        System.out.println("-------------------");

        do {
            System.out.print("Digita um numero, 1, 2 ou 3: ");
            codigo = entrada.nextInt();

            switch (codigo) {
                case 1:
                    System.out.println("\nUM");
                    break;
                case 2:
                    System.out.println("\nDOIS");
                    break;
                case 3:
                    System.out.println("\nTRES");
                    break;
                default:
                    System.out.println("\nCodigo invalido!");
            }
        } while (codigo > 3 || codigo < 1);

        System.out.println("\nFIM!");
    }
}
