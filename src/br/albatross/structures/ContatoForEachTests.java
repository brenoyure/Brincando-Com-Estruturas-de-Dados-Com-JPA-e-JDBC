package br.albatross.structures;

import br.albatross.structures.list.MyLinkedList;
import br.albatross.structures.list.MyList;
import br.albatross.structures.model.Contato;

public class ContatoForEachTests {

    public static void main(String[] args) {

        MyList<Contato> myList = new MyLinkedList<>();

        Contato c1 = new Contato(1, "Breno Yuri", "85993321234", "Rua XPTO 365");
        Contato c2 = new Contato(2, "Amanda Blacer", "73211124321", "Rua Messejana City");
        Contato c3 = new Contato(3, "Thyaga Silva", "7311112232", "Rua da Serrinha");
        Contato c4 = new Contato(4, "Afonso Sales", "8533214332", "Avenida da Abolição");

        myList.add(c1);
        myList.add(c2);
        myList.add(c3);
        myList.add(c4);

        myList.forEach(System.out::println);

    }

}
