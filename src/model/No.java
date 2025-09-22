package model;

public class No<T> {
  private T content;
  private No<T> previous;

  public No(No<T> previous, T content) {
    this.content = content;
    this.previous = previous;
  }

  public No(T content) {
    this(null, content);
  }

  public void setContent(T content) {
    this.content = content;
  }

  public T getContent() {
    return this.content;
  }

  public void setPrevious(No<T> next) {
    this.previous = next;
  }

  public No<T> getPrevious() {
    if (this.previous == null) {
      return null;
    } else {
      return this.previous;
    }
  }

  public void clearNode() {
    this.content = null;
    this.previous = null;
  }

  public String toString() {
    return this.content.toString();
  }
}
