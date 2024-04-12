
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * En este ejercicio vamos a crear una carpeta Diccionario y en ella vamos a
 * meter un archivo por cada letra del abecedario que este en el archivo
 * diccionario.txt
 * 
 * @author Guillermo Troya Albarrán
 */

public class ejercicio2 {
    public static void main(String[] args) {

        // Crear la carpeta 'Diccionario'
        File carpetaDiccionario = new File("Diccionario");
        if (!carpetaDiccionario.exists()) {
            carpetaDiccionario.mkdir();
            System.out.println("Carpeta 'Diccionario' creada con éxito.");
        } else {
            System.out.println("La carpeta 'Diccionario' ya existe.");
        }

        // Leer el archivo diccionario y crear archivos por letra del abecedario
        try (BufferedReader brDiccionario = new BufferedReader(new FileReader("terminado/diccionario.txt"))) {
            String palabra;
            ArrayList<Character> letrasProcesadas = new ArrayList<>();

            while ((palabra = brDiccionario.readLine()) != null) {
                // Obtener la primera letra de la palabra y convertirla a mayúscula
                char primeraLetra = Character.toUpperCase(palabra.charAt(0));

                // Verificar si ya se ha procesado esta letra
                if (!letrasProcesadas.contains(primeraLetra)) {
                    // Crear el archivo correspondiente para esta letra
                    File archivoLetra = new File(carpetaDiccionario, primeraLetra + ".txt");
                    if (!archivoLetra.exists()) {
                        archivoLetra.createNewFile();
                    }
                    letrasProcesadas.add(primeraLetra);
                }

                // Escribir la palabra en el archivo correspondiente
                File archivoLetra = new File(carpetaDiccionario, primeraLetra + ".txt");
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoLetra, true))) {
                    bw.write(palabra + "\n");
                }
            }
            System.out.println("Palabras del diccionario distribuidas en archivos por letra del abecedario.");

        } catch (IOException ioe) {
            System.out.println("Hubo un error durante la lectura o escritura del archivo.");

        }
    }
}