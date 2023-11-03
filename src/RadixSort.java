import java.util.Random;

/**
 * Clase de implementación de Radix Sort
 * Basado en las presentaciones del curso CE1103
 */
public class RadixSort {

    static int[] values;
    static int size = 1000000;
    static int times = 15; //Número de ejecuciones

    /**
     * Ejecuta las funciones para el método Radix Sort,
     * imprime en pantalla los tiempos de ejecución
     * @param args iniciales del main
     */
    public static void main(String[] args) {
        for (int t = 1; t <= times; t++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            radixsort(values);
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
     * Ordenación con el algoritmo Radix
     */
    static void radixsort(int arr[])
    {
        int n=arr.length;
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
        // Do counting sort for every digit.
        // Note that instead of passing digit number,
        // exp is passed. exp is 10^i where i is current
        // digit number
        for (int exp = 1; m/exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }
    /**
     * Hace un counting para un dígito exponencial de elementos del arreglo
     *
     * @param arr Arreglo a ordenar
     * @param n   Cantidad de elementos de arreglo
     * @param exp Dígito actual
     */
    static void countSort(int arr[], int n, int exp) {
        int[] output = new int[n]; // output array
        int[] count = new int[10];
        int i;
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    /**
     * Función para obtener el maximo
     * @param arr Arreglo
     * @param n cantidad de elementos del arreglo
     * @return int max el elemento máximo
     */
    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
