import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {

    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public void juega() {
        Scanner teclado = new Scanner(System.in);

        reiniciaPartida();
        numeroAAdivinar = (int) (Math.random() * 11);

        System.out.println("Adivina un número entre el 0 y el 10:");

        while (true) {
            int numero = teclado.nextInt();

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