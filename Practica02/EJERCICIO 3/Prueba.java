public class Prueba {
    public static void main(String[] args) {
        VectorTridimensional a = new VectorTridimensional(1, 2, 3);
        VectorTridimensional b = new VectorTridimensional(4, 5, 6);

        System.out.println("Vector a: (" + a.getA1() + ", " + a.getA2() + ", " + a.getA3() + ")");
        System.out.println("Vector b: (" + b.getA1() + ", " + b.getA2() + ", " + b.getA3() + ")");
        System.out.println();

        // a) Suma
        VectorTridimensional suma = a.sumar(b);
        System.out.println("a) Suma a + b = (" + suma.getA1() + ", " + suma.getA2() + ", " + suma.getA3() + ")");

        // b) Multiplicación por escalar
        VectorTridimensional mult = a.multiplicarEscalar(3);
        System.out.println("b) 3 * a = (" + mult.getA1() + ", " + mult.getA2() + ", " + mult.getA3() + ")");

        // c) Longitud
        double longitud = a.longitud();
        System.out.println("c) |a| = " + longitud);

        // d) Normal
        VectorTridimensional normal = a.normal();
        System.out.println("d) Normal de a = (" + normal.getA1() + ", " + normal.getA2() + ", " + normal.getA3() + ")");

        // e) Producto escalar
        double productoEscalar = a.productoEscalar(b);
        System.out.println("e) a . b = " + productoEscalar);

        // f) Producto vectorial
        VectorTridimensional productoVectorial = a.productoVectorial(b);
        System.out.println("f) a x b = (" + productoVectorial.getA1() + ", " + productoVectorial.getA2() + ", " + productoVectorial.getA3() + ")");
    }
}