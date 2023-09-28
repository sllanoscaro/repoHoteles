package org.example;
import java.util.Objects;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class Avalos {
    public static void main(String[] args) {
        menu();

    }
    public static String[][] crearHotel() {
        return new String[3][10];
    }
    public static String[][] rellenarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz[0].length; i++) {
            matriz[0][i] = String.valueOf(i+1);
        }
        Arrays.fill(matriz[1], "D");
        Arrays.fill(matriz[2], "0");
        return matriz;
    }
    public static void consultarEstado(String[][] matriz) {
        System.out.println("Habitaciones: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int ingresarNumeroPieza() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la pieza que quiera reservar");
        int numeroPieza = sc.nextInt();
        return numeroPieza-1;
    }
    public static String ingresarEstado(){
        Scanner sc = new Scanner(System.in);
        String estado="";
        while(true) {
            System.out.println("Ingrese si quiere la habitacion reservarla (R), usarla con alimentacion(OA) o usarla sin alimentacion (OS)");
            estado = sc.next();
            if (Objects.equals(estado, "R") || Objects.equals(estado, "OA") || Objects.equals(estado, "OS")){
                break;
            }
            else{
                System.out.println("Respuesta no valida");
            }
        }
        return estado;
    }
    public static String ingresarDias(){
        String dias="0";
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dias a reservar: ");
        dias = sc.next();
        return dias;


    }
    public static String [][] hacerReserva(String[][]Piezas, int numeroPieza, String estado, String dias){
        if(verDisponibilidad(numeroPieza,Piezas)){
            Piezas[1][numeroPieza]=estado;
            Piezas[2][numeroPieza]=dias;
        }
        else if (verDisponibilidad(numeroPieza,Piezas)==false) {
            System.out.println("La pieza no esta disponible");
        }
        return Piezas;
    }

    public static boolean verDisponibilidad(int habitacion,String[][]Piezas){
        boolean condicion;
        if (Piezas[1][habitacion]=="D"){
            condicion=true;
        }
        else {
            condicion=false;
        }
        return condicion;
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
            matriz[1][habitacion-1]="D";
            matriz[2][habitacion-1]="0";
        }
        else{
            System.out.println("Número de habitación no válido");
        }
        return boleta;
    }
    public static int ingresarNumeroPiezaParaBoleta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la pieza que quiera pagar");
        int numeroPieza = sc.nextInt();
        return numeroPieza;
    }
    public static int calcularPrecio(String [][] matriz, int habitacion){
        int valor = 0;
        String estado = matriz[1][habitacion-1];
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
    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        String[][] matriz = crearHotel();
        rellenarMatriz(matriz);

        do {
            opcionesAdmin();
            try {
                opcion = entrada.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("El parámetro de entrada debe ser un número, intente de nuevo.\n");
                throw e;
            }

            switch (opcion) {
                case 1:
                    consultarEstado(matriz);
                    break;
                case 2:
                    hacerReserva(matriz,ingresarNumeroPieza(),ingresarEstado(), ingresarDias());
                    break;
                case 3:
                    System.out.println(imprimirBoleta(matriz,ingresarNumeroPiezaParaBoleta()));;
                    break;
                case 4:
                    resetearHotel(matriz);
                    break;
                case 5:
                    System.out.print("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }  while (opcion != 5);
        entrada.close();
    }

    public static void opcionesAdmin() {
        System.out.println("Menu administrador:");
        System.out.println("1. Ver habitaciones disponibles.");
        System.out.println("2. Reservar una habitación.");
        System.out.println("3. Pagar habitación y desocupar.");
        System.out.println("4. Reiniciar hotel.");
        System.out.println("5. Salir.");
        System.out.print("Elija una opción: ");
    }

}