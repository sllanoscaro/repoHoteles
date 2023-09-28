package org.example;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Avalos {
    public static void main(String[] args) {

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

}