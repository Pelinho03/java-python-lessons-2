package metodos;

import rentcarlda.Automovel;
import rentcarlda.Cliente;

import java.util.List;
import java.util.Scanner;

public class Pesquisas {

    public static void pesquisas(Scanner entrada, List<Automovel> automoveis, List<Cliente> clientes) {

        int escolha = 4;
        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe a opção:");
            System.out.println("1 - Pesquisar Automóvel;" +
                    "\n2 - Pesquisar Cliente;" +
                    "\n3 - Pesquisar Datas;" +
                    "\n4 - Sair.");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("\nOpcao: ");

            // Verificar se a entrada é válida (número)
            if (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insere um número.");
                entrada.next(); // Limpar a entrada inválida
                continue;
            }

            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > 4) {
                System.out.println("ERRO, escolhe uma opcao valida!");
                continue;
            }


            switch (escolha) {
                case 1:
                    System.out.println("");
                    System.out.println("Escolha um critério de pesquisa:");
                    System.out.println("1 - Pesquisar por Marca" +
                            "\n2 - Pesquisar por Modelo;" +
                            "\n3 - Voltar.");
                    System.out.print("\nOpcao: ");

                    int pesquisaAuto = entrada.nextInt();
                    entrada.nextLine(); // Consumir o Enter

                    if (pesquisaAuto == 1) {
                        System.out.print("Digite a marca do automóvel: ");
                        String marca = entrada.nextLine();
                        boolean encontrou = false;

                        for (int i = 0; i < automoveis.size(); i++) {
                            Automovel a = automoveis.get(i);
                            if (a.getMarca().equalsIgnoreCase(marca)) {
                                System.out.println("- Marca: " + a.getMarca() + "\n- Modelo: " + a.getModelo() + "\n- Matricula: " + a.getMatricula() + ".");
                                System.out.println();
                                encontrou = true;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Nenhum automóvel encontrado com a marca '" + marca + "'.\n");
                        }
                    } else if (pesquisaAuto == 2) {
                        System.out.print("Digite o modelo do automóvel: ");
                        String modelo = entrada.nextLine();
                        boolean encontrou = false;

                        for (int i = 0; i < automoveis.size(); i++) {
                            Automovel a = automoveis.get(i);
                            if (a.getModelo().equalsIgnoreCase(modelo)) {
                                System.out.println("- Marca: " + a.getMarca() + "\n- Modelo: " + a.getModelo() + "\n- Matricula: " + a.getMatricula() + ".");
                                System.out.println();
                                encontrou = true;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Nenhum automóvel encontrado com o modelo '" + modelo + "'.\n");
                        }
                    } else if (pesquisaAuto == 3) {
                        System.out.println("A voltar ao menu anterior..\n");
                    } else {
                        System.out.println("Opção inválida.\n");
                    }
                    break;

                case 2:
                    System.out.println("");
                    System.out.println("Escolhe um dis critérios de pesquisa:");
                    System.out.println("1 - Pesquisa por Nome;" +
                            "\n2 - Pesquisa por Morada;" +
                            "\n3 - Pesquisa por CC;" +
                            "\n4 - Voltar.");
                    System.out.print("\nOpcao: ");

                    int pesquisaCliente = entrada.nextInt();
                    entrada.nextLine();

                    if (pesquisaCliente == 1) {
                        System.out.print("Digita o nome da Pessoa: ");
                        String nome = entrada.nextLine();
                        boolean encontrou = false;

                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente c = clientes.get(i);
                            if (c.getNome().equalsIgnoreCase(nome)) {
                                System.out.println("- Nome: " + c.getNome() + "\n- CC: " + c.getCc() + "\n- Carta Nº: " + c.getCartaConducao() + "\n- Morada: " + c.getMorada() + ".");
                                System.out.println();
                                encontrou = true;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Nenhuma pessoa encontrada com esse Nome '" + nome + "'.\n");
                        }

                    } else if (pesquisaCliente == 2) {
                        System.out.println("Digita a morada da pessoa: ");
                        String morada = entrada.nextLine();
                        boolean encontrou = false;

                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente c = clientes.get(i);
                            if (c.getMorada().equalsIgnoreCase(morada)) {
                                System.out.println("- Nome: " + c.getNome() + "\n- CC: " + c.getCc() + "\n- Carta Nº: " + c.getCartaConducao() + "\n- Morada: " + c.getMorada() + ".");
                                System.out.println();
                                encontrou = true;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Nenhuma pessoa encontrada com essa Morada '" + morada + "'.\n");
                        }

                    } else if (pesquisaCliente == 3) {
                        System.out.println("Digita o CC da pessoa: ");
                        String cc = entrada.nextLine();
                        boolean encontrou = false;

                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente c = clientes.get(i);
                            if (c.getCc().equalsIgnoreCase(cc)) {
                                System.out.println("- Nome: " + c.getNome() + "\n- CC: " + c.getCc() + "\n- Carta Nº: " + c.getCartaConducao() + "\n- Morada: " + c.getMorada() + ".");
                                System.out.println();
                                encontrou = true;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Nenhuma pessoa encontrada com esse CC '" + cc + "'.\n");
                        }
                    } else if (pesquisaCliente == 4) {
                        System.out.println("A voltar ao menu anterior..\n");
                    } else {
                        System.out.println("Opção inválida.\n");

                    }
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("3");
                    break;

                case 4:
                    System.out.println("");
                    System.out.println("A voltar ao menu principal, obrigado.\n");
                    break;

                default:
                    System.out.println("");
                    System.out.println("Valor inválido!\n");
                    break;


            }
        } while (escolha != 4);

    }
}