package com.mycompany.rentcarlda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import rentcarlda.Aluguer;
import rentcarlda.Automovel;
import rentcarlda.Cliente;

public class RentCarLda {

    // Listas para armazenar automóveis e clientes
    private static ArrayList<Automovel> automoveis = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 4;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Bem-vindo a Rent Car Lda!");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe uma opcao: "
                    + "\n1 - Inserir Automovel"
                    + "\n2 - Inserir Cliente"
                    + "\n3 - Criar Aluguer"
                    + "\n4 - Sair");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("\nOpcao: ");

            // Verificar se a entrada é válida (número)
            if (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insere um número.");
                entrada.next(); // Limpar a entrada inválida
                continue;
            }

            opcao = entrada.nextInt();

            if (opcao < 1 || opcao > 4) {
                System.out.println("Valor invalido! Tenta novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    inserirAutomovel(entrada);
                    break;
                case 2:
                    inserirCliente(entrada);
                    break;
                case 3:
                    criarAluguer(entrada);
                    break;
                case 4:
                    System.out.println("A sair... Obrigado por usar Rent Car Lda!");
                    break;
                default:
                    System.out.println("Valor desconhecido!");
                    break;
            }

        } while (opcao != 4);

        entrada.close(); // Fechar o scanner para evitar leaks de memória
    }

    // Método para inserir um automóvel
    private static void inserirAutomovel(Scanner entrada) {
        System.out.print("\nMarca: ");
        String marca = entrada.next();

        System.out.print("Modelo: ");
        String modelo = entrada.next();

        System.out.print("Cor: ");
        String cor = entrada.next();

        System.out.print("Ano de Aquisicao: ");
        int anoAquisicao = entrada.nextInt();

        System.out.print("Cilindrada: ");
        int cilindrada = entrada.nextInt();

        System.out.print("Matricula: ");
        String matricula = entrada.next();

        System.out.print("Valor diario de aluguer: ");
        double valorDia = entrada.nextDouble();

        // Criar o automóvel com valores padrão para os parâmetros restantes
        Automovel novoAutomovel = new Automovel(marca, modelo, cor, anoAquisicao, cilindrada, matricula, valorDia, false);
        automoveis.add(novoAutomovel);

        System.out.println("\nAutomovel inserido com sucesso!");
        System.out.println("");
    }

    // Método para inserir um cliente
    private static void inserirCliente(Scanner entrada) {
        System.out.print("Nome: ");
        String nome = entrada.next();

        System.out.print("Morada: ");
        String morada = entrada.next();

        System.out.print("Cartao de Cidadao (CC): ");
        String cc = entrada.next();

        System.out.print("Carta de Conducao: ");
        String cartaConducao = entrada.next();

        Cliente novoCliente = new Cliente(nome, morada, cc, cartaConducao);
        clientes.add(novoCliente);

        System.out.println("Cliente inserido com sucesso!");
        System.out.println("");
    }

    // Método para criar um aluguer
    private static void criarAluguer(Scanner entrada) {
        if (automoveis.isEmpty() || clientes.isEmpty()) {
            System.out.println("Não há automóveis ou clientes para realizar o aluguer.");
            return;
        }

        System.out.println("Escolha um automóvel:");

        // Mostrar lista de automóveis disponíveis
        for (int i = 0; i < automoveis.size(); i++) {
            Automovel a = automoveis.get(i);
            System.out.println(i + 1 + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")");
        }

        int escolhaAutomovel = entrada.nextInt() - 1; // Ajuste para 0-index
        if (escolhaAutomovel < 0 || escolhaAutomovel >= automoveis.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Automovel automovelEscolhido = automoveis.get(escolhaAutomovel);

        System.out.println("Escolha um cliente:");

        // Mostrar lista de clientes
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println(i + 1 + " - " + c.getNome() + " (CC: " + c.getCc() + ")");
        }

        int escolhaCliente = entrada.nextInt() - 1; // Ajuste para 0-index
        if (escolhaCliente < 0 || escolhaCliente >= clientes.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Cliente clienteEscolhido = clientes.get(escolhaCliente);

        // Pedir as datas de início e fim
        System.out.print("Data de início (formato yyyy-mm-dd): ");
        String dataInicioStr = entrada.next();
        System.out.print("Data de fim (formato yyyy-mm-dd): ");
        String dataFimStr = entrada.next();

        // Converter as strings para objetos Date
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date dataInicio = formato.parse(dataInicioStr);
            Date dataFim = formato.parse(dataFimStr);

            Aluguer aluguer = new Aluguer(automovelEscolhido, clienteEscolhido, dataInicio, dataFim);
            System.out.println("Aluguer criado com sucesso! Custo: " + aluguer.calcularCusto());
        } catch (ParseException e) {
            System.out.println("Erro ao processar as datas.");
        }
    }
}
