package br.albatross.structures.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.albatross.structures.list.MyArrayList;
import br.albatross.structures.list.MyList;

@DisplayName("Testes da implementação do MyArrayList")
class MyArrayListTest {

    private MyList<String> letters;

    @BeforeEach
    void init() {

        letters = new MyArrayList<>();

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

    }

    @Test
    @DisplayName("size() deve retornar a quantidade correta de elementos após add()")
    void shouldReturnCorrectSizeAfterAdd() {

        int expectedSize = 5;
        assertEquals(expectedSize, letters.size());

    }

    @Test
    @DisplayName("size() deve retornar o tamanho correto da lista após adição de mais valores")
    void shouldReturnTheCorrectSizeAfterAddingMoreValues() {

        int expectedSize = 5;

        assertEquals(expectedSize, letters.size());

        letters.add("F");
        letters.add("G");
        letters.add("H");

        expectedSize = 8;

        assertEquals(expectedSize, letters.size());

    }

    @Test
    @DisplayName("Testa o Método toArray() passando 5 letras de A, B, C, D, E")
    void testToArrayMethodWithFiveStringAtoE() {

        var array = letters.toArray();

        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
        assertEquals("D", array[3]);
        assertEquals("E", array[4]);

        String[] expectedArray = { "A", "B", "C", "D", "E" };
        assertArrayEquals(expectedArray, array);

    }

    @Test
    @DisplayName("Lança IllegalStateException caso o método toArray() seja chamado com a Lista vazia")
    void toArrayShouldThrowIllegalStateExceptionOnEmptyMyLinkedList() {

        MyList<String> emptyLettersList = new MyArrayList<>();
        assertThrows(IllegalStateException.class, emptyLettersList::toArray);

    }

    @Test
    @DisplayName("get() deve retornar os valores da primeira e da ultima posição da lista")
    void shouldReturnTheValueOfTheFirstAndLastPositions() {

        String expectedLetter = "A";
        assertEquals(expectedLetter, letters.get(0));

        expectedLetter = "E";
        assertEquals(expectedLetter, letters.get(4));

    }

    @Test
    @DisplayName("get() deve retornar os valores de posições válidas da lista")
    void shouldReturnTheValueOfGivenPositions() {

        String expectedLetter = "A";
        assertEquals(expectedLetter, letters.get(0));

        expectedLetter = "B";
        assertEquals(expectedLetter, letters.get(1));

        expectedLetter = "C";
        assertEquals(expectedLetter, letters.get(2));

        expectedLetter = "D";
        assertEquals(expectedLetter, letters.get(3));

        expectedLetter = "E";
        assertEquals(expectedLetter, letters.get(4));

    }

    @Test
    @DisplayName("increaseCapacity() deve aumentar a capacidade da lista caso atinga a capacidade padrão de 10 elementos, e deve conseguir adicionar mais 1 elemento")
    void shouldIncreaseInternalArrayCapacityAfterLimitGetsReachedUsingIncreaseCapacityInternalMethod() {

        letters.add("F");
        letters.add("G");
        letters.add("H");
        letters.add("I");
        letters.add("J");

        assertEquals("[A, B, C, D, E, F, G, H, I, J]", letters.toString());

        letters.add("K");

        assertEquals("[A, B, C, D, E, F, G, H, I, J, K]", letters.toString());

    }

    @Test
    @DisplayName("toString(), após o remove() deve retornar a lista faltando o primeiro elemento e o size() correto")
    void shouldReturnAsStringTheCommaSeparatedValuesOfTheListWithoutTheFirstElement() {

        int expectedSize = 4;
        String expectedToString = "[B, C, D, E]";
        letters.remove("A");

        assertEquals(expectedToString, letters.toString());
        assertEquals(expectedSize, letters.size());

    }

    @Test
    @DisplayName("toString() deve imprimir um [] após a remoção de todos os elementos da lista")
    void shouldReturnAnEmptyArrayAfterAllElementsHaveBeenRemoved() {

        letters.remove("A");
        letters.remove("B");
        letters.remove("C");
        letters.remove("D");
        letters.remove("E");

        String expectedToString = "[]";
        assertEquals(expectedToString, letters.toString());

    }

    @Test
    @DisplayName("contains() deve retornar false ao remover o primeiro e o último elemento")
    void shouldReturnNullForFirstAndLastElementAfterRemoval() {

        letters.remove("A");
        letters.remove("E");

        assertFalse(letters.contains("A"));
        assertFalse(letters.contains("E"));
    }    

    @Test
    @DisplayName("contains() retorna true se determinado valor estiver contido na Lista")
    void shouldReturnTrueIfSpecifiedValueIsPresentInsideTheList() {

        boolean contemLetraA = letters.contains("A");
        boolean contemLetraB = letters.contains("B");
        boolean contemLetraC = letters.contains("C");
        boolean contemLetraD = letters.contains("D");
        boolean contemLetraE = letters.contains("E");

        assertTrue(contemLetraA);
        assertTrue(contemLetraB);
        assertTrue(contemLetraC);
        assertTrue(contemLetraD);
        assertTrue(contemLetraE);

    }    

    @Test
    @DisplayName("contains() retorna true se os novos valores adicionados com o addAll() estiverem contido na Lista")
    void shouldReturnTrueIfSpecifiedValuesArePresentInsideTheListUsingAddAllMethod() {

        int expectedSize = 0;

        MyArrayList<String> arrayList = new MyArrayList<>();
        assertEquals(expectedSize, arrayList.size());

        arrayList.addAll("A", "B", "C", "D");

        expectedSize = 4;
        assertEquals(expectedSize, arrayList.size());

        String expectedToString = "[A, B, C, D]";
        assertEquals(expectedToString, arrayList.toString());
        assertFalse(arrayList.contains("E"));

        arrayList.add("E");
        expectedSize = 5;
        expectedToString = "[A, B, C, D, E]";

        assertTrue(arrayList.contains("E"));
        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedToString, arrayList.toString());

    }

}








