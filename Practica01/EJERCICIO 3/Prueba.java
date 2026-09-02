import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ECUACION CUADRATICA: ax^2 + bx + c = 0");

        System.out.println("INGRESE (a):");
        int a = sc.nextInt();

        System.out.println("INGRESE (b):");
        int b = sc.nextInt();

        System.out.println("INGRESE (c):");
        int c = sc.nextInt();

        EcuacionLineal ecuacion1 = new EcuacionLineal(a, b, c);

        if (ecuacion1.getDiscriminante() > 0) {
            System.out.println("La ecuacion tiene 2 raices " + ecuacion1.getRaiz1() + " y " + ecuacion1.getRaiz2());
        } else {
            if (ecuacion1.getDiscriminante() == 0) {
                System.out.println("La ecuacion tiene 1 raiz " + ecuacion1.getRaiz1());
            } else {
                System.out.println("La ecuacion no tiene raices reales");
            }
        }

        sc.close();
    }
}