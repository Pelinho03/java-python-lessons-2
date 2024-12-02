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
        int escolha = 3;
        do {
            System.out.println("RentCarLda > Lista de Automóveis");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe uma opcao: ");
            System.out.println("""
                    1 - Automoveis disponiveis.
                    2 - Automoveis alugados.
                    3 - Sair.""");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
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
                case 1:
                    System.out.println("RentCarLda > Lista de Automóveis > Disponíveis\n");
                    // Automóveis disponíveis
                    boolean encontrouDisponiveis = false;
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel a = automoveis.get(i);
                        if (!a.isAlugado()) { // Só mostra disponíveis
                            encontrouDisponiveis = true;
                            System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")" +
                                    "\n  - Cor: " + a.getCor() +
                                    "\n  - Ano: " + a.getAnoAquisicao() +
                                    "\n  - Valor: " + a.getValorDia() + " € por dia - Disponível");
                            System.out.println();
                        }
                    }
                    if (!encontrouDisponiveis) {
                        System.out.println("Nenhum automóvel disponível.");
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("RentCarLda > Lista de Automóveis > Alugados\n");
                    // Automóveis alugados
                    boolean encontrouAlugados = false;
                    ArrayList<Aluguer> todosAlugueres = new ArrayList<>();

                    // Recolher todos os alugueres dos automóveis
                    for (Automovel a : automoveis) {
                        todosAlugueres.addAll(a.getAlugueres());
                    }

                    // Ordenar os alugueres pela data de fim
                    todosAlugueres.sort((a1, a2) -> a1.getDataFim().compareTo(a2.getDataFim()));

                    // Mostrar os alugueres ordenados
                    for (int i = 0; i < todosAlugueres.size(); i++) {
                        Aluguer aluguer = todosAlugueres.get(i);
                        encontrouAlugados = true;

                        // Formatar as datas de início e fim para exibição
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String dataFimFormatada = formato.format(aluguer.getDataFim());
                        String dataInicioFormatada = formato.format(aluguer.getDataInicio());

                        // Obter informações do automóvel e cliente
                        Automovel a = aluguer.getAutomovel();
                        Cliente cliente = aluguer.getCliente();
                        String nomeCliente = cliente.getNome();
                        String ccCliente = cliente.getCc();

                        // Exibir informações do aluguer
                        System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")" +
                                "\n  - Ano: " + a.getAnoAquisicao() + "" +
                                "\n  - Valor: (" + a.getValorDia() + " € por dia)" +
                                "\n  - Alugado de: " + dataInicioFormatada + " até " + dataFimFormatada +
                                "\n    -> Cliente: " + nomeCliente + " (CC: " + ccCliente + ")" +
                                "\n    -> Total: " + aluguer.calcularCusto() + "€");
                        System.out.println();
                    }


                    if (!encontrouAlugados) {
                        System.out.println("Nenhum automóvel alugado.");
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("A voltar ao menu principal, obrigado.");
                    break;
                default:
                    System.out.println("Valor inválido!");
                    break;
            }
            System.out.println("");
        } while (escolha != 3);
    }
}
