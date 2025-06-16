package OrdenamientoSeleccion;

public class OrdenamientoSeleccion {
    /**
     * PseudoCodigo
     * Para i desde 0 hasta n - 2:
     *     min = i
     *     Para j desde i + 1 hasta n - 1:
     *         Si arreglo[j] < arreglo[min]:
     *             min = j
     *     Intercambiar arreglo[i] con arreglo[min]
     */

    /**
     * Big O
     *  Caso        Comparaciones  Intercambios  Complejidad
     *  -------------  -------------  ------------  -----------
     * Mejor caso      n(n - 1)/2   n - 1       O(n²)
     * Peor caso       n(n - 1)/2   n - 1       O(n²)
     * Promedio caso   n(n - 1)/2   n - 1       O(n²)
     */

    public static void selectionSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[min]) {
                    min = j;
                }
            }
            // Intercambiar
            int temp = arreglo[min];
            arreglo[min] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    public static void probarSeleccion(int[] datos) {
        int[] copia = datos.clone(); // para no modificar el original

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        selectionSort(copia);

        long fin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long tiempo = fin - inicio;

        double tiempoSegundos = tiempo / 1_000_000_000.0;
        double memoriaMB = (memoriaDespues - memoriaAntes) / (1024.0 * 1024.0);

        System.out.printf("Tamaño: %,d | Tiempo: %d ns (%.6f s) | Memoria: %.2f MB\n",
                datos.length, tiempo, tiempoSegundos, memoriaMB);
    }

}
