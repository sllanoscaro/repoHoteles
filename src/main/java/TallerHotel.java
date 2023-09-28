import java.util.Arrays;

public class TallerHotel {
    public static void main(String[] args) {
        String[][] matriz = crearMatriz();
        rellenarMatriz(matriz);
        consultarMatriz(matriz);

    }

    public static String[][] crearMatriz() {
        return new String[3][10];
    }

    public static void consultarMatriz(String[][] matriz) {
        System.out.println("Habitaciones: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rellenarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz[0].length; i++) {
            matriz[0][i] = String.valueOf(i+1);
        }
        Arrays.fill(matriz[1], "D");
        Arrays.fill(matriz[2], "0");
    }
}
