package BusquedaSecuencial;

public class BusquedaSecuencial
{

    /**
     *función BUSCAR_SECUENCIAL(arreglo, valor)
     *     para i desde 0 hasta longitud(arreglo) - 1 hacer
     *         si arreglo[i] == valor entonces
     *             retornar i
     *     fin para
     *     retornar -1
     * fin función
     *
     */
    public static int buscar(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return i; // Encontrado return rompe el bucle
            }
        }
        return -1; // No encontrado
    }
    public static void benchmark(int tamaño, int valorABuscar, boolean existe) {
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = i;
        }

        if (!existe) {
            valorABuscar = -1; // Valor que no existe en el arreglo
        }

        long inicio = System.nanoTime();
        int resultado = buscar(arreglo, valorABuscar);
        long fin = System.nanoTime();

        System.out.println("Tamaño del arreglo: " + tamaño);
        System.out.println("Valor buscado: " + valorABuscar);
        System.out.println("Resultado: " + resultado);
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ns");
        System.out.println("-------------------------------");
    }
    public static void pruebaConCronometro(int[] datos, int valor) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); //  ayuda a liberar memoria antes de medir

        long memoriaUsada = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();
        int resultado = buscar(datos, valor);
        long fin = System.nanoTime();
        System.out.printf("Tamaño: %,d | Valor: %d | Resultado: %d | Tiempo: %d  ns| Memoria:  %.2f  | o en bytes: %d MB \n",
                datos.length, valor, resultado, (fin - inicio),  (memoriaUsada/(1024.0 * 1024.0)), memoriaUsada);
    }

}
