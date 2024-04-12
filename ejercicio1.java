package ejercicio8_1.terminado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * En este ejercicio lo que vamos hacer es generar nombres aleatorios con los
 * nombres y apellidos de unos archivos que deberemos leer
 * 
 * @author Guillermo Troya Albarrán
 */
public class ejercicio1 {
    public static void main(String[] args) {

        int n_nombres = Integer.parseInt(System.console().readLine("¿Cuántos nombres deseas generar? "));
        if (n_nombres <= 0) {
            System.out.println("Por favor, introduce un número válido de nombres a generar.");
            return;
        }
        String archivo = System.console()
                .readLine("Indica el nombre del archivo donde quieras guardar los nombres con la extensión: ");

        try (BufferedReader brNombres = new BufferedReader(new FileReader("ejercicio8_1/terminado/usa_nombres.txt"));
                BufferedReader brApellidos = new BufferedReader(new FileReader("ejercicio8_1/terminado/usa_apellidos.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            String[] nombres = brNombres.lines().toArray(String[]::new);
            String[] apellidos = brApellidos.lines().toArray(String[]::new);

            Random random = new Random();

            for (int i = 0; i < n_nombres; i++) {
                String nombreCompleto = nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];
                bw.write(nombreCompleto + "\n");
            }
            System.out.println("Nombres generados con éxito.");

            brNombres.close();
            brApellidos.close();
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Hubo un error durante la lectura o escritura del archivo.");
            ioe.printStackTrace();
        }

    }
}
