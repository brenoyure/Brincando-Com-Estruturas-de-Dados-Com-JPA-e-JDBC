package br.albatross.structures;

import br.albatross.structures.list.MyArrayList;
import br.albatross.structures.list.MyList;

public class AddToMyArrayList implements Runnable {

    private int loopForLimit;

    public AddToMyArrayList(int loopForLimit) {
        this.loopForLimit = loopForLimit;
    }
    
    @Override
    public void run() {

        MyList<Integer> myList = new MyArrayList<>();

        long beforeTest = System.currentTimeMillis();
        
        for (int i = 0; i < loopForLimit; i++) {

            myList.add(i);

        }
        
        System.out.println("My ArrayList terminou em " + (System.currentTimeMillis() - beforeTest));

    }

}
