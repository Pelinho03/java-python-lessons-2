package com.mycompany.rentcarlda;

import classes.CriarAluguer;
import classes.InserirAutomovel;
import classes.InserirCliente;
import classes.ListaAutomoveis;
import classes.ListaClientes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import rentcarlda.Aluguer;
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
                               1 - Inserir Automovel
                               2 - Inserir Cliente
                               3 - Ver lista de Automoveis
                               4 - Ver lista de Clientes
                               5 - Criar Aluguer
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

    // Inicializar dados de exemplo
    private static void inicializarDados() {
        automoveis.add(new Automovel("Toyota", "Corolla", "Preto", 2019, 1600, "AA-01-AA", 50.0, false, null));
        automoveis.add(new Automovel("Honda", "Civic", "Branco", 2021, 2000, "BB-02-BB", 65.0, false, null));
        automoveis.add(new Automovel("Ford", "Focus", "Azul", 2018, 1500, "CC-03-CC", 45.0, false, null));

        clientes.add(new Cliente("Joao Silva", "Rua A, Porto", "12345678", "C123456"));
        clientes.add(new Cliente("Maria Santos", "Av. B, Lisboa", "87654321", "D876543"));
        clientes.add(new Cliente("Carlos Pereira", "Praça C, Coimbra", "23456789", "E234567"));
    }

}
