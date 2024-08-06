/*
 * ANIWAREN COMMENT OKKOMA MAKANNA 
 * KEMATHI WIDIYATA VARIABLE NAME WENAS KRANNA ANIWAREN
 * 
 * OUTPUT WALATA DENA STRING MESSAGES WENAS KRANNA ANIWAREN
 * ALUTHIN PRINTLINE EHEMA DILA SAMPURNA OUTPUT EKA EN WDIYA FORMAT KRAGANNA
 * 
 */


public class Stack {

    private int arr[];
    private int top;
    private int capacity;

    Stack(int size) {

        this.arr = new int[size];
        this.top = -1;
        this.capacity = size;

    }

    public void push(int x) {

        if (isFull()) {
            System.out.println("\nStack overflow");

            System.exit(1);
        }

        
        arr[++top] = x;
    }

    public int pop() {

        if (isEmpty()) {
            System.out.println("\nStack is empty");

            System.exit(1);
        }

        

        return arr[top--];
    }

    public int getSize() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    // me method eken stack eka ascending order ekata sort karanawa (insertion sort eken)
    // **ONI NETHNAM DELETE KARANNA**
    public void sortAescending() {
        int key;

        for (int j = 0; j <= top; j++) {
            key = arr[j];
            int i = j - 1;

            while (i > -1 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }

            arr[i + 1] = key;

        }
    }
    //******* */

    // me method eken stack eka descending order ekata sort karanawa 
    // **ONI NETHNAM DELETE KARANNA**
    public void sortDescending() {
        int key;

        for (int j = 0; j <= top; j++) {
            key = arr[j];
            int i = j - 1;

            while (i > -1 && arr[i] < key) {
                arr[i + 1] = arr[i];
                i--;
            }

            arr[i + 1] = key;

        }
    }
    //********** */


    // me tiyenne stack eka palindrome ekakda nedda kiyala hoyana method eka 
    // **ONI NETHNAM DELETE KARANNA**
    public static boolean isPalindrome(Stack stack) {
        int size = stack.getSize();
        int[] original = new int[size];
        int[] reversed = new int[size];
        Stack tempStack = new Stack(size);

        
        for (int i = 0; i < size; i++) {
            int value = stack.pop();
            original[i] = value;
            reversed[size - 1 - i] = value;
            tempStack.push(value);
        }

        
        for (int i = size - 1; i >= 0; i--) {
            stack.push(tempStack.pop());
        }

        
        for (int i = 0; i < size; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    //************* */


    public static void main(String[] args) {

        Stack stack = new Stack(7);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("Stack is: ");
        stack.printStack();

        //stack eka palindrome ekkda nedda kiyna method ekt call krnwa kemathi thenakata add karanna
        // ** ONI NETHNAM DELETE KARANNA**
        System.out.println("\nThe stack is a palindrome: " + isPalindrome(stack));
        //****** */


        //stack eka ascending order ekata sort krnwa
        System.out.println("\nSort in aescending order\n");
        stack.sortAescending();
        stack.printStack();
        System.out.println();
        //****** */

        // me tyenne descending order ekata call krala eka print krana thena 
        // ** ONI NETHNAM DELETE KARANNA**
        System.out.println("\nSort in descending order\n");
        stack.sortDescending();
        stack.printStack();
        System.out.println();
        // ****** */

        

        stack.pop();

        System.out.println("\nAfter popping out");
        stack.printStack();

    }
}