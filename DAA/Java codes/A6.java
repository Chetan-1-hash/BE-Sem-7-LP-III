import java.util.Random;

public class A6 {
    public static void main(String[] args) {
        int[] array = {6,3,9,5,2,8};
        int[] copyArray = array.clone();

        long startTime, endTime;

        // Quick Sort using Deterministic Pivot
        startTime = System.nanoTime();
        quickSortDeterministic(copyArray, 0, copyArray.length - 1);
        endTime = System.nanoTime();
        long deterministicTime = endTime - startTime;

        // Reset the array for randomized Quick Sort
        copyArray = array.clone();

        // Quick Sort using Randomized Pivot
        startTime = System.nanoTime();
        quickSortRandomized(copyArray, 0, copyArray.length - 1);
        endTime = System.nanoTime();
        long randomizedTime = endTime - startTime;

        // Print the number of comparisons and execution times
        System.out.println("Deterministic Quick Sort:");
        System.out.println("Comparisons: " + quickSortDeterministicComparisons);
        System.out.println("Execution Time: " + deterministicTime + " ns\n");

        System.out.println("Randomized Quick Sort:");
        System.out.println("Comparisons: " + quickSortRandomizedComparisons);
        System.out.println("Execution Time: " + randomizedTime + " ns");
    }
    
    
    
    

    // Deterministic Quick Sort
    static long quickSortDeterministicComparisons = 0;

    public static void quickSortDeterministic(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionDeterministic(arr, low, high);
            quickSortDeterministic(arr, low, pivot - 1);
            quickSortDeterministic(arr, pivot + 1, high);
        }
    }

    public static int partitionDeterministic(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
            quickSortDeterministicComparisons++;
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Randomized Quick Sort
    static long quickSortRandomizedComparisons = 0;

    public static void quickSortRandomized(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionRandomized(arr, low, high);
            quickSortRandomized(arr, low, pivot - 1);
            quickSortRandomized(arr, pivot + 1, high);
        }
    }

    public static int partitionRandomized(int[] arr, int low, int high) {
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);
        return partitionDeterministic(arr, low, high);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
}
