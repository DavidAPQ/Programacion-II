public class VectorTridimensional {
    private double a1;
    private double a2;
    private double a3;

    // Constructor sin argumentos: crea el vector (0, 0, 0)
    public VectorTridimensional() {
        this(0, 0, 0);
    }

    // Constructor con las tres componentes especificadas
    public VectorTridimensional(double a1, double a2, double a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public double getA1() {
        return a1;
    }

    public double getA2() {
        return a2;
    }

    public double getA3() {
        return a3;
    }

    // a) Suma de dos vectores: c = a + b
    public VectorTridimensional sumar(VectorTridimensional b) {
        double c1 = this.a1 + b.a1;
        double c2 = this.a2 + b.a2;
        double c3 = this.a3 + b.a3;
        return new VectorTridimensional(c1, c2, c3);
    }

    // b) Multiplicación de un escalar r por un vector: b = r * a
    public VectorTridimensional multiplicarEscalar(double r) {
        double b1 = r * this.a1;
        double b2 = r * this.a2;
        double b3 = r * this.a3;
        return new VectorTridimensional(b1, b2, b3);
    }

    // c) Longitud de un vector: |a| = sqrt(a1^2 + a2^2 + a3^2)
    public double longitud() {
        return Math.sqrt(a1 * a1 + a2 * a2 + a3 * a3);
    }

    // d) Normal de un vector: b = a / |a|
    public VectorTridimensional normal() {
        double magnitud = this.longitud();
        double b1 = this.a1 / magnitud;
        double b2 = this.a2 / magnitud;
        double b3 = this.a3 / magnitud;
        return new VectorTridimensional(b1, b2, b3);
    }

    // e) Producto escalar de a y b: a . b = a1*b1 + a2*b2 + a3*b3
    public double productoEscalar(VectorTridimensional b) {
        return this.a1 * b.a1 + this.a2 * b.a2 + this.a3 * b.a3;
    }

    // f) Producto vectorial de a y b: a x b
    public VectorTridimensional productoVectorial(VectorTridimensional b) {
        double c1 = this.a2 * b.a3 - this.a3 * b.a2;
        double c2 = this.a3 * b.a1 - this.a1 * b.a3;
        double c3 = this.a1 * b.a2 - this.a2 * b.a1;
        return new VectorTridimensional(c1, c2, c3);
    }
}