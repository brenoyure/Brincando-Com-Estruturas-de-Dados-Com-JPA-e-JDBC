package br.albatross.structures.runnables;

import br.albatross.structures.list.MyLinkedList;
import br.albatross.structures.list.MyList;

public class AddToMyLinkedList implements Runnable {

    private int loopForLimit;

    public AddToMyLinkedList(int loopForLimit) {
        this.loopForLimit = loopForLimit;
    }
    
    @Override
    public void run() {

        MyList<Integer> myList = new MyLinkedList<>();

        long beforeTest = System.currentTimeMillis();        

        for (int i = 0; i < loopForLimit; i++) {

            myList.add(i);

        }
        
        System.out.println("LinkedList terminou de adicionar " + loopForLimit + " elementos, em " + (System.currentTimeMillis() - beforeTest));
        
    }

}
