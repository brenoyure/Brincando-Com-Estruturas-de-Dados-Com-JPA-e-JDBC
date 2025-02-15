package br.albatross.structures;

import br.albatross.structures.runnables.AddToMyArrayList;
import br.albatross.structures.runnables.AddToMyLinkedList;
import br.albatross.structures.runnables.RemovalAllFromMyArrayList;
import br.albatross.structures.runnables.RemovalAllFromMyLinkedList;

public class TimingTests {

    public static void main(String[] args) throws Exception {

        int loopForLimit = 1000000;
        int arrayListInitialCapacity = loopForLimit;

        Runnable addToArrayList = new AddToMyArrayList(loopForLimit, arrayListInitialCapacity);
        Runnable addToLinkedList = new AddToMyLinkedList(loopForLimit);

        Runnable removeAllFromArrayList = new RemovalAllFromMyArrayList(loopForLimit, arrayListInitialCapacity);
        Runnable removeAllFromLinkedList = new RemovalAllFromMyLinkedList(loopForLimit);

        Thread t1 = new Thread(addToArrayList);
        Thread t2 = new Thread(addToLinkedList);
        Thread t3 = new Thread(removeAllFromArrayList);
        Thread t4 = new Thread(removeAllFromLinkedList);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

}
