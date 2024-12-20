package metodos;

import java.util.Scanner;
import java.util.ArrayList;

import rentcarlda.Automovel;
import rentcarlda.Cliente;

public class InserirCliente {

    // Método principal para gerir as opções de cliente (inserir, eliminar, alterar)
    public static void inserirCliente(Scanner entrada, ArrayList<Cliente> clientes) {
        int escolha = 4; // Inicializa a escolha com o valor de saída

        do {
            // Menu principal para as operações de cliente
            System.out.println("RentCarLda > Cliente");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe uma Opção: ");
            System.out.println("1 - Inserir Cliente." +
                    "\n2 - Eliminar Cliente." +
                    "\n3 - Alterar Cliente." +
                    "\n4 - Sair.");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("\nOpção: ");

            // Validação da entrada como um número inteiro
            if (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insere um número.");
                entrada.next(); // Limpar a entrada inválida
                continue;
            }

            escolha = entrada.nextInt(); // Captura a opção escolhida

            // Valida se a escolha está no intervalo permitido
            if (escolha < 1 || escolha > 4) {
                System.out.println("ERRO, escolhe uma Opção válida!");
                continue;
            }

            switch (escolha) {
                case 1:
                    // Inserir um novo cliente
                    System.out.println("RentCarLda > Cliente > Inserir");

                    // Captura os detalhes do cliente
                    System.out.print("Nome: ");
                    String nome = entrada.next();

                    System.out.print("Morada: ");
                    String morada = entrada.next();

                    System.out.print("Cartão de Cidadão (CC - 8 dígitos): ");
                    String cc = entrada.next();

                    // Valida o formato do CC (exatamente 8 dígitos numéricos)
                    while (!cc.matches("\\d{8}")) {
                        System.out.println("CC inválido! Deve conter exatamente 8 dígitos numéricos. Tenta novamente.");
                        System.out.print("Cartão de Cidadão (CC - 8 dígitos): ");
                        cc = entrada.next();
                    }

                    System.out.print("Carta de Condução (formato AB123456): ");
                    String cartaConducao = entrada.next();

                    // Valida o formato da Carta de Condução (ex.: AB123456)
                    while (!cartaConducao.matches("^[A-Z]{2}\\d{5}\\d{1}")) {
                        System.out.println("Carta de Condução inválida! Deve seguir o formato AB123456.");
                        System.out.print("Carta de Condução (formato AB123456): ");
                        cartaConducao = entrada.next();
                    }

                    // Cria um novo cliente e adiciona à lista
                    Cliente novoCliente = new Cliente(nome, morada, cc, cartaConducao);
                    clientes.add(novoCliente);

                    System.out.println("Cliente inserido com sucesso!\n");
                    break;

                case 2:
                    // Eliminar um cliente existente
                    System.out.println("RentCarLda > Cliente > Eliminar\n");

                    // Verifica se existem clientes para remover
                    if (clientes.isEmpty()) {
                        System.out.println("Não há clientes registados para remover.\n");
                        return;
                    }

                    // Mostra a lista de clientes para seleção
                    System.out.println("Escolha o cliente a remover:");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.println((i + 1) + " - " + c.getNome() + " (CC - " + c.getCc() + ")\n  - Carta Nº: "
                                + c.getCartaConducao() + "\n  - Morada: " + c.getMorada());
                        System.out.println();
                    }

                    // Captura a escolha do cliente a remover
                    System.out.print("\nIndica o ID do cliente: ");
                    int escolhaRemover = entrada.nextInt() - 1;

                    // Valida a escolha
                    if (escolhaRemover < 0 || escolhaRemover >= clientes.size()) {
                        System.out.println("Escolha inválida.\n");
                        return;
                    }

                    // Confirmação antes de remover o cliente
                    Cliente clienteRemover = clientes.get(escolhaRemover);
                    System.out.println("Tem a certeza que deseja remover o cliente " + clienteRemover.getNome() + " "
                            + clienteRemover.getCc() + " " + clienteRemover.getMorada() + " "
                            + clienteRemover.getCartaConducao() + "? (s/n)");
                    entrada.nextLine(); // Consumir o Enter
                    String confirmacao = entrada.nextLine();

                    if (confirmacao.equalsIgnoreCase("s")) {
                        clientes.remove(clienteRemover); // Remove o cliente
                        System.out.println("Cliente removido com sucesso.\n");
                    } else {
                        System.out.println("Operação cancelada.\n");
                    }
                    break;

                case 3:
                    // Alterar dados de um cliente
                    System.out.println("RentCarLda > Cliente > Alterar\n");

                    // Verifica se existem clientes para alterar
                    if (clientes.isEmpty()) {
                        System.out.println("Não há clientes registados para alterar.\n");
                        return;
                    }

                    // Mostra a lista de clientes para seleção
                    System.out.println("Escolha o cliente a alterar:");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.println((i + 1) + " - " + c.getNome() + " (CC - " + c.getCc() + ")\n  - Carta Nº: "
                                + c.getCartaConducao() + "\n  - Morada: " + c.getMorada());
                        System.out.println();
                    }

                    // Captura a escolha do cliente a alterar
                    System.out.print("\nIndica o ID do cliente: ");
                    int escolhaAlterar = entrada.nextInt() - 1;
                    entrada.nextLine(); // Consumir a linha restante após nextInt()

                    // Valida a escolha
                    if (escolhaAlterar < 0 || escolhaAlterar >= clientes.size()) {
                        System.out.println("Escolha inválida.");
                        return;
                    }

                    // Altera os dados do cliente selecionado
                    Cliente clienteAlterar = clientes.get(escolhaAlterar);

                    // Alterar Nome
                    System.out.print("Novo Nome (" + clienteAlterar.getNome() + "): ");
                    String novoNome = entrada.nextLine();
                    if (!novoNome.isEmpty())
                        clienteAlterar.setNome(novoNome);

                    // Alterar CC
                    System.out.print("Novo CC (" + clienteAlterar.getCc() + " - 8 dígitos): ");
                    String novoCc = entrada.nextLine();
                    if (!novoCc.isEmpty()) {
                        while (!novoCc.matches("\\d{8}")) {
                            System.out.println("CC inválido! Deve conter exatamente 8 dígitos numéricos.");
                            System.out.print("Novo CC (" + clienteAlterar.getCc() + " - 8 dígitos): ");
                            novoCc = entrada.nextLine();
                        }
                        clienteAlterar.setCc(novoCc);
                    }

                    // Alterar Morada
                    System.out.print("Nova Morada (" + clienteAlterar.getMorada() + "): ");
                    String novaMorada = entrada.nextLine();
                    if (!novaMorada.isEmpty())
                        clienteAlterar.setMorada(novaMorada);

                    // Alterar Carta de Condução
                    System.out.print("Nova Carta de Condução (" + clienteAlterar.getCartaConducao() + "): ");
                    String novaCartaConducao = entrada.nextLine();
                    if (!novaCartaConducao.isEmpty()) {
                        while (!novaCartaConducao.matches("^[A-Z]{2}\\d{5}\\d$")) {
                            System.out.println("Carta de Condução inválida! Deve seguir o formato AB123456.");
                            System.out.print("Nova Carta de Condução (" + clienteAlterar.getCartaConducao() + "): ");
                            novaCartaConducao = entrada.nextLine();
                        }
                        clienteAlterar.setCartaConducao(novaCartaConducao);
                    }

                    System.out.println("Cliente alterado com sucesso!\n");
                    break;

                case 4:
                    // Sair do menu de cliente
                    System.out.println("A voltar ao menu principal, obrigado.\n");
                    break;

                default:
                    // Caso de erro inesperado
                    System.out.println("Valor inválido!\n");
                    break;
            }

        } while (escolha != 4); // Repete o menu até o utilizador escolher sair
    }
}
