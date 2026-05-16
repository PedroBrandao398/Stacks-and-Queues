public class FixedArrayQueueOfStrings {
  private String[] q;
  private int first, last;


  //Criação de objetos FixedArrayQueueOfStrings
  public FixedArrayQueueOfStrings(int capacity) {
    //Cria array de tamanho capacity
    q = new String[capacity];
    //Inicializa first e last
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


  //Adiciona elementos no fim da queue
  public void enqueue(String item) {
    //Verifica se está cheio
    if (size() == q.length) {
      throw new IllegalStateException("Error: Queue overflow ");
    }
    //Adiciona no elemento no fim da queue
    q[next(last)] = item;
    //Atualiza last
    last = next(last);
    //Se era vazia fist fica no primeira posição 0
    if(first==-1) {
      first=0;
    }
  }


  //Remove e retorna elementos do início da queue
  public String dequeue() {
    //Verifica se está vazia
    if (first == -1) {
      throw new IllegalStateException("Error: Queue underflow ");
    }
    //Guarda o primeiro elemento
    String item = q[first];
    //Remove o primeiro elemento
    q[first] = null;
    //Verifica se só tem 1 elemento/atualiza first para seguinte
    if(first == last) {
      first = -1;
      last = -1;
    } else {
      first = next(first);
    }
    return item;
  }
}
