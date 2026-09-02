public class Prueba {

    public static void main(String[] args) {
        int n = 100000;
        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            numeros[i] = n - i;   // llena de forma descendente
        }

        Cronometro cronometro = new Cronometro();

        cronometro.inicia();
        ordenar(numeros);
        cronometro.detener();

        System.out.println("Tiempo: " + cronometro.lapsoDeTiempo() + " milisegundos");
    }

    // Ordenacion por seleccion
    public static void ordenar(int[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                if (lista[j] < lista[menor]) {
                    menor = j;
                }
            }
            int temp = lista[menor];
            lista[menor] = lista[i];
            lista[i] = temp;
        }
    }
}