public class FixedCapacityStackOfStrings {
  private String[] s;
  private int N = 0;
  
  public FixedCapacityStackOfStrings() {
    s = new String[2];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void resize(int capacity) {
    String[] copy = new String[capacity];
    for (int i = 0; i < N; i++) {
      copy[i] = s[i];
    }
    s = copy;
  }
  
  public void push(String item) {
    if (N == s.length) {
      resize(2 * s.length);
    }
    s[N++] = item;
  }
  
  public String pop(){
    String item = s[--N];
    s[N] = null;
    if (N > 0 && N == s.length / 4) {
      resize(s.length / 2);
    }
    return item;
  }
}
