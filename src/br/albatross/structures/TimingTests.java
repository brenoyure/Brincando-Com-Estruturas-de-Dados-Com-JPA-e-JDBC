package br.albatross.structures;

public class TimingTests {

    public static void main(String[] args) throws Exception {

        int loopForLimit = 50000;
        
        Runnable arrayList = new AddToMyArrayList(loopForLimit);
        Runnable linkedList = new AddToMyLinkedList(loopForLimit);

        Thread t1 = new Thread(arrayList);
        Thread t2 = new Thread(linkedList);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
