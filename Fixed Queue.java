public class FixedArrayQueueOfStrings {
  private String[] q;
  private int first, last;

  public FixedArrayQueueOfStrings(int capacity) {
    q = new String[capacity];
    first = -1;
    last = -1;
  }


  //Retorna a próxima posição para a ocupação circular
  private int next(int i) {
    return (i + 1) % q.length;
  }


  //Verifica se a queue está vazia
  public boolean isEmpty() {
    return first == -1;
  }


  //Devolve o o número de elementos
  public int size() {
    //Se não tem elementos/se first está primeiro/se last está primeiro
    if (first == -1) {
        return 0;
    }
    else if (first <= last) {
        return last - first + 1;
    } 
    else {
        return q.length - first + last + 1;
    }
  }

  public void enqueue(String item) {
    if (size() == q.length) {
      throw new IllegalStateException("Error: Queue overflow ");
    }
    q[next(last)] = item;
    last = next(last);
    if(first==-1) {
      first=0;
    }
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
