package br.albatross.test;

public class Node<T> {

    private Node<T> next;
    private T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(Node<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
