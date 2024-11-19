package classes;

import java.util.ArrayList;
import java.util.Scanner;
import rentcarlda.Cliente;

public class ListaClientes {

    //case 4
    // Listar clientes
    public static void listaClientes(Scanner entrada, ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente registado.");
            return;
        }
        for (int c = 0; c < clientes.size(); c++) {
            Cliente a = clientes.get(c);
            System.out.println((c + 1) + "- " + a.getNome() + " (CC: " + a.getCc() + ")");
        }
        System.out.println("");
    }
}
