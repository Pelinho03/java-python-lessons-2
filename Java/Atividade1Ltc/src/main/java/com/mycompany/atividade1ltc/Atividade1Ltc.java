package com.mycompany.atividade1ltc;

import java.util.Scanner;

public class Atividade1Ltc {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Cotações para os cálculos
        double cotacaoTeste = 0.25, cotacaoTrb = 0.50, cotacaoExame = 0.50;

        // Nomes das cadeiras
        String[] nomes = {"AN", "PI", "BD", "LTC", "RC"};
        int numAlunos = 10;
        int numUCs = nomes.length;

        // Variáveis de estatísticas
        double[] mediaUCs = new double[numUCs]; // Armazena a média de cada UC
        double mediaCurso = 0.0; // Armazena a média geral do curso
        double[] mediaAlunoTotal = new double[numAlunos]; // Armazena a média de cada aluno

        // Arrays booleanos para verificar se o aluno foi aprovado em frequência ou exame
        boolean[] aprovadoFreqArray = new boolean[numAlunos]; // Armazena se foi aprovado por frequência
        boolean[] aprovadoExameArray = new boolean[numAlunos]; // Armazena se foi aprovado por exame

        // Estatísticas gerais
        int aprovFreq = 0, reprovFreq = 0, aprovExame = 0, reprovExame = 0, aprovTotal = 0, reprovTotal = 0, grandeNota = 0;

        // Armazenamento das notas dos alunos por UC
        double[][] notasFinaisAlunos = new double[numAlunos][numUCs];

        // Ciclo para os alunos
        for (int i = 0; i < numAlunos; i++) {
            double somaNotasAluno = 0.0; // Para calcular a média do aluno
            boolean aprovadoFrequencia = true; // Começa por assumir que o aluno passou por frequência
            System.out.println("\nAluno n." + (i + 1));
            System.out.println("-=-=-=-=-");

            // Ciclo para cada UC (cadeira)
            for (int j = 0; j < numUCs; j++) {
                System.out.println("\nCadeira: " + nomes[j]);
                System.out.println("-=-=-=-=-=-=-=");

                double nota1, nota2, trb;

                // Validação das notas para teste 1
                do {
                    System.out.print("Digita a nota do teste 1 (entre 0 e 20): ");
                    nota1 = entrada.nextDouble();
                    if (nota1 < 0 || nota1 > 20) {
                        System.out.println("APENAS ENTRE 0 E 20!");
                    }
                } while (nota1 < 0 || nota1 > 20);

                // Validação das notas para teste 2
                do {
                    System.out.print("Digita a nota do teste 2 (entre 0 e 20): ");
                    nota2 = entrada.nextDouble();
                    if (nota2 < 0 || nota2 > 20) {
                        System.out.println("APENAS ENTRE 0 E 20!");
                    }
                } while (nota2 < 0 || nota2 > 20);

                // Validação das notas para o trabalho
                do {
                    System.out.print("Digita a nota do trabalho (entre 0 e 20): ");
                    trb = entrada.nextDouble();
                    if (trb < 0 || trb > 20) {
                        System.out.println("APENAS ENTRE 0 E 20!");
                    }
                } while (trb < 0 || trb > 20);

                // Cálculo da nota final
                double notaFinal = ((nota1 + nota2) * cotacaoTeste) + (trb * cotacaoTrb);
                System.out.println("Nota final na cadeira " + nomes[j] + ": " + notaFinal);

                // Armazenar a nota final
                notasFinaisAlunos[i][j] = notaFinal;
                somaNotasAluno += notaFinal;
                mediaUCs[j] += notaFinal;

                // Verificação se o aluno está aprovado ou vai a exame
                if (notaFinal >= 9.5) {
                    System.out.println("Aluno aprovado na cadeira " + nomes[j]);
                    aprovFreq++;
                } else {
                    System.out.println("\nAluno admitido ao Exame Final na cadeira " + nomes[j]);
                    double notaExame;
                    reprovFreq++;

                    // Validação da nota do exame
                    do {
                        System.out.print("Digita a nota do exame (entre 0 e 20): ");
                        notaExame = entrada.nextDouble();
                    } while (notaExame < 0 || notaExame > 20);
                    if (notaExame >= 18) {
                        grandeNota++;
                    }

                    // Recalcula a nota final com a nota do exame
                    notaFinal = (notaExame * cotacaoExame) + (trb * cotacaoTrb);
                    System.out.println("Nova nota final na cadeira " + nomes[j] + ": " + notaFinal);

                    // Armazenar a nova nota final
                    notasFinaisAlunos[i][j] = notaFinal;
                    somaNotasAluno += notaFinal;

                    // Verificação final se o aluno passou no exame
                    if (notaFinal >= 9.5) {
                        System.out.println("Aluno aprovado na cadeira " + nomes[j]);
                        aprovExame++;
                        aprovadoFrequencia = false; // Se passou no exame, não passou por frequência
                    } else {
                        System.out.println("Aluno reprovado na cadeira " + nomes[j]);
                        reprovExame++;
                    }
                }
            }

            // Cálculo da média do aluno
            double mediaAluno = somaNotasAluno / numUCs;
            mediaAlunoTotal[i] = mediaAluno; // Guardar a média do aluno no array
            System.out.println("\nMedia do aluno n." + (i + 1) + ": " + mediaAluno);
            mediaCurso += mediaAluno; // Somar para calcular a média do curso

            // Verificar se o aluno foi aprovado por frequência ou exame
            if (aprovadoFrequencia) {
                aprovadoFreqArray[i] = true;
            } else {
                aprovadoExameArray[i] = true;
            }

        }

