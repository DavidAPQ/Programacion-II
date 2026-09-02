import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ESTADISTICA: PROMEDIO Y DESVIACION ESTANDAR");

        float[] datos = new float[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("INGRESE EL VALOR " + (i + 1));
            datos[i] = sc.nextFloat();
        }

        Estadistica est = new Estadistica(datos);
        System.out.println("PROMEDIO: " + est.promedio());
        System.out.println("DESVIACION: " + est.desviacion());
        sc.close();
    }
}