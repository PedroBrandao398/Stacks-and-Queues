public class LinkedQueueOfStrings {
  private Node first, last;
  
  private class Node {
    String item;
    Node next;
  }
  
  public boolan isEmpty() {
    return first == null;
  }
  
  public void enqueue(String item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (!isEmpty()) {
      oldlast.next = last;
    } 
    else {
    first = last;
    }
  }
  
  public String dequeue() {
    String item = first.item;
    first = first.next;
    if (first == null) {
      last = null;
    }
    return item;
  }
