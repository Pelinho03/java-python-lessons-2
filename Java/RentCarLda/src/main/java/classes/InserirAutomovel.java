package classes;

import java.util.Scanner;
import rentcarlda.Automovel;
import java.util.List;  // Importação necessária para List

public class InserirAutomovel {

    // Método para inserir o automóvel
    public static void inserirAutomovel(Scanner entrada, List<Automovel> automoveis) {
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

        System.out.println("\nAutomovel inserido com sucesso!");
        System.out.println("");
    }
}
