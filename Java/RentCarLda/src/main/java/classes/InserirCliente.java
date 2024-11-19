package classes;

import java.util.Scanner;
import java.util.ArrayList;
import rentcarlda.Cliente;

public class InserirCliente {

    // case 2
    // Inserir cliente
    public static void inserirCliente(Scanner entrada, ArrayList<Cliente> clientes) { // Tornar o método público e passar a lista
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

        System.out.println("Cliente inserido com sucesso!");
        System.out.println("");
    }
}
