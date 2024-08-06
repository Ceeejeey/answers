public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    
    public static LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // Method to search a key in the linked list iteratively
    public static boolean searchIterative(LinkedList list, int x) {
        Node currentNode = list.head;
        while (currentNode != null) {
            if (currentNode.data == x) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // Method to search a key in the linked list recursively
    public static boolean searchRecursive(Node node, int x) {
        if (node == null) {
            return false;
        }
        if (node.data == x) {
            return true;
        }
        return searchRecursive(node.next, x);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);

        System.out.println("Linked List:");
        printList(list);

        int key = 3;
        boolean foundIterative = searchIterative(list, key);
        System.out.println("Key " + key + " found (Iterative): " + foundIterative);

        boolean foundRecursive = searchRecursive(list.head, key);
        System.out.println("Key " + key + " found (Recursive): " + foundRecursive);

        key = 6;
        foundIterative = searchIterative(list, key);
        System.out.println("Key " + key + " found (Iterative): " + foundIterative);

        foundRecursive = searchRecursive(list.head, key);
        System.out.println("Key " + key + " found (Recursive): " + foundRecursive);
    }
}
