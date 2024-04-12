package ejercicio8_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * En este ejercicio vamos a pedirle al usuario un numero y vamos a buscar en el archvio donde estan los decimales hasta el millon del pi
 * diremos si está o no en ellos
 * 
 * @author Guillermo Troya Albarrán
 */




public class ejercicio3 {
    public static void main(String[] args) {
        String numero = System.console().readLine("Ingrese un número para buscar en los primeros millones de decimales de pi: ");
        try {
            BufferedReader br = new BufferedReader(new FileReader("pi-million.txt")); 
            String pi = br.readLine();

            if (buscarNumeroEnPi(numero, pi)) {
                System.out.println("El número " + numero + " aparece en los primeros millones de decimales de pi.");
            } else {
                System.out.println("El número " + numero + " no aparece en los primeros millones de decimales de pi.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }


    /**
     * Función para buscar el número en los decimales de pi
     * @param numero
     * @param pi
     * @return
     */
    public static boolean buscarNumeroEnPi(String numero, String pi) {
        for (int i = 0; i < pi.length() - numero.length(); i++) {                       
            if (pi.substring(i, i + numero.length()).equals(numero)) {                          // Esto Verifica si el número coincide con la subcadena, recorriendo todos lo decimales  

                return true;
            }
        }
        return false;
    }
}
