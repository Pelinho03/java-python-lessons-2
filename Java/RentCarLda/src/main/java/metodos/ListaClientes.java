package metodos;

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
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println((i + 1) + "- " + c.getNome() + " (CC: " + c.getCc() + ")" +
                    "\n - Carta Nª: " + c.getCartaConducao() +
                    "\n - Morada: " + c.getMorada());
            System.out.println();
        }
        System.out.println("");
    }
}
