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

    // Method to insert a new node
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

    // Method to print the LinkedList
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // Method to segregate even and odd nodes
    public static LinkedList separateEvenOdd(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            return list;
        }

        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
        Node currentNode = list.head;

        while (currentNode != null) {
            int element = currentNode.data;

            if (element % 2 == 0) {
                if (evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            currentNode = currentNode.next;
        }

        if (evenStart == null || oddStart == null) {
            return list;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;
        list.head = evenStart;

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insert(list, 17);
        list = insert(list, 15);
        list = insert(list, 8);
        list = insert(list, 12);
        list = insert(list, 10);
        list = insert(list, 5);
        list = insert(list, 4);
        list = insert(list, 1);
        list = insert(list, 7);
        list = insert(list, 6);

        System.out.println("Original Linked List:");
        printList(list);

        list = separateEvenOdd(list);

        System.out.println("Modified Linked List:");
        printList(list);
    }
}
