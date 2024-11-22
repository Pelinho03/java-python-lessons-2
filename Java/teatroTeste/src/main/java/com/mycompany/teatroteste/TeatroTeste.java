package com.mycompany.teatroteste;

import java.util.Scanner;

public class TeatroTeste {

    private static Scanner entrada = new Scanner(System.in);
    private static String[][] espetaculos = new String[10][3]; // Nome, Data, Horário
    private static boolean[][] lugares = new boolean[10][100]; // Teatro com 100 lugares por espetáculo

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.println("Gestão de Bilhetes - Teatro");
            System.out.println("1 - Adicionar Espetáculo");
            System.out.println("2 - Visualizar Espetáculos");
            System.out.println("3 - Vender Bilhete");
            System.out.println("4 - Listar Lugares Ocupados");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    adicionarEspetaculo();
                    break;
                case 2:
                    visualizarEspetaculos();
                    break;
                case 3:
                    venderBilhete();
                    break;
                case 4:
                    listarLugaresOcupados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void adicionarEspetaculo() {
        System.out.print("Nome do espetáculo: ");
        String nome = entrada.next();
        System.out.print("Data (dd/mm/yyyy): ");
        String data = entrada.next();
        System.out.print("Horário (hh:mm): ");
        String horario = entrada.next();

        for (int i = 0; i < espetaculos.length; i++) {
            if (espetaculos[i][0] == null) { // Encontrou um lugar vazio
                espetaculos[i][0] = nome;
                espetaculos[i][1] = data;
                espetaculos[i][2] = horario;
                System.out.println("Espetáculo adicionado com sucesso!");
                return;
            }
        }
        System.out.println("Número máximo de espetáculos atingido.");
        System.out.println("");
    }

    private static void visualizarEspetaculos() {
        for (int i = 0; i < espetaculos.length; i++) {
            if (espetaculos[i][0] != null) {
                System.out.println("Espetáculo: " + espetaculos[i][0]);
                System.out.println("Data: " + espetaculos[i][1]);
                System.out.println("Horário: " + espetaculos[i][2]);
            }
        }
        System.out.println("");
    }

    private static void venderBilhete() {
        System.out.print("Escolha um espetáculo (0 a " + (espetaculos.length - 1) + "): ");
        int indexEspetaculo = entrada.nextInt();
        System.out.print("Escolha um lugar (0 a 99): ");
        int lugar = entrada.nextInt();

        if (espetaculos[indexEspetaculo][0] == null) {
            System.out.println("Espetáculo não encontrado.");
            return;
        }

        if (lugar < 0 || lugar >= lugares[0].length || lugares[indexEspetaculo][lugar]) {
            System.out.println("Lugar indisponível.");
            return;
        }

        lugares[indexEspetaculo][lugar] = true;
        System.out.println("Bilhete vendido com sucesso!");
        System.out.println("");
    }

    private static void listarLugaresOcupados() {
        System.out.print("Escolha um espetáculo (0 a " + (espetaculos.length - 1) + "): ");
        int indexEspetaculo = entrada.nextInt();

        if (espetaculos[indexEspetaculo][0] == null) {
            System.out.println("Espetáculo não encontrado.");
            return;
        }

        System.out.println("Lugares ocupados para " + espetaculos[indexEspetaculo][0] + ":");
        for (int i = 0; i < lugares[indexEspetaculo].length; i++) {
            if (lugares[indexEspetaculo][i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}
