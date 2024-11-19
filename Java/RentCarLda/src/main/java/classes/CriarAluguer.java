package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import rentcarlda.Aluguer;
import rentcarlda.Automovel;
import rentcarlda.Cliente;

public class CriarAluguer {
    //case 5
    // Criar aluguer

    public static void criarAluguer(Scanner entrada, ArrayList<Automovel> automoveis, ArrayList<Cliente> clientes) {
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
