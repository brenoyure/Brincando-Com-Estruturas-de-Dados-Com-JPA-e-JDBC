package br.albatross.structures.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.albatross.structures.list.MyLinkedList;
import br.albatross.structures.list.MyList;

@DisplayName("Testes da implementação do MyLinkedList")
class MyLinkedListTest {

    private MyList<String> letters;

    @BeforeEach
    void init() {

        letters = new MyLinkedList<>();

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

    }

    @Test
    @DisplayName("size() deve retornar o tamanho correto da lista após adição apenas 1(um) valor")
    void shouldReturnTheCorrectSizeAfterAddingOnlyOneValue() {

        int expectedSize = 0;

        MyList<String> letters = new MyLinkedList<>();
        assertEquals(expectedSize, letters.size());

        letters.add("A");
        expectedSize = 1;

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

        MyList<String> emptyLettersList = new MyLinkedList<String>();
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
    @DisplayName("toString() deve retornar os valores da Lista separados por vírgula e entre []")
    void shouldReturnAsStringTheCommaSeparatedValuesOfTheList() {

        String expectedToString = "[A, B, C, D, E]";
        assertEquals(expectedToString, letters.toString());

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
    @DisplayName("remove() com a lista contendo apenas 1(um) elemento")
    void removeMethodOnOnlyOneElementList() {

        int expectedSizeWithNoElements = 0;
        int expectedSizeWithOneElement = 1;

        MyList<String> lettersList = new MyLinkedList<>();
        assertEquals(expectedSizeWithNoElements, lettersList.size());

        lettersList.add("A");

        assertTrue(lettersList.contains("A"));
        assertEquals(expectedSizeWithOneElement, lettersList.size());

        lettersList.remove("A");
        assertTrue(lettersList.isEmpty());
        assertFalse(lettersList.contains("A"));
        assertEquals(expectedSizeWithNoElements, lettersList.size());

        String expectedToString = "[]";
        assertEquals(expectedToString, lettersList.toString());

    }

    @Test
    @DisplayName("toString() deve imprimir um [] após a remoção de todos os elementos da lista com o removeAll()")
    void shouldReturnAnEmptyArrayAfterAllElementsHaveBeenRemovedUsingRemovaAllMethod() {

        letters.removeAll();

        String expectedToString = "[]";
        assertEquals(expectedToString, letters.toString());

    }

    @Test
    @DisplayName("size() deve retornar zero após a remoção dos elementos com o removeAll()")
    void shouldReturnZeroAfterUsingRemoveAllMethod() {

        int expectedSize = 0;

        letters.removeAll();
        assertEquals(expectedSize, letters.size());

    }

    @Test
    @DisplayName("contains() retorna false para cada valor da lista após o removeAll()")
    void shouldReturnFalseIfSpecifiedValuesAreNotPresentInsideTheListAfterRemoveAllMethod() {

        assertTrue(letters.contains("A"));
        assertTrue(letters.contains("B"));
        assertTrue(letters.contains("C"));
        assertTrue(letters.contains("D"));
        assertTrue(letters.contains("E"));

        letters.removeAll();

        assertFalse(letters.contains("A"));
        assertFalse(letters.contains("B"));
        assertFalse(letters.contains("C"));
        assertFalse(letters.contains("D"));
        assertFalse(letters.contains("E"));

    }

    @Test
    @DisplayName("get() deve retornar o valor do segundo elemento, após a remoção do primeiro")
    void shouldRemoveTheGivenValues() {

        letters.remove("A");
        assertEquals("B", letters.get(0));

    }

    @Test
    @DisplayName("contains() deve retornar false ao verificar a existência do primeiro valor após sua remoção")
    void shouldReturnFalseAfterRemoveTheFirstValueAndCheckingItsExistenceInTheList() {

        letters.remove("A");
        assertFalse(letters.contains("A"));

    }

    @Test
    @DisplayName("size() deve retornar o tamanho correto da lista após remoção do primeiro valor")
    void shouldReturnTheCorrectSizeAfterRemoveTheFirstValue() {

        int expectedSize = 4;

        letters.remove("A");
        assertEquals(expectedSize, letters.size());

    }

    @Test
    @DisplayName("size() deve retornar o tamanho correto da lista após remoção do último valor")
    void shouldReturnTheCorrectSizeAfterRemoveTheLastValue() {

        int expectedSize = 4;

        letters.remove("E");
        assertEquals(expectedSize, letters.size());

    }

    @Test
    @DisplayName("size() deve retornar o tamanho correto da lista após remoção de um valor no meio e adição de mais 2")
    void shouldReturnTheCorrectSizeAfterRemoveInTheMiddleAndAddingTwoMoreValues() {

        int expectedSize = 5;
        assertEquals(expectedSize, letters.size());

        letters.remove("C");
        expectedSize = 4;
        assertEquals(expectedSize, letters.size());

        letters.add("F");
        letters.add("G");
        expectedSize = 6;
        assertEquals(expectedSize, letters.size());

    }

    @Test
    @DisplayName("contains() deve retornar false após remoção de um valor no meio e adição de mais 2")
    void shouldReturnFalseAfterRemoveInTheMiddleAndAddingTwoMoreValues() {

        assertTrue(letters.contains("C"));

        letters.remove("C");

        assertFalse(letters.contains("C"));

        assertFalse(letters.contains("F"));
        assertFalse(letters.contains("G"));

        letters.add("F");
        letters.add("G");

        assertTrue(letters.contains("F"));
        assertTrue(letters.contains("G"));

    }

    @Test
    @DisplayName("toString() deve imprimir [A, B, D, E, F, G] após remoção de um valor no meio e adição de mais 2")
    void shouldReturnAsStringTheCommaSeparatedValuesOfTheListAfterRemoveInTheMiddleAndAddingTwoMoreValues() {

        String expectedStringAfterLetterCRemoval = "[A, B, D, E]";
        String expectedStringAfterLettersFAndGHasBeenAdded = "[A, B, D, E, F, G]";

        letters.remove("C");

        assertEquals(expectedStringAfterLetterCRemoval, letters.toString());

        letters.add("F");
        letters.add("G");

        assertEquals(expectedStringAfterLettersFAndGHasBeenAdded, letters.toString());

    }

}
