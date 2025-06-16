package OrdenamientoInsercion;

import static OrdenamientoInsercion.OrdenamientoInsercion.probarInsercion;

public class main {
    public static void main(String[] args) {
        System.out.println("== PRUEBAS ORDENAMIENTO INSERCIÓN ==");

        int[] pequeño = generarArregloAleatorio(10);
        int[] mediano = generarArregloAleatorio(1_000);
        int[] grande = generarArregloAleatorio(10_000);

        probarInsercion(pequeño);
        probarInsercion(mediano);
        probarInsercion(grande);
    }
    public static int[] generarArregloAleatorio(int tam) {
        int[] arr = new int[tam];
        for (int i = 0; i < tam; i++) {
            arr[i] = (int)(Math.random() * tam);
        }
        return arr;
    }
}
