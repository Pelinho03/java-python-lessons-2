package metodos;

import java.util.ArrayList;
import java.util.Scanner;

import rentcarlda.Cliente;

public class ListaClientes {

    // case 4
    // Listar clientes
    public static void listaClientes(Scanner entrada, ArrayList<Cliente> clientes) {
        // Verifica se a lista de clientes está vazia
        if (clientes.isEmpty()) {
            // Caso não haja clientes registados, exibe uma mensagem informativa
            System.out.println("Nenhum cliente registado.");
            return; // Termina a execução do método
        }

        // Itera pela lista de clientes
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i); // Obtém o cliente na posição atual da lista

            // Exibe as informações do cliente formatadas
            System.out.println((i + 1) + " - " + c.getNome() + " (CC: " + c.getCc() + ")" +
                    "\n - Carta Nª: " + c.getCartaConducao() +
                    "\n - Morada: " + c.getMorada());
            System.out.println(); // Linha em branco para melhorar a visualização
        }

        System.out.println(""); // Linha extra no final da lista para separação
    }
}
