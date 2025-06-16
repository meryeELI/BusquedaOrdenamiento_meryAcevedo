package OrdenamientoBurbuja;

public class OrdenamientoBurbuja {

    /**
     *
     * Para i desde 0 hasta n - 1:
     *     Para j desde 0 hasta n - i - 2:
     *         Si arreglo[j] > arreglo[j + 1]:
     *             Intercambiar arreglo[j] y arreglo[j + 1]
     */

    public static void bubbleSort(int[] arreglo) {
        int n = arreglo.length;
        boolean bandera;

        for (int i = 0; i < n - 1; i++) {
            bandera = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    bandera = true;
                }
            }

            if (!bandera) break; // : si no hubo cambios, ya está ordenado
        }
    }

    public static void pruebaBurbuja(int[] datos) {
        int[] copia = datos.clone(); // Evitar modificar el original

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        bubbleSort(copia);

        long fin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long tiempo = fin - inicio;

        double tiempoSegundos = tiempo / 1_000_000_000.0;
        double memoriaMB = (memoriaDespues - memoriaAntes) / (1024.0 * 1024.0);

        System.out.printf("Tamaño: %,d | Tiempo: %d ns (%.6f s) | Memoria: %.2f MB\n",
                datos.length, tiempo, tiempoSegundos, memoriaMB);
    }


}
