import java.util.Random;

/**
 * Clase de implementación de Bubble Sort
 * Basado en las presentaciones del curso CE1103
 */
public class BubbleSort {
    static int[] values;
    static int size = 100000;
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
            bubbleSort();
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
            values[i] = rand.nextInt(100000); // Range of random values
        }
    }

    /**
     * SOrdenación con el algoritmo Bubble
     */
    static void bubbleSort() {
        int nElements = values.length;
        for (int out = nElements - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (values[in] > values[in + 1]) {
                    swap(in, in + 1);
                }
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