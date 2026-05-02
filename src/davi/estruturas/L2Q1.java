package davi.estruturas;

import java.util.Scanner;

public class L2Q1 {
    static int m; // definimos o tamanho da lista
    static int[] lista; // lista
    static int topo = -1; // topo da lista


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tamanho M inicial tem que ser definido pelo usuário
        System.out.println("Defina a capacidade máxima da lista (M)");
        m = sc.nextInt();
        lista = new int[m];
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
                    remocao(x);
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
         for(int i = 0; i < m; i++){
             if(i <= topo){
                 System.out.print(lista[i] + ", ");
             }
             else {
                 System.out.print(" NIL, ");
             }
        }
        System.out.println("]");
    }

    public static int busca(int x){ // X é o valor que quer ser buscado e M é o tamanho da lista
        for (int i = 0; i <= topo; i++){
            if(lista[i] == x){
                System.out.println("O numero "+ x + " foi encontrado na lista.");
                return i;
            }
        }
        System.out.println("O numero " + x + " Não foi encontrado na lista.");
        return -1;
    }

    public static void insercao(int x){ // X é o valor a ser inserido e M é o tamanho da lista
        if(topo + 1 == m) {
            int[] lista2 = new int[m * 2];

            for(int i = 0; i <= topo; i++){
                lista2[i] = lista[i];
            }
            lista = lista2;
            m = m * 2;
            System.out.println("A lista chegou no seu tamanho máximo, o tamanho foi aumentado para : " + m);
        }
        int j = topo;
        while(j >= 0 && lista[j] > x) {
            lista[j + 1] = lista[j];
            j = j - 1;
        }
        lista[j + 1] = x;
        topo = topo + 1;
        System.out.println("O valor: " + x + " Foi inserido!");
    }
    public static int remocao(int x){
        int aux = busca(x);
        if(aux == -1){
            System.out.println("Número não encontrado na lista.");
            return -1;
        }
        else{
            for(int i = aux; i < topo; i++){
                lista[i] = lista[i + 1];
            }
            topo--;
            System.out.println("O valor: " + x + " Foi removido!");
            return aux;
        }

    }


    }

