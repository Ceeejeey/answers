/*
 * single linked list 
 * comment okkoma ain kranna variable names wenas kranna aniwaren
 * 
 * string out put wlata kemathi message ekak denna aniwaren
 */

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
        System.out.print("LinkedList: ");

        Node currNode = list.head;
        
        while (currNode != null) {
            
            System.out.print(currNode.data + " ");

            
            currNode = currNode.next;
        }
        System.out.println(); 
    }

    // Method to delete a node by key
    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node currNode = list.head, prev = null;

        
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; 
            System.out.println(key + " found and deleted");
            return list;
        }

        
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        } else {
            
            System.out.println(key + " not found");
        }

        return list;
    }

    

    

    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        

        System.out.println("linked list ");
        printList(list);

        

        list = deleteByKey(list, 1);
        printList(list);
        list = deleteByKey(list, 4);
        printList(list);
        list = deleteByKey(list, 10);
        printList(list);
    }
}
