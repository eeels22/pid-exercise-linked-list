package se.sdaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void getElementByValidIndex(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        int expected = 3;
        assertEquals(expected, list.get(1));
    }

    @Test
    void getLastElementByValidIndex(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        int expected = 7;
        assertEquals(expected, list.get(2));
    }

    @Test
    void getFirstElementByValidIndex(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        int expected = 5;
        assertEquals(expected, list.get(0));
    }

    @Test
    void getElementByInvalidIndexShouldThrowException(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(4);
        });
    }

    @Test
    void getElemByNegativeIndexShouldThrowException(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-2);
        });
    }

    @Test
    void getElemFromEmptyListShouldThrowException(){
        LinkedList list = new LinkedList();
        assertThrows(NullPointerException.class, () -> {
            list.get(4);
        });
    }

    @Test
    void getNodeByValidIndex(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        int expected = 3;
        assertEquals(expected, list.getNode(1).elem);
    }

    @Test
    void checkSizeOfLinkedList() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1);
        assertEquals(5, list.size());
    }

    @Test
    void checkSizeOfEmptyLinkedList() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
    }

    @Test
    void checkGetSizeOfEmptyLinkedList() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.getSize());
    }

    @Test
    void checkGetSizeOfLinkedList() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1);
        assertEquals(5, list.getSize());
    }

    @Test
    void checkRemovalOfFirstNode() {
        LinkedList list = new LinkedList();
        list.add(5); // to be removed
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1);
        assertEquals(5, list.remove(0));
        assertEquals(3, list.get(0));
        assertEquals(4, list.getSize());
    }

    @Test
    void checkRemovalOfMiddleNode() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9); // to be removed
        list.add(1);
        list.remove(3);
//        assertEquals(9, list.remove(3));
        assertEquals(1, list.get(3));
        assertEquals(4, list.getSize());
    }

    @Test
    void checkRemovalOfLastNode() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1); // to be removed
        int elem = list.remove(4);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(4);
        });
        assertEquals(4, list.getSize());
        assertEquals(1, elem);
    }

    @Test
    void checkInvalidRemoval() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(10);
        });
    }

}
