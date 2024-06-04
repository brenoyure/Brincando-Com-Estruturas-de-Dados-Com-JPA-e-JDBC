package br.albatross.structures.runnables;

import br.albatross.structures.list.MyArrayList;
import br.albatross.structures.list.MyList;

public class AddToMyArrayList implements Runnable {

    private int loopForLimit;
    private int arrayListInitialCapacity;

    public AddToMyArrayList(int loopForLimit, int arrayListInitialCapacity) {
        this.loopForLimit = loopForLimit;
        this.arrayListInitialCapacity = arrayListInitialCapacity;
    }

    @Override
    public void run() {

        MyList<Integer> myList = new MyArrayList<>(arrayListInitialCapacity);

        long beforeTest = System.currentTimeMillis();

        for (int i = 0; i < loopForLimit; i++) {

            myList.add(i);

        }

        System.out.println("ArrayList terminou de adicionar " + loopForLimit + " elementos, em " + (System.currentTimeMillis() - beforeTest));
    }

}
