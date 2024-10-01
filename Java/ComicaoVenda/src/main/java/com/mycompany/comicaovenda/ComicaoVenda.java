package com.mycompany.comicaovenda;

import java.util.Scanner;

public class ComicaoVenda {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int IdVendedor, IdPeca, quantidade;
        double ValorPeca, comissao = 0.05, ValorTotal;

        System.out.println("Digita o ID do vendedor: ");
        IdVendedor = entrada.nextInt();

        System.out.println("Digita o ID da peca: ");
        IdPeca = entrada.nextInt();

        System.out.println("Insere o valor da peca: ");
        ValorPeca = entrada.nextDouble();

        System.out.println("Quantidade vendida: ");
        quantidade = entrada.nextInt();

        // Calcula o valor total da comissão
        ValorTotal = (ValorPeca * quantidade) * comissao;

        // Corrigido o printf para usar a formatação correta
        System.out.printf("O vendedor de ID: %d\n", IdVendedor);
        System.out.printf("O codigo do artigo e %d\n", IdPeca);
        System.out.printf("A comissao total e de: %.2f €\n", ValorTotal);
    }
}
