package com.mycompany.medianotasalunos;

import java.util.Scanner;

public class MediaNotasAlunos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double media = 0, notas = 0;
        int rec = 0;

        System.out.println("MEDIA DE NOTAS [0/20]");
        // Recebe as 4 notas dos alunos
        for (int i = 0; i < 4; i++) {
            double nota;

            // Valida se a nota está entre 0 e 20
            do {
                System.out.print("Digita a " + (i + 1) + " nota: ");
                nota = entrada.nextDouble();
                if (nota > 20 || nota < 0) {
                    System.out.println("Valor inválido. Digita uma nota entre 0 e 20.");
                }
            } while (nota > 20 || nota < 0); // Continua a pedir até que o valor seja válido

            notas += nota; // Adiciona a nota válida ao total
        }

        // Calcula a média
        media = notas / 4;

        // Verifica se o aluno foi aprovado ou está em recuperação
        if (media >= 10) {
            System.out.printf("\nAPROVADO com %.2f valores.\n", media);
        } else {
            System.out.printf("\nALUNO EM RECUPERACAO com %.2f valores.\n", media);
            System.out.println("MAXIMO DE RECUPERACOES = 5");
            System.out.print("Digita a nota de recuperacao: ");
            double notaRec = entrada.nextDouble();
            media = (notaRec + media) / 2;
            rec++;

            // Se a média ainda for inferior a 10, continua a pedir recuperação
            while (media < 10 && rec < 5) {
                System.out.println("\nNOVA RECUPERACAO");
                System.out.printf("Media atual = %.2f\n", media);
                System.out.print("Digita a nova nota de recuperacao: ");
                notaRec = entrada.nextDouble();
                media = (notaRec + media) / 2;
                rec++;
            }

            // Verifica se o aluno foi aprovado após a(s) recuperação(ões)
            if (media >= 10) {
                System.out.printf("\nAluno APROVADO na recuperacao com %.2f valores ao fim de %d tentativa(s).\n", media, rec);
            } else {
                System.out.printf("\nREPROVADO NA CADEIRA com %.2f valores ao fim de %d tentativa(s).\n", media, rec);
            }
        }

        System.out.println("\nFIM!");
    }
}
