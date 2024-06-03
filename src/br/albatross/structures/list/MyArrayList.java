package br.albatross.structures.list;

@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyList<T> {

    private T[] array;
    private int size = 0;
    private int currentIndex = 0;

    private int capacity;

    public MyArrayList() {
        array = (T[]) new Object[10];
        capacity = array.length;
    }

    public MyArrayList(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = array.length;
    }

    @Override
    public void add(T value) {

        increaseCapacity();
        array[currentIndex] = value;
        increaseSizeAndIndex();

    }

    public void addAll(T...values) {

        for (int i = 0; i < values.length; i++) {

            add(values[i]);

        }

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
    public boolean contains(T value) {

        for (int i = 0; i < size; i++) {

            if (array[i].equals(value)) {
                return true;
            }

        }

        return false;

    }

    @Override
    public T get(int position) {
        return array[position];
    }

    @Override
    public Object[] toArray() {

        if (isEmpty()) {

            throw new IllegalStateException("Empty List cannot be converted to Array");

        }

        Object[] array = new Object[size];

        for (int i = 0; i < size; i++) {

            array[i] = this.array[i];

        }

        return array;

    }

    @Override
    public void remove(T value) {

        int currentPosition = 0;
        
        for (int i = 0; i < size; i++) {
            
            if (array[i].equals(value)) {

                array[i] = array[i + 1];
                currentPosition = i;
                break;
            }
            
        }

        for (int i = currentPosition; i < size; i++) {

            array[i] = array[i + 1]; 

        }

        decreaseSizeAndIndex();

    }

    @Override
    public void removeAll() {

        for (int i = 0; i < size ; i++) {

            array[i] = null;

        }

        array = (T[]) new Object[capacity];

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {

            sb.append(array[i]);

            if (i < size - 1) {
                sb.append(", ");
            }

        }

        return sb.append("]").toString();

    }

    private void increaseSizeAndIndex() {
        currentIndex++;
        size++;
    }

    private void decreaseSizeAndIndex() {
        currentIndex--;
        size--;
    }

    private void increaseCapacity() {

        if (size == array.length) {

            doubleArrayCapacity();

        }

    }

    private void doubleArrayCapacity() {

        T[] newArray = (T[]) new Object[(size * 2)];

        for (int i = 0; i < size; i++) {

            newArray[i] = this.array[i];

        }

        array = newArray;

    }

}
























