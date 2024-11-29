package metodos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import rentcarlda.Aluguer;
import rentcarlda.Automovel;
import rentcarlda.Cliente;


public class CriarAluguer {
    // Criar aluguer
    public static void criarAluguer(Scanner entrada, ArrayList<Automovel> automoveis, ArrayList<Cliente> clientes) {

        int escolha = 4;
        do {
            System.out.println("Escolhe uma das opções:");
            System.out.println("1 - Criar Aluguer." +
                    "\n2 - Eliminar Aluguer." +
                    "\n3 - Alterar Aluguer." +
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
                    if (automoveis.isEmpty() || clientes.isEmpty()) {
                        System.out.println("Não há automóveis ou clientes para realizar o aluguer.\n");
                        return;
                    }

                    System.out.println("Escolha um automóvel:");
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel a = automoveis.get(i);
                        System.out.println((i + 1) + " - " + a.getMarca() + " " + a.getModelo() + " (" + a.getMatricula() + ")\n- Ano: " + a.getAnoAquisicao() + ";\n- Cilindrada: " + a.getCilindrada() + ";\n- Valor: " + a.getValorDia() + "€ p/Dia.");
                        System.out.println();
                    }

                    System.out.print("\nIndica o Id: ");
                    int escolhaAutomovel = entrada.nextInt() - 1;
                    if (escolhaAutomovel < 0 || escolhaAutomovel >= automoveis.size()) {
                        System.out.println("Escolha inválida.\n");
                        return;
                    }

                    Automovel automovelEscolhido = automoveis.get(escolhaAutomovel);

                    System.out.println("\nEscolha um cliente:");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.println((i + 1) + " - " + c.getNome() + " (CC: " + c.getCc() + ")\n- Carta Nº: " + c.getCartaConducao() + ";\n- Morada: " + c.getMorada() + ".");
                        System.out.println();
                    }

                    System.out.print("\nIndica o Id: ");
                    int escolhaCliente = entrada.nextInt() - 1;
                    if (escolhaCliente < 0 || escolhaCliente >= clientes.size()) {
                        System.out.println("Escolha inválida.\n");
                        return;
                    }

                    Cliente clienteEscolhido = clientes.get(escolhaCliente);

                    System.out.print("\nData de início (formato yyyy-MM-dd): ");
                    String dataInicioStr = entrada.next();
                    System.out.print("Data de fim (formato yyyy-MM-dd): ");
                    String dataFimStr = entrada.next();

                    try {
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        Date dataInicio = formato.parse(dataInicioStr);
                        Date dataFim = formato.parse(dataFimStr);

                        // Validar se a data de início é anterior à data de fim
                        if (dataInicio.after(dataFim)) {
                            System.out.println("\nErro: A data de início deve ser anterior à data de fim.\n");
                            return;
                        }

                        // Verificar disponibilidade do automóvel
                        if (!automovelEscolhido.estaDisponivel(dataInicio, dataFim)) {
                            System.out.println("\nAutomóvel indisponível nas datas selecionadas.\n");
                            return;
                        }

                        // Criar o aluguer
                        Aluguer aluguer = new Aluguer(automovelEscolhido, clienteEscolhido, dataInicio, dataFim);
                        automovelEscolhido.adicionarAluguer(aluguer);

                        // Resumo do aluguer
                        System.out.println("\nResumo do aluguer:");
                        System.out.println("Automóvel: " + automovelEscolhido.getMarca() + " " + automovelEscolhido.getModelo()
                                + " (" + automovelEscolhido.getMatricula() + ")");
                        System.out.println("Cliente: " + clienteEscolhido.getNome() + " (CC: " + clienteEscolhido.getCc() + ")");
                        System.out.println("Data de início: " + dataInicioStr);
                        System.out.println("Data de fim: " + dataFimStr);
                        System.out.println("Custo total: " + aluguer.calcularCusto() + "€");
                        System.out.println("");
                    } catch (ParseException e) {
                        System.out.println("Erro ao processar as datas.\n");
                    }
                    break;

                case 2:
                    // Verificar se há automóveis com alugueres
                    boolean encontrouAlugueres = false;
                    for (Automovel automovel : automoveis) {
                        if (!automovel.getAlugueres().isEmpty()) {
                            encontrouAlugueres = true;
                            break;
                        }
                    }

                    if (!encontrouAlugueres) {
                        System.out.println("Não há alugueres registados para eliminar.\n");
                        break;
                    }

                    System.out.println("Escolha o aluguer a eliminar:");
                    int aluguerIndex = 1; // Índice para exibir alugueres
                    for (int i = 0; i < automoveis.size(); i++) {
                        Automovel automovel = automoveis.get(i);
                        for (int j = 0; j < automovel.getAlugueres().size(); j++) {
                            Aluguer aluguer = automovel.getAlugueres().get(j);

                            // Exibir informações do aluguer com um índice
                            System.out.println(aluguerIndex + " - Automóvel: " + automovel.getMarca() + " " + automovel.getModelo()
                                    + " (" + automovel.getMatricula() + ")\n  - Cliente: " + aluguer.getCliente().getNome()
                                    + "\n  - Data: " + new SimpleDateFormat("yyyy-MM-dd").format(aluguer.getDataInicio())
                                    + " até " + new SimpleDateFormat("yyyy-MM-dd").format(aluguer.getDataFim()));
                            aluguerIndex++;
                        }
                    }

                    System.out.print("\nIndica o número do aluguer que queres eliminar: ");
                    int escolhaAluguer = entrada.nextInt();

                    // Validar escolha
                    if (escolhaAluguer < 1 || escolhaAluguer >= aluguerIndex) {
                        System.out.println("Escolha inválida.\n");
                        break;
                    }

                    // Encontrar e remover o aluguer
                    aluguerIndex = 1; // Reiniciar o índice para localização
                    boolean aluguerRemovido = false;
                    for (Automovel automovel : automoveis) {
                        for (int j = 0; j < automovel.getAlugueres().size(); j++) {
                            if (aluguerIndex == escolhaAluguer) {
                                automovel.getAlugueres().remove(j); // Remover o aluguer
                                aluguerRemovido = true;
                                System.out.println("Aluguer removido com sucesso.\n");
                                break;
                            }
                            aluguerIndex++;
                        }
                        if (aluguerRemovido) break; // Sair do loop se o aluguer foi removido
                    }
                    break;

                case 3:
                    // Verificar se há alugueres registados
                    boolean encontrouAlugueresAlterar = false;
                    for (Automovel automovel : automoveis) {
                        if (!automovel.getAlugueres().isEmpty()) {
                            encontrouAlugueresAlterar = true;
                            break;
                        }
                    }

                    if (!encontrouAlugueresAlterar) {
                        System.out.println("Não há alugueres registados para alterar.\n");
                        break;
                    }

                    System.out.println("Escolha o aluguer a alterar:");
                    int aluguerIndexAlterar = 1; // Índice para exibir alugueres
                    for (Automovel automovel : automoveis) {
                        for (Aluguer aluguer : automovel.getAlugueres()) {
                            // Exibir informações do aluguer com um índice
                            System.out.println(aluguerIndexAlterar + " - Automóvel: " + automovel.getMarca() + " " + automovel.getModelo()
                                    + " (" + automovel.getMatricula() + ")\n  - Cliente: " + aluguer.getCliente().getNome()
                                    + "\n  - Data: " + new SimpleDateFormat("yyyy-MM-dd").format(aluguer.getDataInicio())
                                    + " até " + new SimpleDateFormat("yyyy-MM-dd").format(aluguer.getDataFim()));
                            aluguerIndexAlterar++;
                        }
                    }

                    System.out.print("\nIndica o número do aluguer que queres alterar: ");
                    int escolhaAluguerAlterar = entrada.nextInt();

                    // Validar escolha
                    if (escolhaAluguerAlterar < 1 || escolhaAluguerAlterar >= aluguerIndexAlterar) {
                        System.out.println("Escolha inválida.\n");
                        break;
                    }

                    // Localizar o aluguer para alteração
                    aluguerIndexAlterar = 1; // Reiniciar índice
                    Aluguer aluguerAlterar = null;
                    Automovel automovelAlterar = null;

                    for (Automovel automovel : automoveis) {
                        for (Aluguer aluguer : automovel.getAlugueres()) {
                            if (aluguerIndexAlterar == escolhaAluguerAlterar) {
                                aluguerAlterar = aluguer;
                                automovelAlterar = automovel;
                                break;
                            }
                            aluguerIndexAlterar++;
                        }
                        if (aluguerAlterar != null) break;
                    }

                    // Alterar os detalhes do aluguer
                    if (aluguerAlterar != null) {
                        System.out.println("\nAlterar os seguintes campos (pressiona Enter para manter o valor atual):");

                        // Data de início
                        System.out.print("Nova Data de Início (" + new SimpleDateFormat("yyyy-MM-dd").format(aluguerAlterar.getDataInicio()) + "): ");
                        entrada.nextLine(); // Consumir o Enter
                        String novaDataInicioStr = entrada.nextLine();
                        if (!novaDataInicioStr.isEmpty()) {
                            try {
                                Date novaDataInicio = new SimpleDateFormat("yyyy-MM-dd").parse(novaDataInicioStr);
                                if (novaDataInicio.after(aluguerAlterar.getDataFim())) {
                                    System.out.println("Erro: A data de início deve ser anterior à data de fim.\n");
                                    break;
                                }
                                if (!automovelAlterar.estaDisponivel(novaDataInicio, aluguerAlterar.getDataFim())) {
                                    System.out.println("Erro: O automóvel está indisponível nesse período.\n");
                                    break;
                                }
                                aluguerAlterar.setDataInicio(novaDataInicio);
                            } catch (ParseException e) {
                                System.out.println("Erro ao processar a nova data de início.\n");
                                break;
                            }
                        }

                        // Data de fim
                        System.out.print("Nova Data de Fim (" + new SimpleDateFormat("yyyy-MM-dd").format(aluguerAlterar.getDataFim()) + "): ");
                        String novaDataFimStr = entrada.nextLine();
                        if (!novaDataFimStr.isEmpty()) {
                            try {
                                Date novaDataFim = new SimpleDateFormat("yyyy-MM-dd").parse(novaDataFimStr);
                                if (aluguerAlterar.getDataInicio().after(novaDataFim)) {
                                    System.out.println("Erro: A data de início deve ser anterior à nova data de fim.\n");
                                    break;
                                }
                                if (!automovelAlterar.estaDisponivel(aluguerAlterar.getDataInicio(), novaDataFim)) {
                                    System.out.println("Erro: O automóvel está indisponível nesse período.\n");
                                    break;
                                }
                                aluguerAlterar.setDataFim(novaDataFim);
                            } catch (ParseException e) {
                                System.out.println("Erro ao processar a nova data de fim.\n");
                                break;
                            }
                        }

                        System.out.println("Aluguer alterado com sucesso!\n");
                    }
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
