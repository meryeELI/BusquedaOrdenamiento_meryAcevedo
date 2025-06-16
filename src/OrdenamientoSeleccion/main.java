package OrdenamientoSeleccion;
import static OrdenamientoSeleccion.OrdenamientoSeleccion.probarSeleccion;

public class main {
    public static void main(String[] args) {
        System.out.println("== PRUEBAS ORDENAMIENTO SELECCIÓN ==");

        int[] pequeño = generarArregloAleatorio(10);
        int[] mediano = generarArregloAleatorio(1_000);
        int[] grande = generarArregloAleatorio(10_000);

        probarSeleccion(pequeño);
        probarSeleccion(mediano);
        probarSeleccion(grande);
    }

    public static int[] generarArregloAleatorio(int tam) {
        int[] arr = new int[tam];
        for (int i = 0; i < tam; i++) {
            arr[i] = (int)(Math.random() * tam);
        }
        return arr;
    }
}

/**
 * Ventajas
 * simple de implementar.
 * Hace un número mínimo de intercambios (máximo n - 1).
 *
 * Desventajas
 * Siempre tiene O(n²), incluso si el arreglo ya está ordenado.
 */
