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

}