package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] matriz = {
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"D", "O", "D", "OS", "O", "D", "D", "D", "D", "D"},
                {"5", "2", "7", "3", "1", "4", "6", "8", "9", "10"}
    };
    printMatriz(matriz);
    imprimirBoleta(matriz,4);
    resetearHotel(matriz);
    System.out.println("Nuevo hotel");
    printMatriz(matriz);

    }
    public static String[][] resetearHotel(String[][] matriz) {
        for (int i = 0; i < 10; i++) {
            matriz[1][i] = "D";
            matriz[2][i] = "0";
        }
        return matriz;
    }
    public static void printMatriz(String[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static int imprimirBoleta(String[][] matriz, int habitacion){
        int boleta = 0;
        if (habitacion > 0 && habitacion < 11) {
            String estado = matriz[1][habitacion - 1];
            int dias = Integer.parseInt(matriz[2][habitacion - 1]);
            if (estado.equals("OA")) {
                boleta = 45000 * dias;
            } else if (estado.equals("OS")) {
                boleta = 30000 * dias;
            }
        } else {
            System.out.println("Número de habitación no válido");
        }
        return boleta;
    }
    }


