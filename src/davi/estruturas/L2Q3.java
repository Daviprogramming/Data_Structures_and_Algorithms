package davi.estruturas;

import java.util.Scanner;

public class L2Q3 {
    static int m; // tamanho da lista
    static int[] lista; // estrutura
    static int totalTrocas = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Defina a capacidade máxima da lista (M)");
        m = sc.nextInt();
        lista = new int[m];
        System.out.println("Preencha a lista com " + m + " elementos:");
        for (int i = 0; i < m; i++) {
            lista[i] = sc.nextInt();
        }
        System.out.print("Vetor original: ");
        impressao();
        quicksort(lista, 0, m-1);
        System.out.println("Total de trocas: " + totalTrocas);
        sc.close();

    }
    public static void quicksort(int[] lista,int inicio, int fim){
        System.out.printf("quicksort %d %d: empilhado!\n", inicio, fim);
        if(inicio < fim){
            int pivo = particionar(lista, inicio, fim);
            quicksort(lista, inicio, pivo - 1);
            quicksort(lista, pivo+1, fim);
        }
        System.out.printf("quicksort %d %d: dsempilhado!\n", inicio, fim);
    }
    public static int particionar(int[] lista, int inicio, int fim){
        System.out.printf("particionar %d %d\n", inicio, fim );

        int x = lista[fim];
        int i = inicio - 1;
        for (int j = inicio; j <= fim - 1; j++){
            if(lista[j] <= x){
                i = i + 1;
                trocar(lista, i , j);
                totalTrocas = totalTrocas + 1;
            }
        }
        trocar(lista, i + 1, fim);
        totalTrocas = totalTrocas + 1;
        impressao();
        return i + 1;
    }

    public static void trocar(int[] lista,int i, int j){
        int aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }
    public static void impressao(){
        System.out.print("[");
        for(int i = 0; i < m; i++) {
            System.out.print(lista[i] + ",");
        }
        System.out.println("]");
    }
}
