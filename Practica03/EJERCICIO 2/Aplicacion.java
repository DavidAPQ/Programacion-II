public class Aplicacion {

    public static void main(String[] args) {
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);
        System.out.println("---ADIVINA EL NUMERO---");
        juego1.juega();
        System.out.println("---ADIVINA EL NUMERO PAR---");
        juego2.juega();
        System.out.println("---ADIVINA EL NUMERO IMPAR---");
        juego3.juega();
    }
}