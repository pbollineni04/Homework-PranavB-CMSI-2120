class Node {
    public String name;
    public Node next;
    public Node prev;
    Node( ) { 
        next = null;
        prev = null;
        name = "";
    }
    Node(String s) { 
        next = null;
        prev = null;
        name = s;
    }// set the name 
} 
class MyDoublyLinkedList {

    private Node head;
    
    MyDoublyLinkedList( ) {  
        head = null;
    }
    public void addNode(Node n) { 
        Node temp = head;
        if(head == null){
            head = n;
            head.prev = null;
            return;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;
    }// add a Node to end of the LinkedList 


    public void printList( ) { 
        Node temp = head;
        while(temp != null){
            System.out.println(temp.name);
            
            // try{
            //     System.out.println(temp.next.name);
            //     System.out.println(temp.prev.name);
            // }catch(Exception e){
            //     System.out.println(e);
            // }
            temp = temp.next;
        }
       
    }// print each element in the LinkedList
    
    public void insertBefore (int index, Node n) { 
        Node temp = head;
        int count = 0;
        if (head == null){
            System.out.println("Empty List");
        }
        while(temp != null){
            
          
            if(count == index){
                break;
            }
            temp = temp.next;
            count++;
        }
        Node n1 = temp.prev;
        n1.next = n;
        n.prev = n1;
        n.next = temp;
        //temp.next = n;
        if(count < index){
            System.out.println("Index out of Bounds");
        }
        if(n.prev == null){
            System.out.println("null");
        }
    }

    public void insertAfter (int index, Node n) { 
        Node temp = head;
        int count = 0;
        if (head == null){
            System.out.println("Empty List");
        }
        while(temp != null){
            
            
            if(count == index){
                break;
            }
            temp = temp.next;
            count++;
        }
        Node n1 = temp.next;
        n1.prev = n;
        n.next = n1;
        n.prev = temp;
        temp.next = n;
        if(count < index){
            System.out.println("Index out of Bounds");
        }
        if(n.prev == null){
            System.out.println("null");
        }
    }// adds Node n after index value      
    public int indexOf(String str) { 
        int count = 0;
        Node temp = head;
        while(temp != null){
            if(temp.name.equals(str)){
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }//returns index of where String str  is at.  Returns -1 if String str is not in LinkedList
    public void removeNodeAt(int index) {
        Node temp = head;
        int count = 0;
        if (head == null){
            System.out.println("Empty List");
        }else if(index == 0){
            head = head.next;
            return;
        }
        
        while(temp != null){
            if(count == index){
                break;
            }
            temp = temp.next;
            count++;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }// removes Node at index value
    
}

class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList list1 = new MyDoublyLinkedList();
        list1.addNode(new Node("test"));
        list1.addNode(new Node("test2"));
        list1.addNode(new Node("test3"));
        list1.insertBefore(2, new Node("testInsertBefore"));
        list1.insertAfter(2, new Node("testInsertAfter"));
        
        list1.printList();
        System.out.println(list1.indexOf("test") + "\n");
        list1.removeNodeAt(2);
        list1.printList();
        System.out.println(list1.indexOf("testInsertBefore"));
    }
}

    