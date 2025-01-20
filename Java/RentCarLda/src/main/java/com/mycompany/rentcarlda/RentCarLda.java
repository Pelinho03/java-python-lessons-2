package com.mycompany.rentcarlda;

import metodos.*;
import java.util.ArrayList;
import java.util.Scanner;
import rentcarlda.Automovel;
import rentcarlda.Cliente;

public class RentCarLda {

    // Listas para armazenar os automóveis e clientes
    private static ArrayList<Automovel> automoveis = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializa os dados (adiciona automóveis e clientes)
        inicializarDados();


        // Usar try-with-resources para garantir que o Scanner seja fechado
        try (Scanner entrada = new Scanner(System.in)) {
            int opcao = 0;  // Inicia a opção com um valor seguro (0)

            do {
                // Exibe o menu para o utilizador escolher a opção
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Bem-vindo a Rent Car Lda!");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("""
                        Escolhe uma Opção: 
                        1 - Automóvel
                        2 - Cliente
                        3 - Ver lista de Automóveis
                        4 - Ver lista de Clientes
                        5 - Aluguer
                        6 - Pesquisas
                        7 - Sair""");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.print("\nOpção: ");

                // Verifica se a entrada é válida (número)
                if (!entrada.hasNextInt()) {
                    System.out.println("Entrada inválida! Por favor, insere um número.");
                    entrada.next(); // Limpa a entrada inválida
                    continue;
                }

                opcao = entrada.nextInt();  // Lê a opção do utilizador

                // Se a opção for fora do intervalo, pede para tentar novamente
                if (opcao < 1 || opcao > 7) {
                    System.out.println("Valor inválido! Tenta novamente.");
                    continue;
                }

                // Ação conforme a opção escolhida
                switch (opcao) {
                    case 1:
                        // Adicionar automóvel
                        System.out.println("");
                        InserirAutomovel.inserirAutomovel(entrada, automoveis);
                        break;
                    case 2:
                        // Adicionar cliente
                        System.out.println("");
                        InserirCliente.inserirCliente(entrada, clientes);
                        break;
                    case 3:
                        // Ver lista de automóveis
                        System.out.println("");
                        ListaAutomoveis.listaAutomoveis(entrada, automoveis);
                        break;
                    case 4:
                        // Ver lista de clientes
                        System.out.println("");
                        ListaClientes.listaClientes(entrada, clientes);
                        break;
                    case 5:
                        // Criar aluguer
                        System.out.println("");
                        CriarAluguer.criarAluguer(entrada, automoveis, clientes);
                        break;
                    case 6:
                        // Fazer pesquisa
                        System.out.println("");
                        Pesquisas.pesquisas(entrada, automoveis, clientes);
                        break;
                    case 7:
                        // Sair
                        System.out.println("");
                        System.out.println("A sair... Obrigado por usar Rent Car Lda!");
                        break;
                    default:
                        System.out.println("Valor desconhecido!");
                        break;
                }

            } while (opcao != 7);  // Loop até o utilizador escolher a opção de sair
        }
    }

    private static void inicializarDados() {
        // Adiciona automóveis de exemplo
        automoveis.add(new Automovel("Toyota", "Corolla", "Preto", 2019, 1600, "AA-01-AA", 50.0, false, null));
        automoveis.add(new Automovel("Honda", "Civic", "Branco", 2021, 2000, "BB-02-BB", 65.0, false, null));
        automoveis.add(new Automovel("Ford", "Focus", "Azul", 2018, 1500, "CC-03-CC", 45.0, false, null));
        automoveis.add(new Automovel("BMW", "320i", "Cinzento", 2020, 2000, "DD-04-DD", 80.0, false, null));
        automoveis.add(new Automovel("BMW", "I8", "Branco", 2024, 3500, "DA-21-ER", 120.0, false, null));
        automoveis.add(new Automovel("Mercedes", "A180", "Vermelho", 2022, 1300, "EE-05-EE", 70.0, false, null));
        automoveis.add(new Automovel("Volkswagen", "Golf", "Prata", 2017, 1400, "FF-06-FF", 60.0, false, null));

        // Adiciona clientes de exemplo
        clientes.add(new Cliente("João", "Porto", "12345678", "VR123456"));
        clientes.add(new Cliente("Maria", "Lisboa", "87654321", "PT678903"));
        clientes.add(new Cliente("Carlos", "Coimbra", "23456789", "VS000019"));
        clientes.add(new Cliente("Ana", "Braga", "34567890", "BR543214"));
        clientes.add(new Cliente("Tiago", "Faro", "45678901", "LS098762"));
        clientes.add(new Cliente("Sofia", "Setúbal", "56789012", "AL112237"));
    }
}
