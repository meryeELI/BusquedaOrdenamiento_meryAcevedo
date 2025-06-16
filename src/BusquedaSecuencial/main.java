package BusquedaSecuencial;

public class main {

    public static void main(String[] args) {

        /**
         *  pruebas con arreglos de enteros de diferentes tamaños para determinar el
         *  tiempo de ejecucion y uso de memoria ram en el procesamiento.
         *  Pequeño	Arreglo con 10 elementos
         *  Mediano	Arreglo con 10,000 elementos
         *  Grande	Arreglo con 1,000,000 elementos
         */

        int[] pequeno = new int[10];
        int[] mediano = new int[10_000];
        int[] grande = new int[1_000_000];

        for (int i = 0; i < grande.length; i++) {
            if (i < pequeno.length) pequeno[i] = i;
            if (i < mediano.length) mediano[i] = i;
            grande[i] = i;
        }

        System.out.println("== PRUEBAS PEQUEÑO ==");
        BusquedaSecuencial.pruebaConCronometro(pequeno, 0);        // mejor caso
        BusquedaSecuencial.pruebaConCronometro(pequeno, 5);        // promedio
        BusquedaSecuencial.pruebaConCronometro(pequeno, 9);        // peor caso

        System.out.println("== PRUEBAS MEDIANO ==");
        BusquedaSecuencial.pruebaConCronometro(mediano, 0);
        BusquedaSecuencial.pruebaConCronometro(mediano, 5000);
        BusquedaSecuencial.pruebaConCronometro(mediano, 9999);

        System.out.println("== PRUEBAS GRANDE ==");
        BusquedaSecuencial.pruebaConCronometro(grande, 0);
        BusquedaSecuencial.pruebaConCronometro(grande, 500_000);
        BusquedaSecuencial.pruebaConCronometro(grande, 999_999);
        BusquedaSecuencial.pruebaConCronometro(grande, -1); // valor no existente

        /**
         * en base a los resultados he determinado:
         *  Caso             Complejidad | Justificación
         * ----------------- ----------- | ------------------------------------------------------------------------------------------------------
         *  Mejor caso       O(1)         El valor se encuentra en la primera posición. Solo una comparación.
         *  Peor caso        O(n)         El valor está al final o no existe. Se comparan todos los elementos.
         *  Caso promedio    O(n)         El valor está, en promedio, en el medio. Se comparan aproximadamente n/2 elementos. Redondeado a O(n).
         *
         *Resultados
         * Tamaño pequeño (10 elementos)
         *Posición buscada | Tiempo (ns) | Memoria usada (MB)
         * ---------------- | ----------- | ------------------
         *  Inicio (0)       | 4500        | 6.40
         *  Medio (5)        | 5400        | 5.71
         *  Final (9)        | 4900        | 5.71
         *  Observaciones:
         *  Muy bajo tiempo de respuesta.
         * Variación mínima.
         * Memoria estable.
         * Tamaño mediano (10,000 elementos)
         *  Posición buscada | Tiempo (ns) | Memoria usada (MB)
         *  ---------------- | ----------- | ------------------
         *  Inicio (0)       | 3700        | 5.71
         *  Medio (5000)     | 103900      | 5.71
         * Final (9999)     | 137100      | 5.71
         * Observaciones:
         * El tiempo crece linealmente con la posición del valor.
         * El tiempo inicial sigue siendo muy rápido.
         * Memoria constante solo varia en bytes
         *
         * Tamaño grande (1,000,000 elementos)
         *  Posición buscada | Tiempo (ns) | Memoria usada (MB)
         * ---------------- | ----------- | ------------------
         *  Inicio (0)       | 5300        | 5.67
         *  Medio (500,000)  | 1,787,600   | 5.67
         *  Final (999,999)  | 1,216,400   | 5.67
         *  No encontrado    | 3,591,400   | 5.67
         *  Observaciones.
         *  El peor caso (no encontrado) es el más costoso en terminos de tiempo.
         * A pesar del gran tamaño, la memoria usada no cambia mucho (esto es porque la JVM administra memoria en bloques :O).
         * Confirma el comportamiento O(n) del algoritmo.
         *
         *
         * */

        /**
         * Conclusiones
         * La búsqueda secuencial es muy eficiente en arreglos pequeños o cuando el valor buscado está al inicio.
         * En casos grandes, su tiempo de respuesta aumenta proporcionalmente con la posición del valor
         * La memoria utilizada se mantuvo bastante estable porque el tamaño del arreglo es lo único que influye directamente en el consumo
         */
    }
}
