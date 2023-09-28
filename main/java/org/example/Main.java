package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] matriz = {
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"D", "O", "D", "O", "O", "D", "D", "D", "D", "D"},
                {"5", "2", "7", "3", "1", "4", "6", "8", "9", "10"}
    };
    imprimirBoleta(matriz);
    resetearHotel(matriz);
        System.out.println("Nuevo hotel");
    imprimirBoleta(matriz);

    }
    public static void resetearHotel(String[][] matriz) {
        for (int i = 0; i < matriz[1].length; i++) {
            matriz[1][i] = "D";
            matriz[2][i] = "0";
        }
    }
    public static void imprimirBoleta(String[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

}