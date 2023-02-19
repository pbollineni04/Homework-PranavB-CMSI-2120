class Node {
    public String name;
    public Node next;
    
    Node( ) { 
        next = null;
        name = "";
    }
    Node(String s) { 
        next = null;
        name = s;
    }// set the name 
} 

 class CircularLinkedList{
    Node head;
	Node tail;
    int size;
	public CircularLinkedList() {
		head = null;
		tail = null;
        size = 0;
	}
    public boolean isEmpty() {
		return head==null;
	}
	public int getSize() {
		return size;
	}
    public void add(String str) {
        Node trav = new Node(str);
        trav.next = head;
         if (head==null) {
           // first element
           head = trav;
           trav.next = head;
           tail = head;
           this.size = 0;
         } else {
            tail.next = trav;
            head = trav;}
         this.size++;
        
        }


    public void printList( ) { 
        Node temp = head;
        int count = 0;
        while(count < this.size){
            System.out.println(temp.name);
            temp = temp.next;
            count++;
        }
    }// print each element in the LinkedList
    public void insertBefore (int index, Node n) { 
        if (this.size < index){
            System.out.println("Index out of Bounds");
            return;
        }else if (index == 1) 
        {
            n.next = head;
            head = n;
            this.size++;
        }else 
        {
            int count = 0;
            Node trav;
            trav = head;
            while (count != index-1) {
                trav = trav.next;
                count++;
            }
            n.next = trav.next;
            trav.next= n;
            this.size++;
        }   
    } // adds Node n before index value 


    public void insertAfter (int index, Node n) { }// adds Node n after index value      
   // public int indexOf(String str) { }//returns index of where String str  is at.  Returns -1 if String str is not in LinkedList
    public void removeNodeAt(int index) { }// removes Node at index value
}

class main {
    public static void main(String[] args) {
        CircularLinkedList list1 = new CircularLinkedList();
        list1.add("test");
        list1.add("test2");
        list1.add("test3");
        list1.insertBefore(2, new Node("null"));
        list1.printList();
    }
}