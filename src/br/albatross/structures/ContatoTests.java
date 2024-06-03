package br.albatross.structures;

import br.albatross.structures.list.MyLinkedList;
import br.albatross.structures.list.MyList;
import br.albatross.structures.model.Contato;

public class ContatoTests {

    public static void main(String[] args) {

        MyList<Contato> myList = new MyLinkedList<>();

        Contato c1 = new Contato(1, "Breno Yuri", "85993321234", "Rua XPTO 365");
        Contato c2 = new Contato(2, "Amanda Blacer", "73211124321", "Rua Messejana City");
        Contato c3 = new Contato(3, "Thyaga Silva", "7311112232", "Rua da Serrinha");
        Contato c4 = new Contato(4, "Afonso Sales", "8533214332", "Avenida da Abolição");

        System.out.println(myList);
        myList.add(c1);
        myList.add(c2);
        
        System.out.println(myList);
        System.out.println(myList.contains(c2));
        
        myList.add(c3);
        System.out.println(myList);
        myList.remove(c2);
        System.out.println(myList);
        System.out.println(myList.contains(c2));
        myList.add(c4);
        System.out.println(myList);
        System.out.println(myList.size());
    }

}
