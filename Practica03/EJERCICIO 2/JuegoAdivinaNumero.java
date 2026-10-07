import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {

    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int numero) {
        if (numero >= 0 && numero <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public void juega() {
        Scanner teclado = new Scanner(System.in);

        reiniciaPartida();
        numeroAAdivinar = (int) (Math.random() * 11);

        System.out.println("Adivina un número entre el 0 y el 10:");

        while (true) {
            int numero = teclado.nextInt();

            if (validaNumero(numero)) {
                if (numero == numeroAAdivinar) {
                    System.out.println("Acertaste!!");
                    actualizaRecord();
                    return;
                } else {
                    if (quitaVida()) {
                        if (numeroAAdivinar > numero) {
                            System.out.println("El número a adivinar es mayor. Inténtalo de nuevo:");
                        } else {
                            System.out.println("El número a adivinar es menor. Inténtalo de nuevo:");
                        }
                    } else {
                        System.out.println("Se te acabaron las vidas");
                        return;
                    }
                }
            }
        }
    }
}