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

    //case 1
    // Inserir automóvel
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

        Automovel novoAutomovel = new Automovel(marca, modelo, cor, anoAquisicao, cilindrada, matricula, valorDia, false, null);
        automoveis.add(novoAutomovel);

        System.out.println("\nAutomovel inserido com sucesso!");
        System.out.println("");
    }
    //------------------------------------------------------------------------//

    // case 2
    // Inserir cliente
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
    //------------------------------------------------------------------------//

    //case 3
// Listar automóveis
    private static void listaAutomoveis() {
        int escolha = 3;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Escolhe a opcao: ");
            System.out.println("""
                1 - Automoveis disponiveis.
                2 - Automoveis alugados.
                3 - Sair.""");
            System.out.print("\nOpcao: ");

            // Verificar se a entrada é válida (número)
            if (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insere um número.");
                entrada.next(); // Limpar a entrada inválida
                continue;
            }

            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > 3) {
                System.out.println("ERRO, escolhe uma opcao valida!");
                continue;
            }

            switch (escolha) {
                case 1 -> { // Automóveis disponíveis
                    boolean encontrouDisponiveis = false;
                    for (Automovel a : automoveis) {
                        if (!a.isAlugado()) { // Só mostra disponíveis
                            encontrouDisponiveis = true;
                            System.out.println("- " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ") de "
                                    + a.getAnoAquisicao() + " (" + a.getValorDia() + " € por dia) - Disponível");
                        }
                    }
                    if (!encontrouDisponiveis) {
                        System.out.println("Nenhum automóvel disponível.");
                    }
                    System.out.println("");
                }
                case 2 -> { // Automóveis alugados
                    boolean encontrouAlugados = false;
                    for (Automovel a : automoveis) {
                        if (a.isAlugado()) { // Só mostra alugados
                            encontrouAlugados = true;
                            System.out.println("- " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ") de "
                                    + a.getAnoAquisicao() + " (" + a.getValorDia() + " € por dia) - Alugado");
                        }
                    }
                    if (!encontrouAlugados) {
                        System.out.println("Nenhum automóvel alugado.");
                    }
                    System.out.println("");
                }
                case 3 ->
                    System.out.println("A voltar ao menu principal, obrigado.");
                default ->
                    System.out.println("Valor inválido!");
            }
            System.out.println("");
        } while (escolha != 3);
    }

    //------------------------------------------------------------------------//
    //case 4
    // Listar clientes
    private static void listaClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente registado.");
            return;
        }
        for (int c = 0; c < clientes.size(); c++) {
            Cliente a = clientes.get(c);
            System.out.println((c + 1) + "- " + a.getNome() + " (CC: " + a.getCc() + ")");
        }
        System.out.println("");
    }
    //------------------------------------------------------------------------//

    //case 5
    // Criar aluguer
    private static void criarAluguer(Scanner entrada) {
        if (automoveis.isEmpty() || clientes.isEmpty()) {
            System.out.println("Não há automóveis ou clientes para realizar o aluguer.");
            return;
        }

        System.out.println("Escolha um automovel:");
        for (int i = 0; i < automoveis.size(); i++) {
            Automovel a = automoveis.get(i);
            System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")");
        }

        System.out.print("\nIndica o Id: ");
        int escolhaAutomovel = entrada.nextInt() - 1;
        if (escolhaAutomovel < 0 || escolhaAutomovel >= automoveis.size()) {
            System.out.println("Escolha invalida.");
            return;
        }

        Automovel automovelEscolhido = automoveis.get(escolhaAutomovel);

        System.out.println("\nEscolha um cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println((i + 1) + " - " + c.getNome() + " (CC: " + c.getCc() + ")");
        }

        System.out.print("\nIndica o Id: ");
        int escolhaCliente = entrada.nextInt() - 1;
        if (escolhaCliente < 0 || escolhaCliente >= clientes.size()) {
            System.out.println("Escolha invalida.");
            return;
        }

        Cliente clienteEscolhido = clientes.get(escolhaCliente);

        System.out.print("\nData de inicio (formato yyyy-MM-dd): ");
        String dataInicioStr = entrada.next();
        System.out.print("Data de fim (formato yyyy-MM-dd): ");
        String dataFimStr = entrada.next();

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date dataInicio = formato.parse(dataInicioStr);
            Date dataFim = formato.parse(dataFimStr);

            //se a data de inicio for após a da data de fim emite a mensagem
            if (dataInicio.after(dataFim)) {
                System.out.println("\nErro: A data de inicio deve ser anterior a data de fim.");
                return;
            }

            //
            if (!automovelEscolhido.estaDisponivel(dataInicio, dataFim)) {
                System.out.println("\nAutomovel indisponivel nas datas selecionadas.");
                System.out.println("");
                return;
            }

            Aluguer aluguer = new Aluguer(automovelEscolhido, clienteEscolhido, dataInicio, dataFim);
            automovelEscolhido.adicionarAluguer(aluguer);

            System.out.println("\nResumo do aluguer:");
            System.out.println("Automavel: " + automovelEscolhido.getMarca() + " " + automovelEscolhido.getModelo() + " (" + automovelEscolhido.getMatricula() + ")");
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
