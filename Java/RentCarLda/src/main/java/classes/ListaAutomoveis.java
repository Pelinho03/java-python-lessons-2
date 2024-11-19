package classes;

import java.util.Scanner;
import java.util.ArrayList;
import rentcarlda.Automovel;

public class ListaAutomoveis {

    // case 3
    // Listar automóveis
    public static void listaAutomoveis(Scanner entrada, ArrayList<Automovel> automoveis) {
        int escolha = 3;
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
                case 3 -> System.out.println("A voltar ao menu principal, obrigado.");
                default -> System.out.println("Valor inválido!");
            }
            System.out.println("");
        } while (escolha != 3);
    }
}
