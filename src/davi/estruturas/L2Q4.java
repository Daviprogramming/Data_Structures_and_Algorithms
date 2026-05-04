package davi.estruturas;

import java.util.Scanner;

public class L2Q4 {
    static int totalTrocas = 0;
    static int totalMaxHeapfy = 0;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Defina a capacidade maxima da lista (M): ");
        m = sc.nextInt();
        int[] lista = new int[m];

        System.out.println("Preencha a lista com " + m + " elementos:");
        for(int i = 0; i < m; i++) {
            lista[i] = sc.nextInt();
        }

        impressao(lista);
        heapsort(lista, m);
        System.out.println(totalTrocas);
        System.out.println(totalMaxHeapfy);

        sc.close();
    }

    public static void heapsort(int[] lista, int m){
        int tamanhoHeap = m;
        construirMaxHeap(lista, tamanhoHeap);

        impressao(lista);

        for(int i = m - 1; i > 0; i--){
            trocar(lista, 0, i);
            tamanhoHeap = tamanhoHeap - 1;
            maxHeapfy(lista, 0, tamanhoHeap);
        }
    }

    public static void maxHeapfy(int[] lista, int i, int tamanhoHeap){
        System.out.println("maxheapfy " + i);

        int l = retornarIndiceFilhoEsquerda(i);
        int r = retornarIndiceFilhoDireita(i);
        int maior = i;

        if(l < tamanhoHeap && lista[l] > lista[maior]){
            maior = l;
        }
        if(r < tamanhoHeap && lista[r] > lista[maior]){
            maior = r;
        }

        if(maior != i){
            trocar(lista, i, maior);
            totalTrocas++;
            impressao(lista);
            maxHeapfy(lista, maior, tamanhoHeap);
        } else {
            impressao(lista);
        }
    }

    public static void construirMaxHeap(int[] lista, int tamanhoHeap){
        for(int i = (tamanhoHeap / 2) - 1; i >= 0; i--){
            maxHeapfy(lista, i, tamanhoHeap);
        }
    }

    public static int retornarIndicePai(int i){
        return (i - 1) / 2;
    }
    public static int retornarIndiceFilhoEsquerda(int i){
        return (i * 2) + 1;
    }
    public static int retornarIndiceFilhoDireita(int i){
        return (i * 2) + 2;
    }

    public static void trocar(int[] lista, int i, int j){
        int aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    public static void impressao(int[] lista){
        System.out.print("[");
        for(int i = 0; i < m; i++) {
            System.out.print(lista[i] + ",");
        }
        System.out.println("]");
    }
}