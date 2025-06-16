package OrdenamientoInsercion;

public class OrdenamientoInsercion {
    /**Pseudocodigo
     * Para i desde 1 hasta n - 1:
     *     clave = arreglo[i]
     *     j = i - 1
     *     Mientras j >= 0 y arreglo[j] > clave:
     *         arreglo[j + 1] = arreglo[j]
     *         j = j - 1
     *     arreglo[j + 1] = clave
      */
    /**
     * Análisis de Complejidad (Big O)
     *  Caso       Comparaciones        Desplazamientos  Complejidad |
     *  ---------- -------------------  ---------------  -----------
     * Mejor caso  n - 1 (ya ordenado)  0                O(n)
     *  Peor caso  n(n - 1)/2           muchos           O(n²)
     *  Promedio    n² / 4               varios           O(n²)
     */


    public static void insertionSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int clave = arreglo[i];
            int j = i - 1;

            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            arreglo[j + 1] = clave;
        }
    }

    public static void probarInsercion(int[] datos) {
        int[] copia = datos.clone(); // no modificar el original

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        insertionSort(copia);

        long fin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long tiempo = fin - inicio;

        double tiempoSegundos = tiempo / 1_000_000_000.0;
        double memoriaMB = (memoriaDespues - memoriaAntes) / (1024.0 * 1024.0);

        System.out.printf("Tamaño: %,d | Tiempo: %d ns (%.6f s) | Memoria: %.2f MB\n",
                datos.length, tiempo, tiempoSegundos, memoriaMB);
    }



}
