public class EcuacionLineal {

    //ATRIBUTOS
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    //CONSTRUCTOR
    public EcuacionLineal(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    //METODOS
    public boolean tieneSolucion() {
        int determinante = (this.a * this.d) - (this.b * this.c);

        if (determinante != 0) {
            return true;
        }

        return false;
    }

    public float getX() {
        int num = (this.e * this.d) - (this.b * this.f);
        int den = (this.a * this.d) - (this.b * this.c);

        return (float) num / den;
    }

    public float getY() {
        int num = (this.a * this.f) - (this.e * this.c);
        int den = (this.a * this.d) - (this.b * this.c);

        return (float) num / den;
    }
}