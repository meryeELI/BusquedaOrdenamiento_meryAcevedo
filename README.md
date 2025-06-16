**Comparativa de Algoritmos de Búsqueda y Ordenamiento en Java**

* Este proyecto tiene como objetivo analizar el rendimiento (tiempo y uso de memoria) de diferentes algoritmos de búsqueda y ordenamiento en Java.

**Algoritmos usados.**

1. Búsqueda Secuencial.

PseudoCodigo.

    función BUSCAR_SECUENCIAL(arreglo, valor)

    para i desde 0 hasta longitud(arreglo) - 1 hacer
        si arreglo[i] == valor entonces
            retornar i
    fin para
    retornar -1
    fin función

2. Búsqueda Binaria

    Función BusquedaBinaria(arreglo, valor):
    inicio ← 0
    fin ← longitud(arreglo) - 1

    Mientras inicio ≤ fin:
        medio ← (inicio + fin) / 2

        Si arreglo[medio] == valor:
            Retornar medio  // valor encontrado

        Si arreglo[medio] < valor:
            inicio ← medio + 1  // buscar en la mitad derecha

        Sino:
            fin ← medio - 1  // buscar en la mitad izquierda

    Retornar -1  // valor no encontrado

* Ordenamiento

1. Ordenamiento burbuja.


     Para i desde 0 hasta n - 1:
    Para j desde 0 hasta n - i - 2:
        Si arreglo[j] > arreglo[j + 1]:
            Intercambiar arreglo[j] y arreglo[j + 1]


2. Ordenamiento Inserción.


    Para i desde 1 hasta n - 1:
    clave = arreglo[i]
    j = i - 1
    Mientras j >= 0 y arreglo[j] > clave:
        arreglo[j + 1] = arreglo[j]
        j = j - 1
    arreglo[j + 1] = clave

3. Ordenamiento Selección.
    
        Para i desde 0 hasta n - 2:
        min = i
        Para j desde i + 1 hasta n - 1:
            Si arreglo[j] < arreglo[min]:
            min = j
        Intercambiar arreglo[i] con arreglo[min]


**Análisis de Complejidad (Big O)**

| Algoritmo           | Mejor Caso        | Peor Caso  | Caso Promedio |
| ------------------- | ----------------- | ---------- | ------------- |
| Búsqueda Secuencial | O(1)              | O(n)       | O(n)          |
| Búsqueda Binaria    | O(1)              | O(log n)   | O(log n)      |
| Burbuja             | O(n)              | O(n²)      | O(n²)         |
| Inserción           | O(n)              | O(n²)      | O(n²)         |
| Selección           | O(n²)             | O(n²)      | O(n²)         |
| Arrays.sort()       | O(n log n)        | O(n log n) | O(n log n)    |
| parallelSort()      | O(n log n)        | O(n log n) | O(n log n)    |
| Collections.sort()  | O(n) a O(n log n) | O(n log n) | O(n log n)    |


**Pruebas**

Se realizaron pruebas cronometradas con distintos tamaños de datos:

 Pequeño: 10 elementos

 Mediano: 10,000 elementos

 Grande: 1,000,000 elementos

**Para cada prueba se registró:**

Tiempo de ejecución (en nanosegundos y segundos)

Memoria utilizada (en bytes en algunos casos y MB)

**Busqueda.**

nota: el ultimo es porque al final probe un metodo de las librerias de java para comparar.


| Tamaño    | Secuencial (ns)  | Binaria (ns) | Arrays.binarySearch() |
| --------- |------------------| ------------ |-----------------------|
| 10        | 4500 - 5400      | 5900 - 9200  | 5900 - 9200           |
| 10,000    | 3700 - 137100    | 5900 - 7000 | 5900 - 7000           |
| 1,000,000 | 5300 - 3,591,400 | 6600 - 24600 | 6600 - 24600          |


**Ordenamiento.**

| Tamaño | Burbuja (s) | Inserción (s) | Selección (s) |
| ------ | ----------- | ------------- | ------------- |
| 10     | 0.000018    | 0.000015      | 0.000010      |
| 1,000  | 0.003965    | 0.001948      | 0.002143      |
| 10,000 | 0.058917    | 0.021600      | 0.034333      |


**ordenamiento nativo.**
igual para comparar. 

En cuanto a rendimiento por observacion diria que es mejor la
utilizacion de algoritmos burbuja, insercion o seleccion en arreglos pequeños 
ya que las pruebas lanzaron que algoritmos de librerias java consumen
un poco mas de ram  y tiempo pero cuando el arreglo crecio fueron mas eficientes los algoritmos nativos de java :|

| Algoritmo             | 10,000 Elementos | 100,000   | 1,000,000 |
| --------------------- | ---------------- | --------- | --------- |
| Arrays.sort()         | 0.0023 s       | 0.021 s | 0.195 s |
| Arrays.parallelSort() | 0.0018 s       | 0.017 s | 0.102 s |
| Collections.sort()    | 0.0032 s       | 0.035 s | 0.430 s |


**Conclusiones**.

 * Busqueda Secuencial solo recomendable cuando los datos son muy pocos o no están ordenados.
 * Busqueda binaria para estructuras grandes siempre que estén ordenadas. Muy superior a la búsqueda secuencial.
 * Ordenamiento Burbuja para casos de estudio fue el menos eficiente.
 * Ordenamiento Insercion útil en casos específicos (datos pequeños o casi ordenados), pero no escalable.
 * poco eficiente para volúmenes grandes.
