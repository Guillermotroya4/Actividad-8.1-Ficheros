public class Calificaciones {

    private static int totalCalificaciones = 0;
    private static double notaMedia = 0.0;
    private static final double[] PONDERACION = {0.1,0.1,0.1,0.1,0.6};

    private String nombre;
    private double[] notas;
    private int notaFinal = 0;

    public Calificaciones (String nombre, Double[] notas2) {
        this.nombre = nombre;
        this.notas = notas;
        totalCalificaciones++;
        this.notaFinal=0;
        for (int i = 0; i < notas2.length; i++) {
            this.notaFinal+=notas2[i]*PONDERACION[i];
        }
        notaMedia = (notaMedia*(totalCalificaciones+1)+this.notaFinal)/totalCalificaciones;
    }

    public static int getTotalCalificaciones() {
        return totalCalificaciones;
    }

    public static double getNotaMedia() {
        return notaMedia;
    }

    public String getNombre() {
    return this.nombre;
    }

    public double getNotaFinal() {
        return this.notaFinal;
    }

}