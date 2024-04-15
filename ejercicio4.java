import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * En este ejercicio lo que vamos hacer es poner la ruta de un libro que queramos y el programa nos dara sus estadisticas
 * numero de lineas, numero de caracteres y palabras y tambien hara un recuento de las palabras más repetidas y daremos las 10 con más repeticiones
 * @author Guillermo Troya Albarrán
 */
public class ejercicio4 {

    public static void main(String[] args) {
        
        String nombreArchivo = "ejercicio8_1/Libros/lazarillo.txt";                     // hemos creado una variable para no tener que poner tantas veces la ruta del archivo 

        
        try {
            EstadisticasTexto estadisticas = obtenerEstadisticas(nombreArchivo);
            System.out.println("Número de líneas: " + estadisticas.getNumLineas());
            System.out.println("Número de palabras: " + estadisticas.getNumPalabras());
            System.out.println("Número de caracteres: " + estadisticas.getNumCaracteres());
            System.out.println("Las 10 palabras más comunes:");
            List<String> top10 = obtenerTop10Palabras(estadisticas.getPalabras());
            for (String palabra : top10) {
                System.out.println(palabra + ": " + estadisticas.contarPalabra(palabra));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }


    /**
     * Funcion que muestra las estadisticas
     * @param nombreArchivo
     * @return
     * @throws IOException
     */
    public static EstadisticasTexto obtenerEstadisticas(String nombreArchivo) throws IOException {
        int numLineas = 0;
        int numPalabras = 0;
        int numCaracteres = 0;
        List<String> palabras = new ArrayList<>();

        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = lector.readLine()) != null) {
            numLineas++;
            numCaracteres += linea.length();
            String[] palabrasLinea = linea.split("\\s+");
            numPalabras += palabrasLinea.length;
            palabras.addAll(Arrays.asList(palabrasLinea));
        }
        lector.close();

        return new EstadisticasTexto(numLineas, numPalabras, numCaracteres, palabras);
    }

    public static List<String> obtenerTop10Palabras(List<String> palabras) {
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();                  //he puesto el Map porque no sabia como hacerlo y lo he tenido que poner
        for (String palabra : palabras) {
            palabra = palabra.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!palabra.isEmpty()) {
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }
        }
        List<String> listaPalabras = new ArrayList<>(frecuenciaPalabras.keySet());
        listaPalabras.sort((a, b) -> frecuenciaPalabras.get(b).compareTo(frecuenciaPalabras.get(a)));
        return listaPalabras.subList(0, Math.min(10, listaPalabras.size()));
    }

    private int numLineas;
    private int numPalabras;
    private int numCaracteres;
    private List<String> palabras;

    /**
     * Aqui lo que hemos hecho es crearr un cotructor para que nos de todos los valores del libro que hayamos puesto antes
     * @param numLineas
     * @param numPalabras
     * @param numCaracteres
     * @param palabras
     */
    public ejercicio4(int numLineas, int numPalabras, int numCaracteres, List<String> palabras) {
        this.numLineas = numLineas;
        this.numPalabras = numPalabras;
        this.numCaracteres = numCaracteres;
        this.palabras = palabras;
    }

    public int getNumLineas() {
        return numLineas;
    }

    public int getNumPalabras() {
        return numPalabras;
    }

    public int getNumCaracteres() {
        return numCaracteres;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    /**
     * Esta es la funcion de contar palabras en la cual se dira cual son las más repetidas y nos dará el valor de cada una
     * @param palabra
     * @return
     */
    public int contarPalabra(String palabra) {
        int count = 0;
        for (String p : palabras) {
            if (p.equalsIgnoreCase(palabra)) {
                count++;
            }
        }
        return count;
    }
}
