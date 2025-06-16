package BusquedaBinaria;

import static BusquedaBinaria.BusquedaBinaria.pruebaBinaria;

public class main {

    public static void main(String[] args) {
        /**
         * Complejidad temporal de Búsqueda Binaria (Big O)
         * Mejor caso	1	O(1)	El valor está justo en el medio.
         * Promedio caso	log₂(n)	O(log n)	Se divide el arreglo a la mitad cada vez.
         * Peor caso	log₂(n)	O(log n)	Se reduce el tamaño del problema por mitades.
         */
        // Pequeño
        System.out.println("== PRUEBAS BINARIA PEQUEÑO ==");
        int[] pequeño = new int[10];
        for (int i = 0; i < pequeño.length; i++) pequeño[i] = i;
        pruebaBinaria(pequeño, 0);
        pruebaBinaria(pequeño, 5);
        pruebaBinaria(pequeño, 9);

        // Mediano
        System.out.println("== PRUEBAS BINARIA MEDIANO ==");
        int[] mediano = new int[10_000];
        for (int i = 0; i < mediano.length; i++) mediano[i] = i;
        pruebaBinaria(mediano, 0);
        pruebaBinaria(mediano, 5000);
        pruebaBinaria(mediano, 9999);

        // Grande
        System.out.println("== PRUEBAS BINARIA GRANDE ==");
        int[] grande = new int[1_000_000];
        for (int i = 0; i < grande.length; i++) grande[i] = i;
        pruebaBinaria(grande, 0);
        pruebaBinaria(grande, 500000);
        pruebaBinaria(grande, 999999);
        pruebaBinaria(grande, -1); // no encontrado

        /**
         * Comparacion busqueda binaria vs secuencial
         *  Tamaño    | Tipo de búsqueda | Posición | Tiempo (ns) aprox. |
         *  --------- | ---------------- | -------- | ------------------ |
         * 10        | Secuencial       | 0–9      | 4500–5400 ns       |
         * 10        | Binaria          | 0–9      | 5900–9200 ns       |
         * 10,000    | Secuencial       | 0–9999   | 3700–137000 ns     |
         * 10,000    | Binaria          | 0–9999   | 5900–7000 ns       |
         * 1,000,000 | Secuencial       | 0–999999 | 5300–3,591,400 ns  |
         * 1,000,000 | Binaria          | 0–999999 | 6600–24,600 ns     |
         *
         * en la busqueda binaria el uso de memoria fue siempre menor a 0 MB
         * Conclusiones:
         *
         * La búsqueda binaria es mucho más rápida que la secuencial a medida que crece el arreglo.
         * y es que si bien los tiempo iniciarion similares a medida que el
         * arreglo crecio el tiempo de la busqueda secuencial crecio significativamente a
         * comparacion de la busqueda binaria.
         *
         * La búsqueda binaria crece logarítmicamente (O(log n)). Incluso con 1 millón de elementos, la diferencia de tiempo es mínima comparada con 10 mil.
         *
         * la unica desventaja a mi ver es que esta busqueda requiere de un ordenamiento previo
         */

        /**
         * Recomendaciones.
         * Usar búsqueda binaria siempre que esten los datos ordenados.
         * Usar búsqueda secuencial cuando: No se pueda ordenar los datos.
         * o el tamaño del arreglo es muy pequeño.
         */

    }
}

