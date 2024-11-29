package com.mycompany.rentcarlda;

import metodos.CriarAluguer;
import metodos.InserirAutomovel;
import metodos.InserirCliente;
import metodos.ListaAutomoveis;
import metodos.ListaClientes;

import java.util.ArrayList;
import java.util.Scanner;

import rentcarlda.Automovel;
import rentcarlda.Cliente;

public class RentCarLda {

    private static ArrayList<Automovel> automoveis = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {

        inicializarDados();
        Scanner entrada = new Scanner(System.in);
        int opcao = 6, escolha = 3;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Bem-vindo a Rent Car Lda!");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("""
                    Escolhe uma opcao: 
                    1 - Automovel
                    2 - Cliente
                    3 - Ver lista de Automoveis
                    4 - Ver lista de Clientes
                    5 - Aluguer
                    6 - Sair""");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("\nOpcao: ");

            // Verificar se a entrada é válida (número)
            if (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insere um número.");
                entrada.next(); // Limpar a entrada inválida
                continue;
            }

            opcao = entrada.nextInt();

            if (opcao < 1 || opcao > 6) {
                System.out.println("Valor invalido! Tenta novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    InserirAutomovel.inserirAutomovel(entrada, automoveis);
                    break;
                case 2:
                    InserirCliente.inserirCliente(entrada, clientes);
                    break;
                case 3:
                    ListaAutomoveis.listaAutomoveis(entrada, automoveis);
                    break;
                case 4:
                    ListaClientes.listaClientes(entrada, clientes);
                    break;
                case 5:
                    CriarAluguer.criarAluguer(entrada, automoveis, clientes);
                    break;
                case 6:
                    System.out.println("A sair... Obrigado por usar Rent Car Lda!");
                    break;
                default:
                    System.out.println("Valor desconhecido!");
                    break;
            }

        } while (opcao != 6);

    }

    private static void inicializarDados() {
        // Adicionar automóveis
        automoveis.add(new Automovel("Toyota", "Corolla", "Preto", 2019, 1600, "AA-01-AA", 50.0, false, null));
        automoveis.add(new Automovel("Honda", "Civic", "Branco", 2021, 2000, "BB-02-BB", 65.0, false, null));
        automoveis.add(new Automovel("Ford", "Focus", "Azul", 2018, 1500, "CC-03-CC", 45.0, false, null));
        automoveis.add(new Automovel("BMW", "320i", "Cinzento", 2020, 2000, "DD-04-DD", 80.0, false, null));
        automoveis.add(new Automovel("Mercedes", "A180", "Vermelho", 2022, 1300, "EE-05-EE", 70.0, false, null));
        automoveis.add(new Automovel("Volkswagen", "Golf", "Prata", 2017, 1400, "FF-06-FF", 60.0, false, null));

        // Adicionar clientes
        clientes.add(new Cliente("João Silva", "Rua A, Porto", "12345678", "VR123456"));
        clientes.add(new Cliente("Maria Santos", "Av. B, Lisboa", "87654321", "PT678903"));
        clientes.add(new Cliente("Carlos Pereira", "Praça C, Coimbra", "23456789", "VS000019"));
        clientes.add(new Cliente("Ana Oliveira", "Rua D, Braga", "34567890", "BR543214"));
        clientes.add(new Cliente("Tiago Costa", "Av. E, Faro", "45678901", "LS098762"));
        clientes.add(new Cliente("Sofia Ramos", "Praça F, Setúbal", "56789012", "AL112237"));
    }


}
