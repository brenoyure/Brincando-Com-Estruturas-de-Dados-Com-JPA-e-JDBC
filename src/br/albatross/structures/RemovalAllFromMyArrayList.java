package br.albatross.structures;

import static java.lang.Thread.sleep;

import br.albatross.structures.list.MyArrayList;
import br.albatross.structures.list.MyList;

public class RemovalAllFromMyArrayList implements Runnable {

    private int loopForLimit;
    private int arrayListInitialCapacity;

    public RemovalAllFromMyArrayList(int loopForLimit, int arrayListInitialCapacity) {
        this.loopForLimit = loopForLimit;
        this.arrayListInitialCapacity = arrayListInitialCapacity;
    }

    @Override
    public void run() {

        try {

            MyList<Integer> myList = new MyArrayList<>(arrayListInitialCapacity);

            for (int i = 0; i < loopForLimit; i++) {

                myList.add(i);
                

            }
            
            sleep(3000);
            long beforeTest = System.currentTimeMillis();
            myList.removeAll();
            System.out.println("ArrayList terminou removeAll() em " + (System.currentTimeMillis() - beforeTest));

        }

        catch (InterruptedException e) { throw new RuntimeException(e); }

    }

}
