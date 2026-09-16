public class Prueba {
    public static void main(String[] args) {
        MiPunto p1 = new MiPunto();          // punto (0, 0)
        MiPunto p2 = new MiPunto(10, 30.5);  // punto (10, 30.5)

        System.out.println("Punto 1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Punto 2: (" + p2.getX() + ", " + p2.getY() + ")");

        double d1 = p1.distancia(p2);
        double d2 = p1.distancia(10, 30.5);

        System.out.println("Distancia (usando MiPunto): " + d1);
        System.out.println("Distancia (usando x, y): " + d2);
    }
}