package BusquedaBinaria;

import java.util.Arrays;

public class BusquedaBinaria {

    public static int buscarBinario(int[] arreglo, int valor) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arreglo[medio] == valor)
                return medio;
            else if (arreglo[medio] < valor)
                izquierda = medio + 1;
            else
                derecha = medio - 1;
        }

        return -1;
    }

    public static void pruebaBinaria(int[] datos, int valor) {
        Arrays.sort(datos); // La búsqueda binaria requiere que el arreglo esté ordenado

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        int resultado = buscarBinario(datos, valor);

        long fin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        long tiempo = fin - inicio;
        double tiempoSegundos = tiempo / 1_000_000_000.0;
        double memoriaMB = (memoriaDespues - memoriaAntes) / (1024.0 * 1024.0);

        System.out.printf("Tamaño: %,d | Valor: %d | Resultado: %d | Tiempo: %d ns (%.6f s) | Memoria: %.2f MB\n",
                datos.length, valor, resultado, tiempo, tiempoSegundos, memoriaMB);
    }

}
