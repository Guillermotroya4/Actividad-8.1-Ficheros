import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Evaluacion {

public static void main (String[] args) {

ArrayList<Calificaciones> calificaciones = new ArrayList<>(); 

try {

BufferedReader br = new BufferedReader(new FileReader("calificaciones.csv"));
String linea = "";
while (linea !=null); {

linea = br.readLine();
String[] datos = linea.split(";");
String nombre = datos[0];
Double[] notas = new Double[5];
for (int i=1; i<=5; i++) {

notas[i] = Double.parseDouble(datos[i]);
}

            calificaciones.add(new Calificaciones(nombre, notas));

            }

            br.close();

            } catch (IOException ioe) {

        System.out.println("Error en fichero calificaciones.csv: " + ioe.getMessage());

        } catch (Exception e) {

            System.out.println("Error en datos" + e.getMessage());

        }

        for (Calificaciones c: calificaciones) {

            System.out.printf(c.getNombre() + " : %.2f", c.getNotaFinal());

        }

        System.out.println("Total calificaciones: " + Calificaciones.getTotalCalificaciones());
        System.out.println("Nota media: " + Calificaciones.getNotaMedia());

    }

}