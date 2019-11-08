import java.util.Map;
import java.util.HashMap;

public class LinkedList{  
  
   private Node head;  
    
   private static class Node {  
    private int value;  
    private Node next;  
    
    Node(int value) {  
     this.value = value;  
    
    }  
   }  
    
   public void add(Node node) {  
    if (head == null) {  
     head = node;  
    } else {  
     Node temp = head;  
     while (temp.next != null)  
      temp = temp.next;  
     temp.next = node;  
    }  
   }


 public void printList() {  
  Node temp = head;  
  while (temp != null) {  
   System.out.format("%d ", temp.value);  
   temp = temp.next;  
  }  
  System.out.println();  
 }  

///////////////////////
  public void reverseLinkedListIteratively() {
    Node prevNode = null;
tuytytt     Node currentNode = head;

    while (currentNode != null) {
      Node nextNode = currentNode.next;
      currentNode.next = prevNode;

      prevNode = currentNode;
      currentNode = nextNode;
    }
    head = prevNode;
  }
/////////////////////
  public void reverseLinkedListRecursively(Node node) {
    if (node == null) return;
    if (node.next==null) {
      head = node;
      return;
    }

    reverseLinkedListRecursively(node.next);
    node.next.next = node;
    node.next = null;

  }
///////////////////

  public boolean detectLoops(){
    Node slow = head;
    Node fast = head.next.next;

    while (slow != null && fast != null) {
      if (slow == fast) return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }


//////////////

  public void removeDuplicates() {
    Node current = head;
    Map<Integer,Integer> map = new HashMap<>();
    
    while (current != null) {
      if (map.containsKey(current.value)) {
        remove(current);
        current=current.next;
      }
      else {
        map.put(current.value,null);
        current = current.next;
      }
   }
}


  public void remove(Node node){
   if (node ==head) {
    Node temp = head.next;
    //head.next = null;
    head = temp;
    return;
   }

    Node current = head;
    while (current != null) {
      if (current.next == node) {
        current.next = node.next;
        return;
      }
      current=current.next;
    }
}


//check for palindrome: reverse halfway thru linked list and break in half, then compare. or just reverse


///////////////////////////////////// reverse for doubly linked lists
  public void reverse() {
    /* Switches the end and begin Markers, so that you now enter 
    from behind */
    Node<T> temp = beginMarker;
    beginMarker = endMarker;
    endMarker = temp;

    Node<T> currentNode = beginMarker;

    //Goes through the list until has passed the sentinel nodes
    while(currentNode != null) {
      // Switches the previous and next pointers
      temp = currentNode.next;
      currentNode.next = currentNode.prev;
      currentNode.prev = temp;

      // moves to the next element (which before was the previous element)
      currentNode = currentNode.next; 
    }
    
  }
//////////////////////////////


  public static void main(String[] args) {
    LinkedList myList = new LinkedList();
    for (int i=0;i<10;i++) myList.add(new Node(i));
    myList.printList();
    myList.reverseLinkedListIteratively();
    myList.printList();
    myList.reverseLinkedListRecursively(myList.head);
    myList.printList();

    // Node bob = new Node(11);
    // myList.add(bob);
    // bob.next = myList.head.next;
    // myList.printList();
    // System.out.println(myList.detectLoops());

    myList.add(new Node(5));
    myList.add(new Node(5));

    myList.printList();
    myList.removeDuplicates();
    myList.printList();

///
    myList = new LinkedList();
    Node bob = new Node(5);
    myList.add(bob);
    // myList.add(new Node(5));
    myList.remove(bob);
    myList.printList();
    System.out.println(myList.head);



  }
}