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
        inicializarDados();
        Scanner entrada = new Scanner(System.in);
        int opcao = 4;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Bem-vindo a Rent Car Lda!");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe uma opcao: "
                    + "\n1 - Inserir Automovel"
                    + "\n2 - Inserir Cliente"
                    + "\n3 - Ver lista de Automoveis"
                    + "\n4 - Ver lista de Clientes"
                    + "\n5 - Criar Aluguer"
                    + "\n6 - Sair");
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
                    inserirAutomovel(entrada);
                    break;
                case 2:
                    inserirCliente(entrada);
                    break;
                case 3:
                    listaAutomoveis();
                    break;
                case 4:
                    listaClientes();
                    break;
                case 5:
                    criarAluguer(entrada);
                    break;
                case 6:
                    System.out.println("A sair... Obrigado por usar Rent Car Lda!");
                    break;
                default:
                    System.out.println("Valor desconhecido!");
                    break;
            }

        } while (opcao != 6);

        entrada.close(); // Fechar o scanner para evitar leaks de memória
    }

// Método para inicializar dados de teste
    private static void inicializarDados() {
        // Adicionar alguns automóveis
        automoveis.add(new Automovel("Toyota", "Corolla", "Preto", 2019, 1600, "AA-01-AA", 50.0, false));
        automoveis.add(new Automovel("Honda", "Civic", "Branco", 2021, 2000, "BB-02-BB", 65.0, false));
        automoveis.add(new Automovel("Ford", "Focus", "Azul", 2018, 1500, "CC-03-CC", 45.0, false));

        // Adicionar alguns clientes
        clientes.add(new Cliente("Joao Silva", "Rua A, Porto", "12345678", "C123456"));
        clientes.add(new Cliente("Maria Santos", "Av. B, Lisboa", "87654321", "D876543"));
        clientes.add(new Cliente("Carlos Pereira", "Praça C, Coimbra", "23456789", "E234567"));
    }

    //case 1
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

    //case 2
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

    //case 3
    //Método para carregar a lista de automóveis
    private static void listaAutomoveis() {
        for (int l = 0; l < automoveis.size(); l++) {
            Automovel a = automoveis.get(l);
            System.out.println((l + 1) + " - " + a.getMarca() + " " + a.getModelo() + " " + "(" + a.getMatricula() + ")" + " " + " de " + a.getAnoAquisicao() + " " + "(" + a.getValorDia() + " € por dia)");
        }
        System.out.println("");
    }

    //case 4
    //Método para carregar lista de clientes
    private static void listaClientes() {
        for (int c = 0; c < clientes.size(); c++) {
            Cliente a = clientes.get(c);
            System.out.println((c + 1) + "- " + a.getNome() + " " + "(CC: " + a.getCc() + ")");
        }
        System.out.println("");
    }

    //case 5
    // Método para criar um aluguer
    private static void criarAluguer(Scanner entrada) {
        if (automoveis.isEmpty() || clientes.isEmpty()) {
            System.out.println("Não ha automoveis ou clientes para realizar o aluguer.");
            return;
        }

        System.out.println("Escolha um automovel:");

        // Mostrar lista de automóveis disponíveis
        for (int i = 0; i < automoveis.size(); i++) {
            Automovel a = automoveis.get(i);
            System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")");
        }

        System.out.print("\nIndica o Id: ");
        //escolher o automovel (-1) porque o (+1) é apenas para apresentação
        int escolhaAutomovel = entrada.nextInt() - 1; // Ajuste para 0-index
        if (escolhaAutomovel < 0 || escolhaAutomovel >= automoveis.size()) {
            System.out.println("Escolha invalida.");
            return;
        }

        Automovel automovelEscolhido = automoveis.get(escolhaAutomovel);

        System.out.println("\nEscolha um cliente:");

        // Mostrar lista de clientes
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println((i + 1) + " - " + c.getNome() + " (CC: " + c.getCc() + ")");
        }

        System.out.print("\nIndica o Id: ");
        int escolhaCliente = entrada.nextInt() - 1; // Ajuste para 0-index
        if (escolhaCliente < 0 || escolhaCliente >= clientes.size()) {
            System.out.println("Escolha invalida.");
            return;
        }

        Cliente clienteEscolhido = clientes.get(escolhaCliente);

        // Pedir as datas de início e fim
        System.out.print("\nData de inicio (formato yyyy-mm-dd): ");
        String dataInicioStr = entrada.next();
        System.out.print("Data de fim (formato yyyy-mm-dd): ");
        String dataFimStr = entrada.next();

        // Converter as strings para objetos Date
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date dataInicio = formato.parse(dataInicioStr);
            Date dataFim = formato.parse(dataFimStr);

            Aluguer aluguer = new Aluguer(automovelEscolhido, clienteEscolhido, dataInicio, dataFim);

            System.out.println("\nResumo do aluguer:");
            System.out.println("Automovel: " + automovelEscolhido.getMarca() + " " + automovelEscolhido.getModelo()
                    + " (" + automovelEscolhido.getMatricula() + ")");
            System.out.println("Cliente: " + clienteEscolhido.getNome() + " (CC: " + clienteEscolhido.getCc() + ")");
            System.out.println("Data de inicio: " + dataInicioStr);
            System.out.println("Data de fim: " + dataFimStr);
            System.out.println("Custo total: " + aluguer.calcularCusto() + "€");
            System.out.println("");
        } catch (ParseException e) {
            System.out.println("Erro ao processar as datas.");
        }
    }
}
