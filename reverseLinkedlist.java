public class reverseLinkedlist {

    // STATIC head and tail -> accessible from anywhere
    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String arg[]) {
        reverseLinkedlist ll = new reverseLinkedlist();
        ll.addFirst(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        displayLinkedList();
        reverseFunc();
        displayLinkedList();
    //    System.out.println(tail);
    }

    public static void reverseFunc() {
        Node prev = null;
        Node current = tail = head;
        System.out.println(head);
       
        Node future;

        while (current != null) {
            future = current.next;
            current.next = prev;

            prev = current;
            current = future;
        }
        head = prev;
        

    }

    // BLUEPRINT for NODE
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void displayLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void addFirst(int data) {
        size++;
        // step 1 : create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 : new node next -> head
        newNode.next = head;
        // step 3 : head -> new node.data
        head = newNode;
    }

    public void addLast(int data) {
        size++;
        // step 1 : create newNode
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 : tail.next = newNode
        tail.next = newNode;
        // step 3 : newNode = tail
        tail = newNode;
    }

    public void addMiddle(int index, int data) {
        size++;
        Node temp = head;
        int counter = 0;
        while (counter != index) {
            if ((temp != null) && (counter == index - 1)) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            temp = temp.next; // going to next node
            counter++;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }

        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }

        Node temp = head;
        int count = 1;
        while (count != size) {
            if (count == size - 1) {
                temp.next = null;
            }
            temp = temp.next;
            count++;
        }
        size--;
    }

    public void deleteMiddle(int index) {
        if (head == null) {
            return;
        }
        Node prev = head;
        size--;
        int count = 1;
        while (count != index + 1) {
            if (count == index - 1) {
                Node Future = prev.next;
                Future = Future.next; // travelled 2 nodes ahead (else use prev.next.next)
                prev.next = Future;
            }
            prev = prev.next;
            count++;
        }
    }

    public int searchElement(int data) {
        if (head == null) {
            return -1;
        }
        Node temp = head;
        int index = 1;
        while (index < size + 1) {
            if (temp.data == data) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
    /*
     * public static int sizeOfLinkedList() {
     * // Self-Made
     * Node temp = head;
     * int size = 0;
     * while (temp != null) {
     * temp = temp.next;
     * size++;
     * }
     * return size;
     * }
     */
}
