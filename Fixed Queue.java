public class FixedArrayQueueOfStrings {
  private String[] q;
  private int first, last;

  public FixedArrayQueueOfStrings(int capacity) {
    q = new String[capacity];
    first = -1;
    last = -1;
  }
  
  public boolean isEmpty() {
    return first == -1;
  }
  
  public int size() {
    if(first == -1) {
      return 0;
    } else if(first <= last) {
      return last-first+1;
    } else {
      return q.length-first+last+1;
    }
  }

  public void enqueue(String item) {
    if (size() == q.length) {
      throw new IllegalStateException("Error: Queue overflow ");
    }
    q[next(last)] = item;
    last = next(last);
    if(first == -1) {
      first=0;
    }
  }
  
  public String dequeue() {
    
  }
}
