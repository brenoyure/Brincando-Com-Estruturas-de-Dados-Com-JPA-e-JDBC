package br.albatross.structures.list;

import java.util.function.Consumer;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> first;
    private Node<T> last;

    private int size = 0;

    @Override
    public void add(T value) {

        Node<T> newNode;

        if (isEmpty()) {

            newNode = new Node<>(value);
            first = newNode;
            last = newNode;
            first.setNext(newNode);
            last.setPrev(newNode);

        }

        else {

            newNode = new Node<>(last, null, value);
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
    public void remove(T value) {

        if (isEmpty()) {
            return;
        }

        if (size == 1) {

            first.setValue(null);
            first.setNext(null);
            last.setValue(null);
            last.setPrev(null);

            first = null;
            last  = null;

            --size;

            return;

        }

        if (first.getValue().equals(value)) {

            Node<T> secondNode = first.getNext();
            first.setValue(null);
            first.setNext(null);
            first = secondNode;

            --size;
            return;

        }

        if (last.getValue().equals(value)) {

            Node<T> beforeLast = last.getPrev();
            last.setValue(null);
            last = beforeLast;
            --size;

            return;
        }

        for (Node<T> actualNode = first.getNext(); actualNode.hasNext(); actualNode = actualNode.getNext()) {

            if (actualNode.getValue().equals(value)) {

                Node<T> prevNode = actualNode.getPrev();
                Node<T> nextNode = actualNode.getNext();

                actualNode.setValue(null);
                actualNode.setPrev(null);
                actualNode.setNext(null);

                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);

                size--;
                return;

            }

        }

    }

    @Override
    public void removeAll() {

        for (Node<T> actual = first; actual.hasNext(); actual = actual.getNext()) {

            actual.setValue(null);
            actual.setPrev(null);

        }

        size = 0;
    }

    @Override
    public String toString() {

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

    @Override
    public void forEach(Consumer<T> consumer) {

        for (Node<T> actual = first; actual != null; actual = actual.getNext()) {

            consumer.accept(actual.getValue());

        }

    }

}
