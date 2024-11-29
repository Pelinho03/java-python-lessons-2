package metodos;

import java.util.Scanner;
import java.util.ArrayList;

import rentcarlda.Automovel;
import rentcarlda.Cliente;

public class InserirCliente {

    // case 2
    // Inserir cliente
    public static void inserirCliente(Scanner entrada, ArrayList<Cliente> clientes) { // Tornar o método público e passar a lista

        int escolha = 4;
        do {
            System.out.println("Escolhe uma das opções:");
            System.out.println("1 - Inserir Cliente." +
                    "\n2 - Eliminar Cliente." +
                    "\n3 - Alterar Cliente." +
                    "\n4 - Sair.");
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

                    System.out.println("Cliente inserido com sucesso!\n");
                    System.out.println("");
                    break;

                case 2:
                    if (clientes.isEmpty()) {
                        System.out.println("Não há clientes registados para remover.\n");
                        return;
                    }

                    System.out.println("Escolha o cliente a remover:");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.println((i + 1) + " - " + c.getNome() + " " + c.getCc());
                    }

                    System.out.print("\nIndica o ID do cliente: ");
                    int escolhaRemover = entrada.nextInt() - 1;

                    if (escolhaRemover < 0 || escolhaRemover >= clientes.size()) {
                        System.out.println("Escolha inválida.");
                        return;
                    }

                    Cliente clienteRemover = clientes.get(escolhaRemover);
                    System.out.println("Tem a certeza que deseja remover o cliente " + clienteRemover.getNome() + " " + clienteRemover.getCc() + " " + clienteRemover.getMorada() + " " + clienteRemover.getCartaConducao() + "? (s/n)");
                    entrada.nextLine(); // Consumir o Enter
                    String confirmacao = entrada.nextLine();

                    if (confirmacao.equalsIgnoreCase("s")) {
                        clientes.remove(clienteRemover);
                        System.out.println("Cliente removido com sucesso.\n");
                    } else {
                        System.out.println("Operação cancelada.\n");
                    }
                    break;

                case 3:

                    if (clientes.isEmpty()) {
                        System.out.println("Não há clientes registados para alterar.\n");
                        return;
                    }

                    System.out.println("Escolha o cliente a alterar:");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.println((i + 1) + " - " + c.getNome() + " " + c.getCc());
                    }

                    System.out.print("\nIndica o ID do cliente: ");
                    int escolhaAlterar = entrada.nextInt() - 1;
                    entrada.nextLine(); // Consumir a linha restante após nextInt()

                    if (escolhaAlterar < 0 || escolhaAlterar >= clientes.size()) {
                        System.out.println("Escolha inválida.");
                        return;
                    }

                    Cliente clienteAlterar = clientes.get(escolhaAlterar);

                    System.out.println("\nAlterar os seguintes campos (pressiona Enter para manter o valor atual):\n");

                    System.out.print("Novo Nome (" + clienteAlterar.getNome() + "): ");
                    String novoNome = entrada.nextLine();
                    if (!novoNome.isEmpty()) clienteAlterar.setNome(novoNome);

                    System.out.print("Novo CC (" + clienteAlterar.getCc() + "): ");
                    String novoCc = entrada.nextLine();
                    if (!novoCc.isEmpty()) clienteAlterar.setCc(novoCc);

                    System.out.print("Nova Morada (" + clienteAlterar.getMorada() + "): ");
                    String novaMorada = entrada.nextLine();
                    if (!novaMorada.isEmpty()) clienteAlterar.setMorada(novaMorada);

                    System.out.print("Nova Carta de Condução (" + clienteAlterar.getCartaConducao() + "): ");
                    String novaCartaConducao = entrada.nextLine();
                    if (!novaCartaConducao.isEmpty()) clienteAlterar.setCartaConducao(novaCartaConducao);

                    System.out.println("Cliente alterado com sucesso!\n");
                    break;

                case 4:
                    System.out.println("A voltar ao menu principal, obrigado.\n");
                    break;

                default:
                    System.out.println("Valor inválido!\n");
                    break;
            }

        } while (escolha != 4);
    }
}
