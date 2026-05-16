public class FixedCapacityStackOfStrings {
  private String[] s;
  private int N = 0;


  //Criação de objetos FixedCapacityStackOfStrings
  public FixedCapacityStackOfStrings(int capacity) {
     //Cria array de tamanho capacity
    s = new String[capacity];
  }


  //Verifica se a stack está vazia
  public boolean isEmpty() {
    return N == 0;
  }


  //Retorna o número de elementos da stack
  public int size() {
    return N;
  }


  //Adiciona elementos no topo da stack
  public void push(String item) {
    s[N++] = item;
  }


  //Remove e retorna o elemento no topo
  public String pop(){
    //Guarda o topo
    String item = s[--N];
    //Remove o topo
    s[N] = null;
    return item;
  }
}
