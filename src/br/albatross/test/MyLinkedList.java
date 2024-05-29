package br.albatross.test;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> first;
    private Node<T> last;

    private int size = 0;

    @Override
    public void add(T value) {

        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            first = newNode;
            last = first;
            first.setNext(newNode);
        }

        else {

            last.setNext(newNode);
            last = newNode;
        }

        size++;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty List cannot be converted to Array");
        }

        Object[] array = new Object[size];

        Node<T> actual = first;

        for (int i = 0; i < size; i++) {

            array[i] = actual.getValue();
            actual = actual.getNext();
        }

        return array;

    }

    @Override
    public boolean contains(T value) {

        Node<T> actual = first;

        for (int i = 0; i < size; i++) {

            if (actual.getValue().equals(value)) {
                return true;
            }

            actual = actual.getNext();

        }

        return false;

    }

    @Override
    public T get(int position) {

        if (position == 0) {
            return first.getValue();
        }

        if (position == size - 1) {
            return last.getValue();
        }

        Node<T> actual = first.getNext();

        for (int i = 1; i <= position; i++) {

            if (i == position) {
                return actual.getValue();
            }

            actual = actual.getNext();

        }

        return null;

    }

    @Override
    // TODO Faltando Implementar
    public void remove(T value) {

    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> actual = first;

        for (int i = 0; i < size; i++) {

            sb.append(actual);
            actual = actual.getNext();

            if (i < size - 1) {
                sb.append(", ");
            }

        }

        return sb.append("]").toString();

    }

}
