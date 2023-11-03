import java.util.Random;
/**
 * Clase de implementación de Merge Sort
 * Basado en las presentaciones del curso CE1103
 */
public class MergeSort {

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
            mergeSort(values, 0, values.length - 1);
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
     * Ordenación con el algoritmo Selection.
     * Es un método recursivo
     * @param a    The array to be sorted.
     * @param low  The index of the low boundary.
     * @param high The index of the high boundary.
     */
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, high, mid);
        }
    }
    /**
     * Hace un merge de dos sub arreglos
     * @param a    Arrelgo a ordenar.
     * @param low  El indice inicial.
     * @param high El indice final.
     * @param mid  EL indice del elemento del centro.
     */
    static void merge(int[] a, int low, int high, int mid) {
        int i;
        int j;
        int k;
        int[] c;
        c = new int[high - low + 1];
        i = low;
        k = 0;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            c[k] = a[i];
            k++;
            i++;
        }
        while (j <= high) {
            c[k] = a[j];
            k++;
            j++;
        }
        for (i = 0; i < k; i++) {
            a[low + i] = c[i];
        }
    }

}
