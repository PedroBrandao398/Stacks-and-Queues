public class ResizingStackOfStrings {
  private String[] s;
  private int N = 0;


   //Criação de objetos ResizingStackOfStrings
  public ResizingStackOfStrings() {
    //Cria array de um tamanho inical 2
    s = new String[2];
  }


  //Verifica se a stack está vazia
  public boolean isEmpty() {
    return N == 0;
  }


  //Retorna o número de elementos da stack
  public int size() {
    return N;
  }


  //Cria um novo array maior ou menor
  private void resize(int capacity) {
    //Cria novo array
    String[] copy = new String[capacity];
    //Copia elementos
    for (int i = 0; i < N; i++) {
      copy[i] = s[i];
    }
    s = copy;
  }


  //Adiciona elementos no topo da stack
  public void push(String item) {
    //Verifica se o array está cheio e duplica o tamanho do array
    if (N == s.length) {
      resize(2 * s.length);
    }
    s[N++] = item;
  }


  //Remove e retorna o elemento no topo
  public String pop(){
    //Guarda o elemento no topo
    String item = s[--N];
    //Remove o elemento no topo
    s[N] = null;
    //Verifica se N é 1/4 do array e reduz o array pela metade
    if (N > 0 && N == s.length / 4) {
      resize(s.length / 2);
    }
    return item;
  }
}
