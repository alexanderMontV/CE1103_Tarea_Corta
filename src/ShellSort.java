import java.util.Random;

/**
 * Clase de implementación de Shell Sort
 * Basado en las presentaciones del curso CE1103
 */
public class ShellSort {
    static int[] values;
    static int size = 1000000;
    static int times = 15; //Número de ejecuciones

    /**
     * Ejecuta las funciones para el método Shell Sort,
     * imprime en pantalla los tiempos de ejecución
     * @param args iniciales del main
     */
    public static void main(String[] args) {
        for (int t = 1; t <= times; t++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            sort(values);
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
            values[i] = rand.nextInt(1000000); // Range of random values
        }
    }

    /**
     * Ordenación con el algoritmo Shell
     */
    static void sort(int[] a) {
        int N = a.length;
        // 3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093,
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j-h]; j -= h) {
                    swap(a, j, j-h);
                }
            }
            h /= 3;
        }
    }
    /**
     * Intercambia valores de posición
     * @param a arreglo a realizar el swap
     * @param me es e índice del menor encontrado
     * @param act es el índice de donde corresponde
     */
    static void swap(int[] a,int me, int act) {
        int temp = a[me];
        a[me] = a[act];
        a[act] = temp;
    }

}
