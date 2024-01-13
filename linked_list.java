public class SinglyLinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Insert an element at the end of the linked list
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } 
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Delete a node with the given value from the linked list
    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Display the linked list
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    // Find the smallest element in the linked list
    public int findSmallest() {
        if (head == null) {
            throw new IllegalStateException("Linked list is empty");
        }

        int smallest = head.data;
        Node current = head;
        while (current != null) {
            if (current.data < smallest) {
                smallest = current.data;
            }
            current = current.next;
        }

        return smallest;
    }

    // Sort the linked list in ascending order (using insertion sort)
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        Node sortedNode = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            sortedNode = insertIntoSorted(sortedNode, current);
            current = next;
        }

        head = sortedNode;
    }

    private Node insertIntoSorted(Node sortedNode, Node newNode) {
        if (sortedNode == null || newNode.data <= sortedNode.data) {
            newNode.next = sortedNode;
            return newNode;
        }

        Node current = sortedNode;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }
        
        // take NewNode after currentNode
        newNode.next = current.next;
        current.next = newNode;
        return sortedNode;
    }

    // Reverse the linked list
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Merge two linked lists
    public void merge(SinglyLinkedList list2) {
        if (list2 == null || list2.head == null) {
            return;
        }

        if (head == null) {
            head = list2.head;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = list2.head;
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        list1.insert(3);
        list1.insert(1);
        list1.insert(7);
        list1.insert(4);
        list1.insert(2);

        list2.insert(6);
        list2.insert(5);
        list2.insert(7);
        list2.insert(8);

        System.out.print("Original linked list 1: ");
        list1.display();

        System.out.print("Original linked list 2: ");
        list2.display();

        list1.delete(7);
        System.out.print("Linked list 1 after deleting 7: ");
        list1.display();

        list2.delete(8);
        System.out.print("Linked list 2 after deleting 8: ");
        list2.display();

        System.out.println("Smallest element in list 1: " + list1.findSmallest());
        System.out.println("Smallest element in list 2: " + list2.findSmallest());

        list1.merge(list2);
        System.out.print("List 1 after merging with list 2: ");
        list1.display();

        list1.sort();
        System.out.print("Merged List after sorting: ");
        list1.display();

        list1.reverse();
        System.out.print("Merged List after reversing: ");
        list1.display();

    }
}
