package metodos;

import java.util.Scanner;

import rentcarlda.Automovel;

import java.util.List; // Importação necessária para List

public class InserirAutomovel {

    // Método para inserir, remover e alterar automóveis
    public static void inserirAutomovel(Scanner entrada, List<Automovel> automoveis) {
        int escolha = 4; // Variável para armazenar a escolha do utilizador
        do {
            // Menu principal
            System.out.println("RentCarLda > Automóvel");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe uma Opção: ");
            System.out.println("1 - Inserir Automóvel." +
                    "\n2 - Eliminar Automóvel." +
                    "\n3 - Alterar Automóvel." +
                    "\n4 - Sair.");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("\nOpção: ");

            // Verificar se a entrada é válida (deve ser um número)
            if (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insere um número.");
                entrada.next(); // Limpar a entrada inválida
                continue; // Recomeçar o ciclo
            }

            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > 4) {
                System.out.println("ERRO, escolhe uma Opção válida!");
                continue; // Recomeçar o ciclo
            }

            // Processar a escolha do utilizador
            switch (escolha) {
                case 1: // Inserir um novo automóvel
                    System.out.println("RentCarLda > Automóvel > Inserir");
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

                    // Criar e adicionar o automóvel à lista
                    Automovel novoAutomovel = new Automovel(marca, modelo, cor, anoAquisicao, cilindrada, matricula, valorDia, false, null);
                    automoveis.add(novoAutomovel);

                    System.out.println("\nAutomovel inserido com sucesso!\n");
                    break;

                case 2: // Remover um automóvel
                    System.out.println("RentCarLda > Automóvel > Eliminar\n");
                    if (automoveis.isEmpty()) {
                        System.out.println("Não há automóveis registados para remover.");
                        return;
                    }

                    // Listar os automóveis disponíveis
                    System.out.println("Escolha o automóvel a remover:");
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel a = automoveis.get(i);
                        System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")");
                    }

                    System.out.print("\nIndica o ID do automóvel: ");
                    int escolhaRemover = entrada.nextInt() - 1;

                    // Verificar se a escolha é válida
                    if (escolhaRemover < 0 || escolhaRemover >= automoveis.size()) {
                        System.out.println("Escolha inválida.");
                        return;
                    }

                    // Confirmar remoção do automóvel
                    Automovel automovelRemover = automoveis.get(escolhaRemover);
                    System.out.println("Tem a certeza que deseja remover o automóvel " + automovelRemover.getMarca() + " " + automovelRemover.getModelo() + " (" + automovelRemover.getMatricula() + ")? (s/n)");
                    entrada.nextLine(); // Consumir o Enter
                    String confirmacao = entrada.nextLine();

                    if (confirmacao.equalsIgnoreCase("s")) {
                        automoveis.remove(automovelRemover); // Remover o automóvel da lista
                        System.out.println("Automóvel removido com sucesso.\n");
                    } else {
                        System.out.println("Operação cancelada.\n");
                    }
                    break;

                case 3: // Alterar um automóvel
                    System.out.println("RentCarLda > Automóvel > Alterar\n");
                    if (automoveis.isEmpty()) {
                        System.out.println("Não há automóveis registados para alterar.");
                        return;
                    }

                    // Listar os automóveis disponíveis
                    System.out.println("Escolha o automóvel a alterar:");
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel a = automoveis.get(i);
                        System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")");
                    }

                    System.out.print("\nIndica o ID do automóvel: ");
                    int escolhaAlterar = entrada.nextInt() - 1;
                    entrada.nextLine(); // Consumir a linha restante após nextInt()

                    // Verificar se a escolha é válida
                    if (escolhaAlterar < 0 || escolhaAlterar >= automoveis.size()) {
                        System.out.println("Escolha inválida.");
                        return;
                    }

                    Automovel automovelAlterar = automoveis.get(escolhaAlterar);

                    // Alterar os atributos do automóvel
                    System.out.println("\nAlterar os seguintes campos (pressiona Enter para manter o valor atual):\n");

                    System.out.print("Nova Marca (" + automovelAlterar.getMarca() + "): ");
                    String novaMarca = entrada.nextLine();
                    if (!novaMarca.isEmpty()) automovelAlterar.setMarca(novaMarca);

                    System.out.print("Novo Modelo (" + automovelAlterar.getModelo() + "): ");
                    String novoModelo = entrada.nextLine();
                    if (!novoModelo.isEmpty()) automovelAlterar.setModelo(novoModelo);

                    System.out.print("Nova Cor (" + automovelAlterar.getCor() + "): ");
                    String novaCor = entrada.nextLine();
                    if (!novaCor.isEmpty()) automovelAlterar.setCor(novaCor);

                    System.out.print("Novo Ano de Aquisição (" + automovelAlterar.getAnoAquisicao() + "): ");
                    String novoAno = entrada.nextLine();
                    if (!novoAno.isEmpty()) automovelAlterar.setAnoAquisicao(Integer.parseInt(novoAno));

                    System.out.print("Nova Cilindrada (" + automovelAlterar.getCilindrada() + "): ");
                    int novaCilindrada = entrada.nextInt();
                    entrada.nextLine(); // Consumir a linha restante após nextInt()
                    if (novaCilindrada > 0) automovelAlterar.setCilindrada(novaCilindrada);

                    System.out.print("Nova Matrícula (" + automovelAlterar.getMatricula() + "): ");
                    String novaMatricula = entrada.nextLine();
                    if (!novaMatricula.isEmpty()) automovelAlterar.setMatricula(novaMatricula);

                    System.out.print("Novo Valor Diário (" + automovelAlterar.getValorDia() + "): ");
                    double novoValor = entrada.nextDouble();
                    if (novoValor > 0) automovelAlterar.setValorDia(novoValor);

                    System.out.println("Automóvel alterado com sucesso!\n");
                    break;

                case 4: // Sair do menu
                    System.out.println("A voltar ao menu principal, obrigado.\n");
                    break;

                default:
                    System.out.println("Valor inválido!\n");
                    break;
            }

        } while (escolha != 4);
    }
}
