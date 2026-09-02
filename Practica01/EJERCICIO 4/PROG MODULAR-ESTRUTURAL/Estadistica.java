import java.util.Scanner;

// PROGRAMACION MODULAR
public class Estadistica{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ESTADISTICA: PROMEDIO Y DESVIACION ESTANDAR");

        float[] datos = new float[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("INGRESE EL VALOR " + (i + 1));
            datos[i] = sc.nextFloat();
        }

        System.out.println("PROMEDIO: " + promedio(datos));
        System.out.println("DESVIACION: " + desviacion(datos));
        sc.close();
    }

    // METODOS
    private static float promedio(float[] datos) {
        float suma = 0;
        for (int i = 0; i < 10; i++) {
            suma = suma + datos[i];
        }
        return suma / 10;
    }

    private static float desviacion(float[] datos) {
        float suma = 0;
        for (int i = 0; i < 10; i++) {
            suma = (float) Math.pow(datos[i] - promedio(datos), 2) + suma;
        }
        return (float) Math.sqrt(suma / 9);
    }
}