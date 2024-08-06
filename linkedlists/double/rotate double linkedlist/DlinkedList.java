public class DlinkedList {
    
    Node head;

    static class Node {
    
        int value;
        Node next;
        Node prev;

        Node(int data){
            this.value = data;
        }
    }

    public void insertFront(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }
        
        head = newNode;
    }

    public void insertAfter(Node prev_node, int data){
        if (prev_node == null) {
            System.out.println("prev node cannot be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prev_node.next;
        prev_node.next = newNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public void insertEnd(int data){
        Node newNode = new Node(data);
        Node temp = head;
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteNode(Node delNode){
        if (head == null || delNode == null) {
            System.out.println("deletion is not possible");
            return;
        }

        if (head == delNode) {
            head = delNode.next;
        }

        if (delNode.next != null) {
            delNode.next.prev = delNode.prev;
        }

        if (delNode.prev != null) {
            delNode.prev.next = delNode.next;
        }
    }

    public void printList(Node node){
        Node last = null;

        while (node != null) {
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("NULL");
    }

    // Method to rotate the list to the right by k positions
    public void rotateRight(int k) {
        if (head == null || k == 0) {
            return;
        }

        // Compute the length of the list
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // If k is greater than the length, adjust k
        k = k % length;
        if (k == 0) {
            return;
        }

        // Find the node to rotate around
        current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        // Set the new head and rewire the end nodes
        Node newHead = current.next;
        newHead.prev = null;
        current.next = null;
        
        Node tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.prev = tail;
        head = newHead;
    }

    public static void main(String[] args) {
        DlinkedList doublyList = new DlinkedList();

        doublyList.insertFront(1);
        doublyList.insertAfter(doublyList.head, 2);
        doublyList.insertEnd(3);
        doublyList.insertEnd(4);
        doublyList.insertEnd(5);

        System.out.println("Original List:");
        doublyList.printList(doublyList.head);

        int k = 2;
        doublyList.rotateRight(k);

        System.out.println("List after rotating right by " + k + " positions:");
        doublyList.printList(doublyList.head);
    }
}
