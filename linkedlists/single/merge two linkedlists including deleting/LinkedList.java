/*
 * single linked list1 
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
    public static LinkedList insert(LinkedList list1, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty, then make the new node as head
        if (list1.head == null) {
            list1.head = new_node;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node last = list1.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }

        return list1;
    }

    // Method to print the LinkedList
    public static void printList(LinkedList list1) {
        System.out.print("LinkedList: ");

        Node currNode = list1.head;
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
        System.out.println(); // Print a new line after printing the list1
    }

    // Method to delete a node by key
    public static LinkedList deleteByKey(LinkedList list1, int key) {
        Node currNode = list1.head, prev = null;

        // CASE 1: If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            list1.head = currNode.next; // Changed head
            System.out.println(key + " found and deleted");
            return list1;
        }

        // CASE 2: If the key is somewhere other than at head
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        // CASE 3: The key was present, it should be at currNode
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        } else {
            // CASE 4: The key was not present in the linked list1
            System.out.println(key + " not found");
        }

        return list1;
    }

    // me method eken linkedlist dekak merge karanawa (dekama eka linked list ekakta
    // danawa)
    public static LinkedList mergeLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();

        Node currentNode1 = list1.head;
        Node currentNode2 = list2.head;

        // Traverse through both lists and insert nodes into the merged list
        while (currentNode1 != null) {
            mergedList = insert(mergedList, currentNode1.data);
            currentNode1 = currentNode1.next;
        }

        while (currentNode2 != null) {
            mergedList = insert(mergedList, currentNode2.data);
            currentNode2 = currentNode2.next;
        }

        return ascendingOrder(mergedList);
    }

    // me tyenne linkedlist eka ascending order ekata hadana method eka(insertion
    // sort eken)
    // **ONI NETHNAM DELETE KARANNA METHOD EKAMA**
    public static LinkedList ascendingOrder(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            return list;
        }

        Node sortedHead = null; // The new sorted list's head
        Node currentNode = list.head;

        while (currentNode != null) {
            // Store the next node
            Node nextNode = currentNode.next;

            // Insert currentNode into the sorted list
            if (sortedHead == null || sortedHead.data >= currentNode.data) {
                currentNode.next = sortedHead;
                sortedHead = currentNode;
            } else {
                Node sortedCurrent = sortedHead;
                while (sortedCurrent.next != null && sortedCurrent.next.data < currentNode.data) {
                    sortedCurrent = sortedCurrent.next;
                }
                currentNode.next = sortedCurrent.next;
                sortedCurrent.next = currentNode;
            }

            // Move to the next node in the original list
            currentNode = nextNode;
        }

        list.head = sortedHead;

        return list;
    }
    // **********/

    // Main method to test the LinkedList implementation
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();// tawa linkedlist ekak hdanawa ehem on nethnam meka delete krala list1 eka
                                            // list kiyala denna

        list1 = insert(list1, 1);
        list1 = insert(list1, 2);
        list1 = insert(list1, 3);
        list1 = insert(list1, 4);
        list1 = insert(list1, 5);
        list1 = insert(list1, 6);
        list1 = insert(list1, 7);
        list1 = insert(list1, 8);

        // thawa linked list ekak hdanwa eka oni nethnam delete karanna me set ekama
        list2 = insert(list2, 1);
        list2 = insert(list2, 3);
        list2 = insert(list2, 4);
        list2 = insert(list2, 5);
        list2 = insert(list2, 6);
        list2 = insert(list2, 2);
        list2 = insert(list2, 7);
        list2 = insert(list2, 8);
        // ********* */

        System.out.println("1st linked list");
        printList(list1);

        System.out.println("2nd linked list");
        printList(list2);

        //meken merge karapu aluth list eka output kranawa
        //oni nethnam delete karanna
        LinkedList mergedList = mergeLists(list1, list2);
        System.out.println("Merged linked list");
        printList(mergedList);
        // *******

        list1 = deleteByKey(list1, 1);
        printList(list1);
        list1 = deleteByKey(list1, 4);
        printList(list1);
        list1 = deleteByKey(list1, 10);
        printList(list1);
    }
}
