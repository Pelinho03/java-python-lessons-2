package com.mycompany.medianotasalunos;

import java.util.Scanner;

public class MediaNotasAlunos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double media = 0, totalNotas = 0;

        System.out.println("=== MÉDIA DE NOTAS [0/20] ===");

        // Receber as 4 notas dos alunos
        for (int i = 0; i < 4; i++) {
            double nota;

            // Valida se a nota está entre 0 e 20
            do {
                System.out.print("Digite a " + (i + 1) + "ª nota: ");
                nota = entrada.nextDouble();
                if (nota < 0 || nota > 20) {
                    System.out.println("Valor inválido. Digite uma nota entre 0 e 20.");
                }
            } while (nota < 0 || nota > 20);

            totalNotas += nota; // Soma as notas válidas
        }

        // Calcula a média
        media = totalNotas / 4;

        // Verifica se o aluno foi aprovado ou precisa de recuperação
        if (media >= 10) {
            System.out.printf("\nAPROVADO com %.2f valores.\n", media);
        } else {
            System.out.printf("\nALUNO EM RECUPERAÇÃO com %.2f valores.\n", media);
            media = realizarRecuperacao(media, entrada); // Chama o método para lidar com a recuperação
        }

        System.out.println("\nFIM!");
        entrada.close(); // Fecha o Scanner para evitar leaks de memória
    }

    /**
     * Método para lidar com a recuperação de um aluno.
     *
     * @param media    Média inicial do aluno.
     * @param entrada  Scanner para leitura de dados.
     * @return Média final após recuperação.
     */
    private static double realizarRecuperacao(double media, Scanner entrada) {
        int tentativas = 0;
        final int MAX_RECUPERACOES = 5;

        while (media < 10 && tentativas < MAX_RECUPERACOES) {
            System.out.printf("\nTentativa de recuperação %d (Média atual: %.2f)\n", tentativas + 1, media);

            double notaRec;
            do {
                System.out.print("Digite a nota de recuperação: ");
                notaRec = entrada.nextDouble();
                if (notaRec < 0 || notaRec > 20) {
                    System.out.println("Nota inválida. Digite uma nota entre 0 e 20.");
                }
            } while (notaRec < 0 || notaRec > 20);

            // Recalcular a média
            media = (media + notaRec) / 2;
            tentativas++;
        }

        // Resultado final após as recuperações
        if (media >= 10) {
            System.out.printf("\nAPROVADO na recuperação com %.2f valores após %d tentativa(s).\n", media, tentativas);
        } else {
            System.out.printf("\nREPROVADO com %.2f valores após %d tentativa(s).\n", media, tentativas);
        }

        return media;
    }
}
