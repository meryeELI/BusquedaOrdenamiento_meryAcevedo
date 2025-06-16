package AlgoritmosNativosJava;

import java.util.*;

public class ComparativaAlgoritmos {

    public static void main(String[] args) {
        int[] tamaños = {10_000, 100_000, 1_000_000};
        for (int tamaño : tamaños) {
            System.out.println("== Tamaño: " + tamaño + " ==");

            int[] original = generarDatos(tamaño);//llenado lista
            int valorBuscar = original[tamaño / 2]; //Selecciona un valor aleatorio de la mitad del arreglo para buscarlo

            probarOrdenamiento("Arrays.sort", original.clone(), valorBuscar, Arrays::sort);
            probarOrdenamiento("Arrays.parallelSort", original.clone(), valorBuscar, Arrays::parallelSort);
            probarOrdenamientoLista("Collections.sort", original.clone(), valorBuscar);
            System.out.println();
        }
    }

    // Prueba con algoritmos que usan arreglos
    public static void probarOrdenamiento(String nombre, int[] datos, int valor, OrdenadorArreglo ordenador) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        ordenador.ordenar(datos);
        int resultado = Arrays.binarySearch(datos, valor);

        long fin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        mostrarResultados(nombre, fin - inicio, memoriaDespues - memoriaAntes, resultado);
    }

    // Prueba con listas (Collections.sort)
    public static void probarOrdenamientoLista(String nombre, int[] datos, int valor) {
        List<Integer> lista = new ArrayList<>();
        for (int dato : datos) lista.add(dato);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        Collections.sort(lista);
        int resultado = Collections.binarySearch(lista, valor);

        long fin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        mostrarResultados(nombre, fin - inicio, memoriaDespues - memoriaAntes, resultado);
    }

    public static void mostrarResultados(String nombre, long tiempoNs, long memoriaBytes, int resultado) {
        System.out.printf("%-20s | Resultado: %d | Tiempo: %.6f s | Memoria: %.2f MB\n",
                nombre,
                resultado,
                tiempoNs / 1_000_000_000.0,
                memoriaBytes / (1024.0 * 1024.0));
    }

    public static int[] generarDatos(int n) {
        Random rand = new Random();
        int[] datos = new int[n];
        for (int i = 0; i < n; i++) datos[i] = rand.nextInt(n * 10);
        return datos;
    }

    // Interfaz funcional para métodos de ordenamiento Esta es una interfaz funcional que me permite pasar métodos (Arrays.sort, Arrays.parallelSort) como funciones
    interface OrdenadorArreglo {
        void ordenar(int[] datos);
    }
}

