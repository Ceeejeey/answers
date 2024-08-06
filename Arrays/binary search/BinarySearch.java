public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;

        System.out.print("Array: ");
        printArray(array);

        // Perform Iterative Binary Search
        // ** ONI NETHNAM DELETE KARANNA
        int resultIterative = binarySearchIterative(array, target);
        System.out.println("Iterative Binary Search: Target " + target + " found at index " + resultIterative);
        //****** */


        // Perform Recursive Binary Search
        // ** ONI NETHNAM DELETE KARANNA
        int resultRecursive = binarySearchRecursive(array, target);
        System.out.println("Recursive Binary Search: Target " + target + " found at index " + resultRecursive);
        // *******
    }

    //binary search eke iterative method eka
    // ** ONI NETHNAM DELETE KARANNA
    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
    // ********

    //binary search eke recursive method eka
    // ** ONI NETHNAM DELETE KARANNA
    public static int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursiveHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchRecursiveHelper(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                return binarySearchRecursiveHelper(array, target, mid + 1, right);
            } else {
                return binarySearchRecursiveHelper(array, target, left, mid - 1);
            }
        }

        return -1;
    }
    // ********


    
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
