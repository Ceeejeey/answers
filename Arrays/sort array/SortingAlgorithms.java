public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};

        System.out.print("Original Array: ");
        printArray(array);

        // Perform Insertion Sort
        insertionSort(array);
        System.out.print("Array after Insertion Sort: ");
        printArray(array);

        // Resetting the array for the next sort
        array = new int[]{5, 2, 9, 1, 5, 6};

        // Perform Bubble Sort
        bubbleSort(array);
        System.out.print("Array after Bubble Sort: ");
        printArray(array);

        // Resetting the array for the next sort
        array = new int[]{5, 2, 9, 1, 5, 6};

        // Perform Selection Sort
        selectionSort(array);
        System.out.print("Array after Selection Sort: ");
        printArray(array);
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
