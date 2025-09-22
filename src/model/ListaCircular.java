package model;

import model.ListaCircular;

public class ListaCircular{
  private NoTipo lastIn;

  public ListaCircular(){
    super();
    this.lastIn = null;
  }

  public void write(String protocol, String content) throws Exception{
    if(content == null || content.equals(""))
      throw new IllegalArgumentException("The content cannot be null");

    if(protocol == null || protocol.equals(""))
      throw new IllegalArgumentException("The protocol cannot be null");

    if(this.lastIn == null){
      ListaSimples<String> newList = new ListaSimples<>();
      newList.write(content);
      NoTipo newNode = new NoTipo(protocol,newList);
      this.lastIn = newNode;
      newNode.setNext(newNode);
      newNode.setPrevious(newNode);
    }else{
      NoTipo buffer = this.lastIn.getNext();
      while(buffer != this.lastIn && !buffer.getProtocol().equals(protocol)){
        buffer = buffer.getNext();
      }

      if(protocol.equals(buffer.getProtocol())){
        buffer.getContent().write(content);
      }else{
        ListaSimples<String> newList = new ListaSimples<>();
        newList.write(content);
        NoTipo newNode = new NoTipo(protocol, this.lastIn, newList, this.lastIn.getNext());
        this.lastIn.getNext().setPrevious(newNode);
        this.lastIn.setNext(newNode);
        this.lastIn = newNode;
      }
    }
  }

  public String read(String protocol) throws Exception{
    if(protocol == null || protocol.equals(""))
      throw new IllegalArgumentException("The protocol cannot be null");

    if(this.lastIn == null)
      throw new IllegalArgumentException("The list is empty");

    NoTipo buffer = this.lastIn.getNext();
    while (buffer != this.lastIn && !buffer.getProtocol().equals(protocol)) {
      buffer = buffer.getNext();
    }

    if(buffer.getProtocol().equals(protocol)){
      String data = buffer.getContent().read();
      if(buffer.getContent().getSize() == 0){
        NoTipo previous = buffer.getPrevious();
        NoTipo next = buffer.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
        buffer.clearNode();
      }
      return data;
    }else{
      throw new IllegalArgumentException(protocol+" not found in router.");
    }
  }

  public String toString(){
    if(this.lastIn == null){
      return "[]";
    }else{
      StringBuilder text = new StringBuilder("{");
      NoTipo buffer = this.lastIn.getNext();
      while (buffer != this.lastIn) {
        text.append("\n");
        text.append(buffer.toString());
        text.append("\n");
        buffer = buffer.getNext();
      }
      text.append("\n");
      text.append(buffer.toString());
      text.append("\n}");
      return text.toString();
    }
  }
}
