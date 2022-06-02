package principal.Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void menu() {
        Scanner s = new Scanner(System.in);
        String respuesta;
        do {
            System.out.println("""
                    Elija una opción:
                    1 = Nota media
                    2 = Nota más alta
                    3 = Nota más baja
                    4 = Cuántos alumnos tienen una nota superior a la media
                    5 = Cuántos alumnos tienen una nota inferior a la media""");
            int opc = s.nextInt();
            switch (opc) {
                case 1:
                    System.out.println(notaMedia());
                    ;
                    break;
                case 2:
                    System.out.println(mayorNota());
                    ;
                    break;
                case 3:
                    System.out.println(menorNota());
                    ;
                    break;
                case 4:
                    System.out.println(superiorMedia());
                    ;
                    break;
                case 5:
                    System.out.println(inferiorMedia());
                    ;
                    break;
            }
            System.out.println("¿Desea volver a elegir una opción?");
            respuesta = s.next();
        } while (respuesta == "Si" || respuesta == "Sí" || respuesta == "si" || respuesta == "sí");
    }

    public static double notaMedia() {
        int[] notas = crearArray();
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        double notaMedia = suma / notas.length;
        return notaMedia;
    }

    public static int mayorNota() {
        int max = 0;
        int[] notas = crearArray();
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > max) max = notas[i];
        }
        return max;
    }

    public static int menorNota() {
        int min = 10;
        int[] notas = crearArray();
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < min) min = notas[i];
        }
        return min;
    }

    public static int superiorMedia() {
        int sup = 0;
        int[] notas = crearArray();
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > notaMedia()) sup++;
        }
        return sup;
    }

    public static int inferiorMedia() {
        int inf = 0;
        int[] notas = crearArray();
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < notaMedia()) inf++;
        }
        return inf;
    }

    public static int[] crearArray() {
        int[] notas = new int[30];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = notaAleatoria();
        }
        return notas;
    }

    public static int notaAleatoria() {
        // Se inserta un valor aleatorio entre 1 y 10 en la variable nota.
        int nota = (int) Math.round(Math.random() * 9 + 1);
        // Devolvemos la variable nota.
        return nota;
    }
}
