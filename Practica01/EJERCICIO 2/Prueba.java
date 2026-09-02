import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ECUACION LINEAL: ax + by = e, cx + dy = f");

        System.out.println("INGRESE a");
        int a = sc.nextInt();

        System.out.println("INGRESE b");
        int b = sc.nextInt();

        System.out.println("INGRESE c");
        int c = sc.nextInt();

        System.out.println("INGRESE d");
        int d = sc.nextInt();

        System.out.println("INGRESE e");
        int e = sc.nextInt();

        System.out.println("INGRESE f");
        int f = sc.nextInt();

        EcuacionLineal ecuacion1 = new EcuacionLineal(a, b, c, d, e, f);

        if (ecuacion1.tieneSolucion()) {
            System.out.println("X = " + ecuacion1.getX());
            System.out.println("Y = " + ecuacion1.getY());
        } else {
            System.out.println("La ecuacion no tiene solucion");
        }

        sc.close();
    }
}