public class Estadistica {

    // ATRIBUTOS
    private float[] datos;

    // CONSTRUCTOR
    public Estadistica(float[] datos) {
        this.datos = datos;
    }

    // METODOS
    public float promedio() {
        float suma = 0;
        for (int i = 0; i < 10; i++) {
            suma = suma + this.datos[i];
        }
        return suma / 10;
    }

    public float desviacion() {
        float promedio = promedio();
        float suma = 0;
        for (int i = 0; i < 10; i++) {
            suma = (float) Math.pow(this.datos[i] - promedio, 2) + suma;
        }
        return (float) Math.sqrt(suma / 9);
    }
}