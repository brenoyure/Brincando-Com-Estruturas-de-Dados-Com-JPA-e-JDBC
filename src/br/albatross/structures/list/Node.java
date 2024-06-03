package br.albatross.structures.list;

public class Node<T> {

    private Node<T> next;
    private Node<T> prev;
    private T value;

    public Node(T value) {
        this.next = null;
        this.value = value;
    }

    public Node(Node<T> next, T value) {
        this.prev = null;
        this.next = next;
        this.value = value;
    }

    public Node(Node<T> prev, Node<T> next, T value) {
        this.prev = prev;
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

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
