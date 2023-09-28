package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvalosTest {


    @Test
    public void testCrearHotel() {
        String[][] hotel = Avalos.crearHotel();
        assertNotNull(hotel);
        assertEquals(3, hotel.length);
        assertEquals(10, hotel[0].length);
    }

    @Test
    public void testRellenarMatriz() {
        String[][] matriz = new String[3][10];
        matriz = Avalos.rellenarMatriz(matriz);
        for (int i = 0; i < matriz[0].length; i++) {
            assertEquals(String.valueOf(i + 1), matriz[0][i]);
            assertEquals("D", matriz[1][i]);
            assertEquals("0", matriz[2][i]);
        }
    }
    @Test
    void imprimirBoleta() {
        String[][] matriz = {
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"OS", "OA", "D", "D", "OA", "OA", "OS", "D", "R", "R"},
                {"3", "2", "0", "0", "1", "4", "6", "0", "9", "10"}
        };

        int boletaValida = Avalos.imprimirBoleta(matriz, 2);
        assertEquals(90000, boletaValida);

        int boletaReservada = Avalos.imprimirBoleta(matriz, 9);
        assertEquals(0, boletaReservada);

        int boletaDisponible = Avalos.imprimirBoleta(matriz, 8);
        assertEquals(0, boletaDisponible);

        int boletaInvalida = Avalos.imprimirBoleta(matriz, 15);
        assertEquals(0, boletaInvalida);
    }

    @Test
    void calcularPrecio() {
        String[][] matriz = {
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"OS", "OA", "D", "D", "OA", "OA", "OS", "D", "R", "R"},
                {"3", "2", "0", "0", "1", "4", "6", "0", "9", "10"}
        };

        int precioOA = Avalos.calcularPrecio(matriz, 2);
        assertEquals(90000, precioOA);

        int precioD = Avalos.calcularPrecio(matriz, 3);
        assertEquals(0, precioD);

        int precioR = Avalos.calcularPrecio(matriz, 8);
        assertEquals(0, precioR);


    }

}