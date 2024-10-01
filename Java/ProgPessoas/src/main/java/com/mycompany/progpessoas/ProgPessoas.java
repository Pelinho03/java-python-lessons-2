package com.mycompany.progpessoas;

import java.util.Scanner;

public class ProgPessoas {

    public static void main(String[] args) {
        double media = 0, maior = 0, menor = 0, altura = 0, totalalturam = 0;
        int mulheres = 0, homens = 0;
        String sexo;

        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            
            System.out.print("Digite o sexo [M/F] do  " + (i + 1) + " elemento: ");
            sexo = entrada.next();

            System.out.print("Altura: ");
            altura = entrada.nextDouble();
            
            if (altura < 0) {
                break;
            }

            if (i == 0) {
                maior = altura;
                menor = altura;
            } else {
                if (altura > maior) {
                    maior = altura;
                }
                if (altura < menor) {
                    menor = altura;
                }
            }

            if (sexo.equalsIgnoreCase("F")) {
                mulheres += 1;
            } else if (sexo.equalsIgnoreCase("M")) {
                homens += 1;
                totalalturam += altura;
            } else {
                System.out.println("Sexo invalido! Por favor digita 'M' ou 'F'.");
                i--;
            }
        }

        if (homens > 0) {
            media = totalalturam / homens;
        } else {
            System.out.println("Nenhum homem foi inserido.");
        }

        System.out.println("A maior altura do grupo e: " + maior);
        System.out.println("A menor altura do grupo e: " + menor);
        System.out.println("A media de altura dos homens e: " + media);
        System.out.println("Numero de mulheres: " + mulheres);
        System.out.println("Numero de homens: " + homens + " com altura total igual: " + totalalturam);
        
        entrada.close();
    }
}
