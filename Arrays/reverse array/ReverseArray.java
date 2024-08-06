public class ReverseArray {
    public static void main(String[] args) {
        // Example array to reverse
        int[] array = {1, 2, 3, 4, 5};

        // Print the original array
        System.out.print("Original Array: ");
        printArray(array);

        // Reverse the array
        reverseArray(array);

        // Print the reversed array
        System.out.print("Reversed Array: ");
        printArray(array);
    }

    // Method to reverse an array
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Swap the elements at left and right indices
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move the left index to the right and the right index to the left
            left++;
            right--;
        }
    }

    // Method to print an array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
