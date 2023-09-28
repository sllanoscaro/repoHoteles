import org.example.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void imprimirBoleta() {
        String[][] matriz = {
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"OS", "OA", "D", "D", "OA", "OA", "OS", "D", "R", "R"},
                {"3", "2", "0", "0", "1", "4", "6", "0", "9", "10"}
        };

        int boletaValida = Main.imprimirBoleta(matriz, 2);
        assertEquals(90000, boletaValida);

        int boletaReservada = Main.imprimirBoleta(matriz, 9);
        assertEquals(0, boletaReservada);

        int boletaDisponible = Main.imprimirBoleta(matriz, 8);
        assertEquals(0, boletaDisponible);

        int boletaInvalida = Main.imprimirBoleta(matriz, 15);
        assertEquals(0, boletaInvalida);
    }

    @Test
    void calcularPrecio() {
        String[][] matriz = {
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"OS", "OA", "D", "D", "OA", "OA", "OS", "D", "R", "R"},
                {"3", "2", "0", "0", "1", "4", "6", "0", "9", "10"}
        };

        int precioOA = Main.calcularPrecio(matriz, 2);
        assertEquals(90000, precioOA);

        int precioD = Main.calcularPrecio(matriz, 3);
        assertEquals(0, precioD);

        int precioR = Main.calcularPrecio(matriz, 8);
        assertEquals(0, precioR);


    }
}
