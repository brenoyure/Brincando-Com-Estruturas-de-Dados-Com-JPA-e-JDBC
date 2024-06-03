package br.albatross.structures.list;

public interface MyList<T> {

    void add(T value);

    int size();

    boolean isEmpty();

    boolean contains(T value);

    T get(int position);

    Object[] toArray();

    void remove(T value);

    void removeAll();

}
