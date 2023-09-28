import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TallerHotel {
    public static void main(String[] args) {
        menu();
    }

    public static String[][] crearHotel() {
        return new String[3][10];
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

    public static String[][] rellenarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz[0].length; i++) {
            matriz[0][i] = String.valueOf(i+1);
        }
        Arrays.fill(matriz[1], "D");
        Arrays.fill(matriz[2], "0");
        return matriz;
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.print("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }  while (opcion != 6);
        entrada.close();
    }

    public static void opcionesAdmin() {
        System.out.println("Menu administrador:");
        System.out.println("1. Ver habitaciones disponibles.");
        System.out.println("2. Reservar una habitación.");
        System.out.println("3. Ocupar una habitación.");
        System.out.println("4. Desocupar habitación.");
        System.out.println("5. Reiniciar hotel.");
        System.out.println("6. Salir.");
        System.out.print("Elija una opción: ");
    }

}