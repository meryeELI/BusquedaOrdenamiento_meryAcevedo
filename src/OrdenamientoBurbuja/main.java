package OrdenamientoBurbuja;

import static OrdenamientoBurbuja.OrdenamientoBurbuja.pruebaBurbuja;

public class main {
    public static void main(String[] args) {
        System.out.println("== PRUEBAS ORDENAMIENTO BURBUJA ==");

        int[] pequeño = generarArregloAleatorio(10);
        int[] mediano = generarArregloAleatorio(1_000);
        int[] grande = generarArregloAleatorio(10_000); // cuidado: burbuja es lento

        pruebaBurbuja(pequeño);
        pruebaBurbuja(mediano);
        pruebaBurbuja(grande);
    }

    // Método  para crear arreglos aleatorios
    public static int[] generarArregloAleatorio(int tam) {
        int[] arr = new int[tam];
        for (int i = 0; i < tam; i++) {
            arr[i] = (int)(Math.random() * tam);
        }
        return arr;
    }

    /**
     *  Análisis de Complejidad (Big O)
     *   Caso           Comparaciones                     Intercambios  Complejidad
     * ------------- ----------------------------------  ------------  -----------
     *  Mejor caso    n-1                                 0             O(n)
     *  Peor caso     (n-1) + (n-2) + ... + 1 = n(n-1)/2  muchos        O(n²)
     *  Promedio caso  n(n-1)/2                           n(n-1)/4      O(n²)
     */

    /**
     * CONCLUSIONES.
     * En el peor caso, Bubble Sort tiene complejidad O(n²).
     * Para 10 elementos: ≈ 100 operaciones
     * Para 1,000 elementos: ≈ 1,000,000 operaciones
     * Para 10,000 elementos: ≈ 100,000,000 operaciones
     * El tiempo crece aproximadamente al cuadrado:
     *
     * Ventajas
     * Fácil de entender e implementar.
     * Puede ser eficiente si el arreglo ya está casi ordenado
     *
     * Desventajas
     * lento en arreglos medianos y grandes.
     * No recomendable para más de unos pocos miles de elementos.
     */


}
