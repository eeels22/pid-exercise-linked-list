package se.sdaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LinkedListTests {

    @Test
    void addsTwoNumbers() {
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }

    @Test
    void addANumberToList() {
        LinkedList list = new LinkedList();
        list.add(5);
        String expected = "LinkedList(5)";
        assertEquals(list.toString(), expected);
    }

    @Test
    void testToStringOfEmptyList() {
        LinkedList list = new LinkedList();
        String expected = "LinkedList()";
        assertEquals(list.toString(), expected);
    }

    @Test
    void searchDataValueFound(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        // search for index of value 7, should be 2
        int expected = 2;
        assertEquals(expected, list.search(7));
    }

    @Test
    void searchDataValueNotFound(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        // search for index of value 7, should be 2
        int expected = -1;
        assertEquals(expected, list.search(4));
    }

    @Test
    void searchDataValueEmptyList(){
        LinkedList list = new LinkedList();
        // search for index of value 7, should be -1
        int expected =- 1;
        assertEquals(expected, list.search(7));
    }
}
