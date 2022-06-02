package principal.Ejercicio3;

import java.util.Scanner;

public class Sistema_de_Reserva_de_Vuelos {
    public static Scanner s = new Scanner(System.in);

    public static int[] avion() {
        int[] avion = new int[20];

        for (int i = 0; i < avion.length; i++) {
            avion[i] = Aleatorio();
        }
        return avion;
    }

    public static int Aleatorio() {
        // Se inserta un valor aleatorio entre 0 y 1 en la variable num.
        int num = (int) Math.round(Math.random() * 1);
        // Devolvemos la variable nota.
        return num;
    }

    public static int reservarAsiento() {
        int asiento;
        do {
            System.out.println("Inserte el asiento que desea reservar\n" +
                    "Zona de no fumadores: Asientos 1-16\n" +
                    "Zona de fumadores: Asientos 17-20");
            asiento = s.nextInt();
        } while (asiento < 1 || asiento > 20);
        if (asiento > 16) {
            zonaFumadores(asiento);
        } else zonaNoFomadores(asiento);
        return asiento;
    }

    public static void zonaFumadores(int asiento) {
        int[] avion = avion();
        int contador = 0;
        if (avion[asiento - 1] == 0) {
            System.out.println("Su asiento está disponible, disfrute del vuelo");
        } else {
            System.out.println("El asiento está ocupado");
            for (int i = 16; i < avion.length; i++) {
                System.out.println("Asiento " + (i + 1) + " " + avion[i]);
                if (avion[i] == 0) {
                    System.out.println("El asiento " + (i + 1) + " está disponible");
                } else contador++;
            }
            if (contador == 4) {
                System.out.println("No hay ningún asiento disponible en esta zona\n" +
                        "¿Desea elegir un asiento de la zona de no fumadores(17-20)?");
            }
            String respuesta = s.next();
            if (respuesta == "Si" || respuesta == "Sí" || respuesta == "si" || respuesta == "sí") {
                zonaNoFomadores(asiento);
            } else {
                int horas = proximoVuelo();
                System.out.println("El proximo vuelo sale en " + horas + " horas");
            }
        }
    }

    public static void zonaNoFomadores(int asiento) {
        int[] avion = avion();
        int contador = 0;
        if (avion[asiento - 1] == 0) {
            System.out.println("Su asiento está disponible, disfrute del vuelo");
        } else {
            System.out.println("El asiento está ocupado");
            for (int i = 0; i < 16; i++) {
                System.out.println("Asiento " + (i + 1) + " " + avion[i]);
                if (avion[i] == 0) {
                    System.out.println("El asiento " + (i + 1) + " está disponible");
                } else contador++;
            }
            if (contador == 16) {
                System.out.println("No hay ningún asiento disponible en esta zona\n" +
                        "¿Desea elegir un asiento de la zona de no fumadores(1-16)?");
            }
            String respuesta = s.next();
            if (respuesta == "Si" || respuesta == "Sí" || respuesta == "si" || respuesta == "sí") {
                zonaNoFomadores(asiento);
            } else {
                int horas = proximoVuelo();
                System.out.println("El proximo vuelo sale en " + horas + " horas");
            }
        }
    }
    public static int proximoVuelo() {
        // Se inserta un valor aleatorio entre 1 y 24 en la variable num.
        int horas = (int) Math.round(Math.random() * 23 + 1);
        // Devolvemos la variable num.
        return horas;
    }
}