package davi.estruturas;

import java.util.Scanner;

public class L2Q2 {
    static int m; // tamanho da lista
    static int[] lista; // estrutura
    static int totalchamadas = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Defina a capacidade máxima da lista (M)");
        m = sc.nextInt();
        lista = new int[m];
        System.out.println("Preencha a lista com " + m + " elementos:");
        for(int i = 0; i < m; i++){
            lista[i] = sc.nextInt();
        }
        System.out.print("Vetor original: ");
        impressao();
        mergesort(0, m - 1);
        System.out.println("Total de chamadas ao mergesort: " + totalchamadas);
        sc.close();



    }
    public static void mergesort(int inicio, int fim){
        totalchamadas++;
        System.out.println("mergesort " + inicio + " " + fim + ": empilhado!");
        if(inicio < fim){
            int meio = (fim + inicio)/2;
            mergesort(inicio, meio);
            mergesort(meio + 1, fim);
            merge(inicio, meio, fim);
        }
        System.out.println("mergesort " + inicio + " " + fim + ": dsempilhado!");
    }
    public static void merge(int inicio, int meio, int fim){
        System.out.println("merge " + inicio + " " + meio + " " + fim);

        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1 + 1];
        int[] direita = new int[n2 + 1];

        for( int i = 0; i < n1; i++){
           esquerda[i] = lista[inicio + i];
        }
        for(int j = 0; j < n2; j++){
            direita[j] = lista[meio + 1 + j];
        }

        esquerda[n1] = Integer.MAX_VALUE;
        direita[n2] = Integer.MAX_VALUE;

        int topo_esquerda = 0;
        int topo_direita = 0;

        for(int k = inicio; k <= fim; k++){
            if (esquerda[topo_esquerda] <= direita[topo_direita]){
                lista[k] = esquerda[topo_esquerda];
                topo_esquerda = topo_esquerda + 1;
            }
            else{
                lista[k] = direita[topo_direita];
                topo_direita = topo_direita + 1;
            }
        }
        impressao();
    }
    public static void impressao(){
        System.out.print("[");
        for(int i = 0; i < m; i++) {
            System.out.print(lista[i] + ",");
        }
        System.out.println("]");
    }


}
