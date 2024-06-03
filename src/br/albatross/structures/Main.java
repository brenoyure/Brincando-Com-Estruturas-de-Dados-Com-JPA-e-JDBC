package br.albatross.structures;

import br.albatross.structures.list.MyArrayList;
import br.albatross.structures.list.MyList;

public class Main {

    public static void main(String[] args) {

        MyList<Integer> myList = new MyArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        System.out.println(myList);

        myList.remove(5);

        System.out.println(myList);

    }

}
