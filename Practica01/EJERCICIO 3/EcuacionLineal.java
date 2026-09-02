public class EcuacionLineal {

    //ATRIBUTOS
    private int a;
    private int b;
    private int c;

    //CONSTRUCTOR
    public EcuacionLineal(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //METODOS
    public int getDiscriminante() {
        int discriminante = (this.b * this.b) - (4 * this.a * this.c);
        return discriminante;
    }

    public float getRaiz1() {
        int discriminante = getDiscriminante();

        if (discriminante < 0) {
            return 0;
        }

        float r1 = (float) ((-(this.b) + Math.sqrt(discriminante)) / (2 * this.a));
        return r1;
    }

    public float getRaiz2() {
        int discriminante = getDiscriminante();

        if (discriminante < 0) {
            return 0;
        }

        float r2 = (float) ((-(this.b) - Math.sqrt(discriminante)) / (2 * this.a));
        return r2;
    }
}