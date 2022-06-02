package principal.Ejercicio1;

import javax.swing.*;
import java.util.Scanner;

public class Ejercicio1 {
    public static Scanner s = new Scanner(System.in);

    // El siguiente metodo pide al usuario que elija el número del apartado que desea lanzar.
    public static void elegirApartado() {
        int eleccion;
        // Se le pide al usuario el nº del apartado.
        System.out.println("Diga el número del apartado que desea lanzar");
        // El usuario inserta el nº del apartado que desea ejecutar.
        eleccion = s.nextInt();
        // Se ejecuta la elección y se lanza el nº elegido.
        switch (eleccion) {
            case 1:
                // Se ejecuta el primer apartado.
                arrayA();
                break;
            case 2:
                // Se ejecuta el segundo apartado.
                arrayB();
                break;
            case 3:
                arrayC();
                break;
            case 4:

                break;
            case 5:

                break;
        }
    }

    private static void arrayA() {
        // Se le pide al usuario la longitud que desea que tenga el array.
        System.out.println("Inserte una longitud:");
        // El usuario inserta una longitud.
        int longitud = s.nextInt();
        // Se crea la longitud del segundo array.
        int longitud2 = 0;
        // Se crea el array.
        int[] aleatorio = new int[longitud];
        // Se inicia un para determinando la duración de la secuencia(hasta que i sea igual a la longitud del
        // primer array).
        for (int indice = 0, i = 0; i < aleatorio.length; i++) {
            // Se inserta un número aleatorio entre 100 y 300 en la posisción i.
            aleatorio[i] = (int) Math.round(Math.random() * 200 + 100);
            // Se menciona el valor de la posición i del primer array.
            System.out.println("El valor de la pisición " + i + " del primer array es " + aleatorio[i]);
            // Se inicia un if para determinar si el valor es par.
            if (aleatorio[i] % 2 == 0) {
                // Determinamos que la longitud del segundo array aumente si el valor en la posición i
                // del primero es par.
                longitud2++;
                // Creamos el segundo array.
                int[] pares = new int[longitud2];
                // Si es par, se inserta el valor en la posición indice del segundo array.
                pares[indice] = pares[i];
                // Menciona el valor de la posición indice del segundo array.
                System.out.println("El valor de la posición " + indice + " del segundo array es " + pares[indice]);
                // Se aumenta la posición del segundo array.
                indice++;
            }
        }
    }

    public static void arrayB() {

        // Creamos un array de longitud 20.
        int[] aleatorio = new int[20];
        // Iniciamos un for para indicar la duración(hasta que i sea igual que la longitud del array).
        for (int i = 0; i < aleatorio.length; i++) {
            //Se inserta al array en la posición i un número aleatorio que no se repita.
            aleatorio[i] = comprobarNumero(i, aleatorio);
            // Se menciona el valor de la posición i del array.
            System.out.println("El valor de la posición " + (i + 1) + " del primer array es " + aleatorio[i]);
        }
    }

    public static int comprobarNumero(int posicion, int[] aleatorio) {
        boolean repetido = false;
        int contador = 0;
        int num = 0;
        // Se inicia un bucle do while.
        do {
            // Utilizamos el metodo generarAleatorio() para crear un numero aleatorio.
            num = generarAleatorio();
            // Utilizamos un bucle for para asegurar que el número aleatorio no se repita en ninguna posición.
            for (int i = 0; i <= posicion && !repetido; i++) {
                if (num == aleatorio[i]) {
                    repetido = true;
                }
            }
            // Una vez que nos aseguremos de que el número no se repite salimos del bucle.
        } while (repetido);
        // Se devuelve el número aleatorio.
        return num;
    }

    public static int generarAleatorio() {
        // Se inserta un valor aleatorio entre 100 y 300 en la variable num.
        int num = (int) Math.round(Math.random() * 200 + 100);
        // Devolvemos la variable num.
        return num;
    }

    public static void arrayC() {
        int[] aleatorio = new int[20];
        int longitud = 0;
        int[] primos = new int[longitud];
        for (int indice = 0, i = 0; i < aleatorio.length; indice++, i++) {
            aleatorio[i] = generarAleatorio();
            System.out.println("El valor de la posición " + (i + 1) + " del primer array es " + aleatorio[i]);
            for (int x = 2; x < (aleatorio[i] % 2); x++) {
                // Si no es divisible por cualquiera de estos números, es primo
                if (aleatorio[i] % x != 0) {
                    longitud++;
                    primos[indice] = aleatorio[i];
                }
                System.out.println("El valor de la posición " + (indice + 1) + " del segundo array es " + primos[indice]);
            }
        }
    }
}