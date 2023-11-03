import java.util.Random;

/**
 * Clase de implementación de Quick Sort
 * Basado en las presentaciones del curso CE1103
 */
public class QuickSort {
    private static int[] numbers;
    private static int number;
    static int[] values;
    static int size = 1000000;
    static int times = 15; //Número de ejecuciones

    /**
     * Ejecuta las funciones para el método Quick Sort,
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
     * Ordenación con el algoritmo Sort
     * @param values el arreglo a ser ordenado
     */
    public static void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }
    /**
     * Ordenación de un sub arreglo.
     * Es una función recursiva.
     * @param low el índice menor.
     * @param high el índice mayor
     */
    private static void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high - low) / 2];
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(numbers,i,j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);

    }

    /**
     * Intercambia valores de posición
     * @param a arreglo a realizar el swap
     * @param me es e índice del menor encontrado
     * @param act es el índice de donde corresponde
     */
    static void swap(int[] a,int me, int act) {
        int temp = numbers[me];
        numbers[me] = numbers[act];
        numbers[act] = temp;
    }
}
