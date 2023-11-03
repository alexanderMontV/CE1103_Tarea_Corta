import java.util.Random;

/**
 * Clase de implementación de Insertion Sort
 * Basado en las presentaciones del curso CE1103
 */
public class InsertionSort {
    static int[] values;
    static int size = 1000000;
    static int times = 15; //Número de ejecuciones

    /**
     * Ejecuta las funciones para el método BubbleSort,
     * imprime en pantalla los tiempos de ejecución
     * @param args iniciales del main
     */
    public static void main(String[] args) {
        for (int t = 1; t <= times; t++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            insertionSort(values);
            long endTime = System.currentTimeMillis();

            double elapsedTimeInSeconds = (endTime - startTime) / 1000.0;
            System.out.println("Execution time in run " + t + ": " + elapsedTimeInSeconds + " seconds");
        }
    }
    /**
     * Se inicializa el arreglo con números random
     */
    static void initializeArray() {
        values = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            values[i] = rand.nextInt(1000000); // Range of random values
        }
    }

    /**
     * Ordenación con el algoritmo Insertion
     * @param a es el arreglo a ordenar (values)
     */

    static void insertionSort(int[] a) {
        int in;
        int out;
        for (out = 1; out < a.length; out++) {
            int temp = a[out];
            in = out;
            while (in > 0 && a[in-1] >= temp) {
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }



}
