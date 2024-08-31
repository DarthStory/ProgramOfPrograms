package SortAlgorithms;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = (low + 1);

        for (int j = low + 1; j <= high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] < pivot) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // Place the pivot in the correct position
        int temp = arr[low];
        arr[low] = arr[i - 1];
        arr[i - 1] = temp;

        return i - 1; // Return the partition index
    }
}