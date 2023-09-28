package org.example;

public class Main {
    public static void main(String[] args) {

    }
    public static String[][] resetearHotel(String[][] matriz) {
        for (int i = 0; i < 10; i++) {
            matriz[1][i] = "D";
            matriz[2][i] = "0";
        }
        return matriz;
    }
    public static int imprimirBoleta(String[][] matriz, int habitacion) {
        int boleta = 0;
        if (habitacion > 0 && habitacion < 11) {
            boleta = calcularPrecio(matriz, habitacion);
        }
        else{
            System.out.println("Número de habitación no válido");
        }
        return boleta;
    }
    public static int calcularPrecio(String [][] matriz, int habitacion){
        int valor = 0;
        String estado = matriz[1][habitacion - 1];
        int dias = Integer.parseInt(matriz[2][habitacion - 1]);
        if (estado.equals("OA")) {
            valor = 45000 * dias;
        } else if (estado.equals("OS")) {
            valor = 30000 * dias;
        } else if (estado.equals("R")){
            System.out.println("Esta habitacion esta reservada, aún no tiene boleta");
        } else if (estado.equals("D")){
            System.out.println("Esta habitacion esta disponible, no tiene boleta");
        }
        return valor;
    }
    }



