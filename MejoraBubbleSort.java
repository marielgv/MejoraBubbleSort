import java.util.Arrays;
import java.util.Random;

public class MejoraBubbleSort {

    // 1. BUBBLE SORT TRADICIONAL (Sin optimización de índice)
    public static long[] traditionalBubbleSort(int[] array) {
        int n = array.length;
        long comparisons = 0;
        long startTime = System.nanoTime();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        return new long[]{endTime - startTime, comparisons};
    }

    // 2. BUBBLE SORT OPTIMIZADO (Marca de último intercambio)
    public static long[] optimizedBubbleSort(int[] array) {
        int n = array.length;
        long comparisons = 0;
        long startTime = System.nanoTime();
        
        while (n > 1) {
            int lastExchangeIndex = 0;
            for (int i = 1; i < n; i++) {
                comparisons++;
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    lastExchangeIndex = i;
                }
            }
            n = lastExchangeIndex; // Aquí ocurre la magia
        }
        long endTime = System.nanoTime();
        return new long[]{endTime - startTime, comparisons};
    }

    public static void main(String[] args) {
        int size = 2000; // Tamaño de la muestra
        Random rd = new Random();

        // Generar escenarios
        int[] originalRandom = new int[size];
        for (int i = 0; i < size; i++) originalRandom[i] = rd.nextInt(size);
        
        int[] originalSorted = new int[size];
        for (int i = 0; i < size; i++) originalSorted[i] = i;

        // --- PRUEBA 1: CASO ALEATORIO ---
        int[] arr1 = Arrays.copyOf(originalRandom, size);
        int[] arr2 = Arrays.copyOf(originalRandom, size);
        long[] resTradRand = traditionalBubbleSort(arr1);
        long[] resOptiRand = optimizedBubbleSort(arr2);

        // --- PRUEBA 2: CASO YA ORDENADO (Mejor Caso) ---
        int[] arr3 = Arrays.copyOf(originalSorted, size);
        int[] arr4 = Arrays.copyOf(originalSorted, size);
        long[] resTradSort = traditionalBubbleSort(arr3);
        long[] resOptiSort = optimizedBubbleSort(arr4);

        // Impresión de resultados
        System.out.println("=== COMPARATIVA DE BUBBLE SORT (N=" + size + ") ===");
        System.out.printf("%-20s | %-15s | %-15s\n", "Escenario", "Tradicional", "Optimizado");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s | Comp: %-8d | Comp: %-8d\n", "Aleatorio", resTradRand[1], resOptiRand[1]);
        System.out.printf("%-20s | %-10d ns | %-10d ns\n", " ", resTradRand[0], resOptiRand[0]);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s | Comp: %-8d | Comp: %-8d\n", "Ordenado", resTradSort[1], resOptiSort[1]);
        System.out.printf("%-20s | %-10d ns | %-10d ns\n", " ", resTradSort[0], resOptiSort[0]);
    }
}