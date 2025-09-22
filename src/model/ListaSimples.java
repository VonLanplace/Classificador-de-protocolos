package model;

public class ListaSimples<T>{
  private int size;
  private No<T> head;
  private No<T> tail;

  public ListaSimples(){
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  public int getSize(){
    return this.size;
  }
  protected void setSize(int size){
    this.size = size;
  }

  public No<T> getHead(){
    return this.head;
  }
  protected void setHead(No<T> head){
    this.head = head;
  }

  public No<T> getTail(){
    return this.tail;
  }
  protected void setTail(No<T> tail){
    this.tail = tail;
  }


  // Adiciona a fila
  public void write(T content) throws Exception{
    if(content == null) throw new IllegalArgumentException("The content cannot be null");

    No<T> newNode = new No<T>(content);
    if(this.size == 0){
      this.head = newNode;
      this.tail = newNode;
    }else{
      this.tail.setPrevious(newNode);
      this.tail = newNode;
    }
    this.size++;
  }

  // Remove da Fila
  public T read() throws Exception {
    if(this.size <= 0) throw new IllegalArgumentException("The list is empty");

    No<T> oldNode = this.head;
    this.head = oldNode.getPrevious();
    T content = oldNode.getContent();
    oldNode.clearNode();
    this.size--;
    return content;
  }

  //toString
  public String toString(){
    if(this.size == 0){
      return "[]";
    }else{
      StringBuilder text = new StringBuilder("[\n");
      No<T> node = this.head;
      for(int i = 0; i< this.size;i++){
        text.append("\t");
        text.append(node.toString());
        text.append("\n");
      }
      text.append("]");
      return text.toString();
    }
  }
}
