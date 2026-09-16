public class MiPunto {
    private double x;
    private double y;

    // Constructor sin argumentos: crea el punto (0, 0)
    public MiPunto() {
        this(0, 0);
    }

    // Constructor con coordenadas especificadas
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Distancia hasta otro punto MiPunto
    public double distancia(MiPunto otro) {
        return distancia(otro.getX(), otro.getY());
    }

    // Distancia hasta un punto con coordenadas x e y especificadas
    public double distancia(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}