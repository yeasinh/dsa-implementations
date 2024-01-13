import java.util.Arrays;

public class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            // Move the element to its left element until it reaches its correct position
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // restart after the sorted partition
            arr[j + 1] = current;
        }
    }

    // Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max-heap by converting the array into a tree
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        // Initialize largest as root
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        // If largest is not root
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, max);
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int leftWall = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                // swap arr[i] and arr[j]
                int temp = arr[leftWall];
                arr[leftWall] = arr[j];
                arr[j] = temp;

                leftWall++;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[leftWall];
        arr[leftWall] = arr[high];
        arr[high] = temp;

        return leftWall;
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr, m + 1, right, 0, n2);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Bubble Sort
        int[] bubbleSortArr = arr.clone();
        bubbleSort(bubbleSortArr);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSortArr));

        // Selection Sort
        int[] selectionSortArr = arr.clone();
        selectionSort(selectionSortArr);
        System.out.println("Selection Sort: " + Arrays.toString(selectionSortArr));

        // Insertion Sort
        int[] insertionSortArr = arr.clone();
        insertionSort(insertionSortArr);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSortArr));

        // Heap Sort
        int[] heapSortArr = arr.clone();
        heapSort(heapSortArr);
        System.out.println("Heap Sort: " + Arrays.toString(heapSortArr));

        // Quick Sort
        int[] quickSortArr = arr.clone();
        quickSort(quickSortArr, 0, quickSortArr.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickSortArr));

        // Merge Sort
        int[] mergeSortArr = arr.clone();
        mergeSort(mergeSortArr, 0, mergeSortArr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeSortArr));
    }
}
