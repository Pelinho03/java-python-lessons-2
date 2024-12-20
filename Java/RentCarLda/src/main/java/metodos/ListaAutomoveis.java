package metodos;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

import rentcarlda.Aluguer;
import rentcarlda.Automovel;
import rentcarlda.Cliente;

public class ListaAutomoveis {

    // case 3
    // Listar automóveis
    public static void listaAutomoveis(Scanner entrada, ArrayList<Automovel> automoveis) {
        int escolha = 3; // Variável para armazenar a escolha do utilizador
        do {
            // Menu principal
            System.out.println("RentCarLda > Lista de Automóveis");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe uma Opção: ");
            System.out.println("""
                    1 - Automoveis disponiveis.
                    2 - Automoveis alugados.
                    3 - Sair.""");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("\nOpção: ");

            // Valida se a entrada é um número
            if (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insere um número.");
                entrada.next(); // Limpa a entrada inválida
                continue;
            }

            escolha = entrada.nextInt(); // Lê a escolha do utilizador
            if (escolha < 1 || escolha > 3) { // Verifica se a opção está dentro do intervalo válido
                System.out.println("ERRO, escolhe uma Opção valida!");
                continue;
            }

            switch (escolha) {
                case 1:
                    // Lista de automóveis disponíveis
                    System.out.println("RentCarLda > Lista de Automóveis > Disponíveis\n");
                    boolean encontrouDisponiveis = false; // Flag para verificar se há automóveis disponíveis
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel a = automoveis.get(i);
                        if (!a.isAlugado()) { // Verifica se o automóvel não está alugado
                            encontrouDisponiveis = true; // Marca como encontrado
                            // Exibe as informações do automóvel
                            System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")" +
                                    "\n  - Cor: " + a.getCor() +
                                    "\n  - Ano: " + a.getAnoAquisicao() +
                                    "\n  - Valor: " + a.getValorDia() + " € por dia - Disponível");
                            System.out.println();
                        }
                    }
                    // Caso não encontre automóveis disponíveis
                    if (!encontrouDisponiveis) {
                        System.out.println("Nenhum automóvel disponível.");
                    }
                    System.out.println("");
                    break;

                case 2:
                    // Lista de automóveis alugados
                    System.out.println("RentCarLda > Lista de Automóveis > Alugados\n");
                    boolean encontrouAlugados = false; // Flag para verificar se há automóveis alugados
                    ArrayList<Aluguer> todosAlugueres = new ArrayList<>(); // Lista para armazenar todos os alugueres

                    // Adiciona todos os alugueres de cada automóvel à lista
                    for (int i = 0; i < automoveis.size(); i++) {
                        todosAlugueres.addAll(automoveis.get(i).getAlugueres());
                    }

                    // Ordena os alugueres pela data de fim (ascendente)
                    todosAlugueres.sort((a1, a2) -> a1.getDataFim().compareTo(a2.getDataFim()));

                    // Percorre a lista de alugueres ordenada
                    for (int i = 0; i < todosAlugueres.size(); i++) {
                        Aluguer aluguer = todosAlugueres.get(i);
                        encontrouAlugados = true; // Marca como encontrado

                        // Formata as datas de início e fim para exibição
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String dataFimFormatada = formato.format(aluguer.getDataFim());
                        String dataInicioFormatada = formato.format(aluguer.getDataInicio());

                        // Obtém informações do automóvel e cliente associados ao aluguer
                        Automovel a = aluguer.getAutomovel();
                        Cliente cliente = aluguer.getCliente();
                        String nomeCliente = cliente.getNome();
                        String ccCliente = cliente.getCc();

                        // Exibe informações detalhadas do aluguer
                        System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")" +
                                "\n  - Ano: " + a.getAnoAquisicao() + "" +
                                "\n  - Valor: (" + a.getValorDia() + " € por dia)" +
                                "\n  - Alugado de: " + dataInicioFormatada + " até " + dataFimFormatada +
                                "\n    -> Cliente: " + nomeCliente + " (CC: " + ccCliente + ")" +
                                "\n    -> Total: " + aluguer.calcularCusto() + "€");
                        System.out.println();
                    }

                    // Caso não encontre automóveis alugados
                    if (!encontrouAlugados) {
                        System.out.println("Nenhum automóvel alugado.");
                    }
                    System.out.println("");
                    break;

                case 3:
                    // Sair do menu
                    System.out.println("A voltar ao menu principal, obrigado.");
                    break;

                default:
                    // Caso o utilizador insira um valor inválido (teoricamente não atingido devido à validação anterior)
                    System.out.println("Valor inválido!");
                    break;
            }
            System.out.println("");
        } while (escolha != 3); // Continua a executar até o utilizador escolher sair
    }
}
