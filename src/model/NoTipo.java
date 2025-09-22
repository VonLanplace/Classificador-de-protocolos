package model;

import model.ListaSimples;

public class NoTipo {
  private String protocol;
  private ListaSimples<String> content;
  private NoTipo next;
  private NoTipo previous;

  public NoTipo(String protocol, NoTipo previous, ListaSimples<String> content, NoTipo next) {
    this.protocol = protocol;
    this.previous = previous;
    this.content = content;
    this.next = next;
  }

  public NoTipo(String protocol, ListaSimples<String> content, NoTipo next) {
    this(protocol, null, content, next);
  }

  public NoTipo(String protocol, NoTipo previous, ListaSimples<String> content) {
    this(protocol, previous, content, null);
  }

  public NoTipo(String protocol, ListaSimples<String> content) {
    this(protocol, null, content, null);
  }

  public String getProtocol() {
    if (this.previous == null) {
      return null;
    } else {
      return this.protocol;
    }
  }

  protected void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public ListaSimples<String> getContent() {
    return this.content;
  }

  public void setContent(ListaSimples<String> content) {
    this.content = content;
  }

  public NoTipo getPrevious() {
    if (this.previous == null) {
      return null;
    } else {
      return this.previous;
    }
  }

  public void setPrevious(NoTipo previous) {
    this.previous = previous;
  }

  public NoTipo getNext() {
    if (this.next == null) {
      return null;
    } else {
      return this.next;
    }
  }

  public void setNext(NoTipo next) {
    this.next = next;
  }

  public void clearNode() {
    this.protocol = null;
    this.previous = null;
    this.content = null;
    this.next = null;
  }

  public String toString() {
    return this.content.toString();
  }
}
