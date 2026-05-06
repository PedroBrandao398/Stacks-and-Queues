public class FixedArrayQueueOfStrings {
  private String[] q;
  private int first, last;
  private int N;

  public FixedArrayQueueOfStrings(int capacity) {
    q = new String[capacity];
    first = 0;
    last = 0;
    N = 0;
  }

  private int next(int i) {
    return (i + 1) % q.length;
  }
  
  public boolean isEmpty() {
    return N == 0;
  }
  
  public int size() {
    return N;
  }

  public void enqueue(String item) {
    if (N == q.length) {
      throw new IllegalStateException("Error: Queue overflow ");
    }
    q[last] = item;
    last = next(last);
    N++;
  }
  
  public String dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Error: Queue underflow ");
    }
    String item = q[first];
    q[first] = null;
    if(first == last) {
      first = -1;
      last = -1;
    } else {
      first = next(first);
    }
    return item;
  }
}