        // Apresentar as notas finais de cada aluno em cada UC
        System.out.println("\nNotas finais dos alunos em cada UC:");
        for (int i = 0; i < numAlunos; i++) {
            for (int j = 0; j < numUCs; j++) {
                System.out.println("O aluno " + (i + 1) + " na cadeira " + nomes[j] + " teve a nota " + notasFinaisAlunos[i][j]);
            }
        }

        // Cálculo das médias das UCs
        System.out.println("\nMedias das UCs:");
        for (int j = 0; j < numUCs; j++) {
            mediaUCs[j] /= numAlunos;
            System.out.println("Media de " + nomes[j] + ": " + mediaUCs[j]);
        }

        // Cálculo da média geral do curso
        mediaCurso /= numAlunos;

        // Apresentar a média de cada aluno
        System.out.println("\nMedias de cada aluno:");
        for (int i = 0; i < numAlunos; i++) {
            System.out.println("O aluno " + (i + 1) + " tem media de: " + mediaAlunoTotal[i]);
        }

        // Apresentar se o aluno foi aprovado por frequência ou exame
        System.out.println("\nAprovacoes por frequencia ou exame:");
        for (int i = 0; i < numAlunos; i++) {
            if (aprovadoFreqArray[i]) {
                System.out.println("O aluno " + (i + 1) + " foi aprovado por frequencia.");
            } else if (aprovadoExameArray[i]) {
                System.out.println("O aluno " + (i + 1) + " foi aprovado por exame.");
            }
        }

        //Verifica os aprovados em ambos ou reprovados
        aprovTotal = aprovFreq + reprovFreq;
        reprovTotal = aprovExame + reprovExame;

        // Estatísticas finais
        System.out.println("\nMedia geral do curso: " + mediaCurso);
        System.out.println("\nAprovados em frequencia: " + aprovFreq);
        System.out.println("Reprovados em frequencia: " + reprovFreq);
        System.out.println("Aprovados em exame: " + aprovExame);
        System.out.println("Reprovados em exame: " + reprovExame);
        System.out.println("Aprovados (Freq + Exame): " + aprovTotal);
        System.out.println("Reprovados (Freq + Exame): " + reprovTotal);
        System.out.println("Aprovado em exame >= 18: " + grandeNota);

        entrada.close();
    }
}
