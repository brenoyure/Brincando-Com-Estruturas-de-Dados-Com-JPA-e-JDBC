package br.albatross.structures.runnables;

import br.albatross.structures.list.MyLinkedList;
import br.albatross.structures.list.MyList;

public class RemovalAllFromMyLinkedList implements Runnable {

    private int loopForLimit;

    public RemovalAllFromMyLinkedList(int loopForLimit) {
        this.loopForLimit = loopForLimit;
    }

    @Override
    public void run() {

        try {

            MyList<Integer> myList = new MyLinkedList<>();

            for (int i = 0; i < loopForLimit; i++) {

                myList.add(i);
                

            }
            
            long beforeTest = System.currentTimeMillis();
            myList.removeAll();
            System.out.println("LinkedList terminou removeAll() em " + (System.currentTimeMillis() - beforeTest));

        }

        catch (Exception e) { throw new RuntimeException(e); }

    }

}
