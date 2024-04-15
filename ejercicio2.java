import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
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

        // Crea la carpeta Diccionario
        File carpetaDiccionario = new File("Diccionario");
        if (!carpetaDiccionario.exists()) {
            carpetaDiccionario.mkdir();
            System.out.println("La carpeta Diccionario se ha creado.");
        } else {
            System.out.println("La carpeta Diccionario ya existe.");
        }

        try (BufferedReader brDiccionario = new BufferedReader(new FileReader("ejercicio8_1/terminado/diccionario.txt"))) {
            String palabra;
            ArrayList<Character> letrasProcesadas = new ArrayList<>();

            while ((palabra = brDiccionario.readLine()) != null) {
                char primeraLetra = Character.toUpperCase(palabra.charAt(0));           //Aqui lo que haremos en convertir la primera letra en mayuscula para que nos sea mas facil para lo de meterla en los archivos

                // Verifica si ya se ha metido esa letra en su archivo correspondiente
                if (!letrasProcesadas.contains(primeraLetra)) {
                    File archivoLetra = new File(carpetaDiccionario, primeraLetra + ".txt");    // Crea el archivo para cada letra
                    if (!archivoLetra.exists()) {
                        archivoLetra.createNewFile();
                    }
                    letrasProcesadas.add(primeraLetra);
                }

                
                File archivoLetra = new File(carpetaDiccionario, primeraLetra + ".txt");
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoLetra, true))) {      //aqui metera cada letra en su carpeta donde corresponde
                    bw.write(palabra + "\n");
                }
            }
            System.out.println("Las palabras se han metido en sus archivos correspondientes.");

        } catch (IOException ioe) {
            System.out.println("Hubo un error durante la lectura o escritura del archivo.");
        }
    }
}