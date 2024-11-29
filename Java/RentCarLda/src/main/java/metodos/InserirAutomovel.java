package metodos;

import java.util.Scanner;

import rentcarlda.Automovel;

import java.util.List;  // Importação necessária para List

public class InserirAutomovel {


    // Método para inserir remover e alterar o automóvel
    public static void inserirAutomovel(Scanner entrada, List<Automovel> automoveis) {
        int escolha = 4;
        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Escolhe uma das opções:");
            System.out.println("1 - Inserir Automóvel." +
                    "\n2 - Eliminar Automóvel." +
                    "\n3 - Alterar Automóvel." +
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

                    System.out.println("\nAutomovel inserido com sucesso!\n");
                    System.out.println("");
                    break;

                case 2:
                    if (automoveis.isEmpty()) {
                        System.out.println("Não há automóveis registados para remover.");
                        return;
                    }

                    System.out.println("Escolha o automóvel a remover:");
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel a = automoveis.get(i);
                        System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")");
                    }

                    System.out.print("\nIndica o ID do automóvel: ");
                    int escolhaRemover = entrada.nextInt() - 1;

                    if (escolhaRemover < 0 || escolhaRemover >= automoveis.size()) {
                        System.out.println("Escolha inválida.");
                        return;
                    }

                    Automovel automovelRemover = automoveis.get(escolhaRemover);
                    System.out.println("Tem a certeza que deseja remover o automóvel " + automovelRemover.getMarca() + " " + automovelRemover.getModelo() + " (" + automovelRemover.getMatricula() + ")? (s/n)");
                    entrada.nextLine(); // Consumir o Enter
                    String confirmacao = entrada.nextLine();

                    if (confirmacao.equalsIgnoreCase("s")) {
                        automoveis.remove(automovelRemover);
                        System.out.println("Automóvel removido com sucesso.\n");
                    } else {
                        System.out.println("Operação cancelada.\n");
                    }
                    break;

                case 3:
                    if (automoveis.isEmpty()) {
                        System.out.println("Não há automóveis registados para alterar.");
                        return;
                    }

                    System.out.println("Escolha o automóvel a alterar:");
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel a = automoveis.get(i);
                        System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")");
                    }

                    System.out.print("\nIndica o ID do automóvel: ");
                    int escolhaAlterar = entrada.nextInt() - 1;
                    entrada.nextLine(); // Consumir a linha restante após nextInt()

                    if (escolhaAlterar < 0 || escolhaAlterar >= automoveis.size()) {
                        System.out.println("Escolha inválida.");
                        return;
                    }

                    Automovel automovelAlterar = automoveis.get(escolhaAlterar);

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
