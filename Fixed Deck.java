public class Deck<T> {
  private T[] d;
  private int first, last;
  private int size;

  public Deck(int capacity) {
      d = (T[]) new Object[capacity];
      first = 0;
      last = 0;
      size = 0;
  }
  
  private int next(int i) {
      return (i + 1) % d.length;
  }
  
  private int previous(int i) {
      return (i - 1 + d.length) % d.length;
  }

  public boolean isEmpty() {
      return size == 0;
  }

  public boolean isFull() {
      return size == d.length;
  }
  
  public void pushLeft(T item) {
    first = previous(first);
    d[first] = item;
    if (size == 0) {
      last = first;
    }
    size++
  }
  
  public void pushRight(T item) {
    last = next(last);
    d[last] = item;
    if (size == 0) {
      first = last;
    }
    size++
  }
  
  public T popLeft() {
    T item = d[first];
    d[first] = null;
    first = next(first);
    size--;
    if (size == 0) {
      first = 0;
      last = 0;
    }
    return item;
  }
  
  public T popRight() {
    T item = d[last];
    d[last] = null;
    last = previous(last);
    size--;
    if (size == 0) {
      first = 0;
      last = 0;
    }
    return item;
  }
}
