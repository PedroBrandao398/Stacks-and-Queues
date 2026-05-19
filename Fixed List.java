public class List<T> {
  private T[] l;
  private int first,last;
  private int size;
  
  public List(int capacity) {
    l = (T[]) new Object[capacity];
    first = -1;
    last = -1;
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
  
  public int size() {
    return size;
  }
  
  public void add(T item) {
    last = next(last);
    l[last] = item;
    if (first == -1) {
      first = last;
    }
    size++;
  }
  
  public T get(int index) {
    int pos = (first + index) % l.length;
    return l[pos]
  }
  
  public T remove(int index) {
    int position = (first + index - 1) % l.length;
    T item = l[position];
    if (first == last) {
      l[position] = null;
      first = -1;
      last = -1;
    } else if (index < size()/2) {
      for(int i = position; i != first; i = previous(i))
        l[i] = l[previous(i)];
        l[first] = null;
        first = next(first);
    } else { 
      for (int i = position; i != last; i = next(i)) {
        l[i] = l[next(i)];
        l[last] = null;
        last = previous(last);
      }
    }
  }
  
  public boolean contains(T item) {
    if (isEmpty()) {
      return false;
    } else {
      boolean exists = item.equals(l[first]);
      for (int i=next(first); i!=next(last)&&!exists; i=next(i)) {
        if (item.equals(l[i])) {
          exists = true;
      }
      return exists;
    }
}
