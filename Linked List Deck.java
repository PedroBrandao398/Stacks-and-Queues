public class Deck<T> {
  private Node first;
  private Node last;
  private int size;

  private class Node {
    T item;
    Node next;
    Node prior;
  }

  public Deck() {
    first = null;
    last = null;
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void pushLeft(T item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    first.prior = null;
    if (oldfirst != null) {
      oldfirst.prior = first;
    } else {
      last = first;
    }
    size++;
  }

  public void pushRight(T item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.prior = oldlast;
    last.next = null;
    if (oldlast != null) {
      oldlast.next = last;
    } else {
      first = last;
    }
    size++;
  }

  public T popLeft() {
    if (first == null) {
      return null;
    }
    T item = first.item;
    if (first != last) {
      first = first.next;
      first.prior = null;
    } else {
      first = null;
      last = null;
    }
    size--;
    return item;
  }

  public T popRight() {
    if (first == null) {
      return null;
    }
    T item = last.item;
    if (first != last) {
      last = last.prior;
      last.next = null;
    } else {
      first = null;
      last = null;
    }
    size--;
    return item;
  }
}
