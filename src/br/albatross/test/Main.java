package br.albatross.test;

public class Main {

    public static void main(String[] args) {

        MyList<Integer> myList = new MyLinkedList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        System.out.println(myList);

        myList.remove(1);

        System.out.println(myList);

    }

}
