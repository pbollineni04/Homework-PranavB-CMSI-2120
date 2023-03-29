interface Queue {
    void enqueue(String x);
    public String dequeue();
    public String first();
    public int size();
    public boolean isEmpty();
}

public class SinglyLinkedList implements Queue {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
        
    }
    SinglyLinkedList(){

    }

    @Override
    public void enqueue(String x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        String value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return value;
    }

    @Override
    public String first() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return first.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class main{
    public static void main(String[] args){
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.enqueue("test1");
        list1.enqueue("test2");
        list1.enqueue("test3");
        list1.printList();
        System.out.println(list1.first()); 
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        list1.dequeue();
        list1.dequeue();
        list1.printList();
    }

}