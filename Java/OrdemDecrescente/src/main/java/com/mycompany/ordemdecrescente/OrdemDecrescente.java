package com.mycompany.ordemdecrescente;

import java.util.Arrays;
import java.util.Scanner;

public class OrdemDecrescente {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] valores = new int[10];

        for (int i = 0; i < valores.length; i++) {
            System.out.print("Digita o " + (i + 1) + " valor: ");
            valores[i] = entrada.nextInt();
        }
        
        
        for (int num: valores){
            System.out.print("\n"+num + " ");
        }
        Arrays.sort(valores);
        System.out.print("\n\nOrdenado e igual a: ");
        for (int num: valores){
            System.out.print(num +"  ");
        }
    

    }
}
