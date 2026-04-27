package davi.estruturas;

import java.util.Scanner;

public class Main {
    static int m; // definimos o tamanho da lista
    static int[] lista; // lista
    static int topo = -1; // topo da lista


    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tamanho M inicial tem que ser definido pelo usuário
        System.out.println("Defina a capacidade máxima da lista (M)");
        m = sc.nextInt();
        lista = new int[m];


        // Mensagem para o usuário
        int sair = 0;
        int x;
        while(sair != 1){
            System.out.println("Selecione alguma das opções:");
            System.out.println("1 - Adicionar um valor na lista");
            System.out.println("2 - Remover um valor na lista");
            System.out.println("3 - Buscar um valor na lista");
            System.out.println("4 - Imprimir a lista");
            System.out.println("5 - Sair\n");
            int digito = sc.nextInt();
            switch (digito){
                case 1:
                    System.out.println("Digite o número que deseja adicionar: ");
                    x = sc.nextInt();
                    insercao(x);
                    break;
                case 2:
                    System.out.println("Digite o número que deseja remover: ");
                    x = sc.nextInt();
                    remocao();
                    break;
                case 3:
                    System.out.println("Digite o número que deseja buscar: ");
                    x = sc.nextInt();
                    busca(x);
                    break;
                case 4:
                    System.out.println("Impressão da lista:");
                    impressao();
                    break;
                case 5:
                    sair = 1;
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        }



    }
    public static void impressao(){
        System.out.print("[");
         for(int i = 0; i <= m; i++){
             if(i <= topo){
                 System.out.print(lista[i] + " ");
             }
             else {
                 System.out.print(" NIL");
             }
        }
        System.out.println("]");
    }

    public static int busca(int x){ // X é o valor que quer ser buscado e M é o tamanho da lista
        for (int i = 0; i < m; i++){
            if(lista[i] == x){
                return lista[i];
            }
        }
        throw new IllegalArgumentException("O item que você buscou não está na lista!");
    }

    public static void insercao(int x){ // X é o valor a ser inserido e M é o tamanho da lista
        topo = topo + 1;
        if(topo == m) {
            int[] lista2 = new int[m * 2];
            for(int i = 0; i < m; i++){
                lista2[i] = lista[i];
            }
            lista2[m + 1] = x;
            m = m * 2;
        }
        else{
            lista[topo] = x;
        }
        insertion_sort();
    }
    public static int remocao(){
        if(topo == -1){
            throw new IllegalArgumentException("Não é possível remover um item de uma lista vazia");
        }
        int aux = lista[topo];
        topo = topo - 1;
        lista[topo + 1] = 0;
        System.out.println("Valor" + aux + "removido.");
        return aux;
    }

    public static void insertion_sort(){
        if(topo > 0){
            for (int j = 1; j < topo; j++){
                int i = j - 1;
                int chave = lista[j];
                while(i >= 0 && chave < lista[i]){
                    lista[i + 1] = lista[i];
                    i = i - 1;
                }
                lista[i + 1] = chave;
            }
        }

    }


}
