import java.util.Random;

/**
 * Clase de implementación de Selection Sort
 * Basado en las presentaciones del curso CE1103
 */
public class SelectionSort {
    static int[] values;
    static int size = 100000;
    static int times = 15; //Número de ejecuciones

    /**
     * Ejecuta las funciones para el método Selection Sort,
     * imprime en pantalla los tiempos de ejecución
     * @param args iniciales del main
     */
    public static void main(String[] args) {
        for (int t = 1; t <= times; t++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            selectSort();
            long endTime = System.currentTimeMillis();

            double tiempoSegundos = (endTime - startTime) /1000.0;
            System.out.println("Ejecución N : " + t + ", tiempo en segundos: " + tiempoSegundos +" s");
        }
    }

    /**
     * Se inicializa el arreglo con números random
     */
    static void initializeArray() {
        values = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            values[i] = rand.nextInt(100000); // Range of random values
        }
    }

    /**
     *Encuentre el índice del valor más pequeño del arreglo
     * @param start El inicio del rango
     * @param end   El fin del rango
     * @return El índice del menor elemento
     */
    static int minIndex(int start, int end) {
        int indexOfMin = start;
        for (int index = start + 1; index <= end; index++) {
            if (values[index] < values[indexOfMin]) {
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }
    /**
     * Ordenación con el algoritmo Selection
     */
    static void selectSort() {
        int endIndex = size - 1;
        for (int current = 0; current < endIndex; current++) {
            int minIndex = minIndex(current, endIndex);
            if (current != minIndex) {
                swap(current, minIndex);
            }
        }
    }
    /**
     * Intercambia valores de posición
     * @param me es e índice del menor encontrado
     * @param act es el índice de donde corresponde
     */
    static void swap(int me, int act) {
        int temp = values[me];
        values[me] = values[act];
        values[act] = temp;
    }
}
