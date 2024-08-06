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

    // Method to insert a new node at the end of the list
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

    // Method to print the linked list
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // Method to remove duplicates from a sorted linked list
    public static void removeDuplicates(LinkedList list) {
        Node current = list.head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = insert(list, 11);
        list = insert(list, 11);
        list = insert(list, 11);
        list = insert(list, 21);
        list = insert(list, 43);
        list = insert(list, 43);
        list = insert(list, 60);

        System.out.println("Original Linked List:");
        printList(list);

        removeDuplicates(list);

        System.out.println("Linked List after removing duplicates:");
        printList(list);
    }
}
