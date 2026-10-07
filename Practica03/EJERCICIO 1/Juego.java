public class Juego {

    protected int numeroDeVidas;
    protected int record;
    protected int vidasIniciales;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.vidasIniciales = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        numeroDeVidas = vidasIniciales;
    }

    public void actualizaRecord() {
        if (numeroDeVidas > record) {
            record = numeroDeVidas;
        }
    }

    public boolean quitaVida() {
        numeroDeVidas = numeroDeVidas - 1;
        return numeroDeVidas > 0;
    }
}