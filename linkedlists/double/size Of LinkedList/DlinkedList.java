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

        if(head != null){
            head.prev = newNode;
        }
        
        head = newNode;
    }

    public void insertAfter(Node prev_node , int data){

        if(prev_node == null){
            System.out.println("prev node can not be null");

            return;
        }

        Node newNode = new Node(data);

        newNode.next = prev_node.next;

        prev_node.next = newNode;

        if(newNode.next != null){
            newNode.next.prev = newNode;
        }
    }

    public void insertEnd(int data){

        Node newNode = new Node(data);

        Node temp = head;

        newNode.next = null;

        if(head == null){
            head = newNode;
            return;
        }

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;

        newNode.prev = temp;

    }

    public void deleteNode(Node delNode){

        if(head == null || delNode == null){
            System.out.println("deletion is not possible");
            return;
        }

        if(head == delNode){
            head = delNode.next;
        }

        if (delNode.next != null) {
            delNode.next.prev = delNode.prev;
        }

        if(delNode.prev != null){
            delNode.prev.next = delNode.next;
        }
    }

    public void printList(Node node){
        Node last = null;

        while(node != null){
            System.out.print(node.value + " -> ");
           node = node.next;

        }
        System.out.println();
    }

    public int size() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        DlinkedList doublyList = new DlinkedList();

        doublyList.insertFront(1);
        doublyList.insertAfter(doublyList.head, 2);
        doublyList.insertEnd(3);

        doublyList.printList(doublyList.head);

        doublyList.deleteNode(doublyList.head.next.next);

        doublyList.printList(doublyList.head);

        int size = doublyList.size();
        System.out.println("Size of the doubly linked list: " + size);
    }
}
