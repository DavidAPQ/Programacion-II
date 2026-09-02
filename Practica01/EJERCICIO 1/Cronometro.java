public class Cronometro {

    // ATRIBUTOS
    private long inicia;
    private long finaliza;

    // CONSTRUCTOR
    public Cronometro() {
        inicia = System.currentTimeMillis();
    }

    // METODOS
    public long getInicia() {
        return inicia;
    }

    public long getFinaliza() {
        return finaliza;
    }

    public void inicia() {
        inicia = System.currentTimeMillis();
    }

    public void detener() {
        finaliza = System.currentTimeMillis();
    }

    public long lapsoDeTiempo() {
        return finaliza - inicia;
    }
}