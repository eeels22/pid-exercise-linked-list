package se.sdaproject;

/**
 * Holds a piece of data (int) and a reference to the next node.
 */
class Node {
    // field 1: the data
    // in our case just an integer
    int elem;
    // field 2: the reference to the next node
    Node next;

    Node(int num) {
        this.elem = num;
        this.next = null;
    }
}

/**
 * A chain of nodes which has a first node which points to th next node and so on.
 */
public class LinkedList {

    private Node first = null;
    private int size = 0;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(7);
        list.add(3);
        list.add(2);
        list.toString();
    }

    /**
     * Adds a node storing the specified number to the end of linked list
     */
    public void add(int num) {
        // int num is available!

        // step 1: is the linked list still empty?
        if (first == null) {
            // in this case, the linked list is empty
            Node node = new Node(num); // node.next == null
            first = node;
            size = 1;
        } else {
            // in this case, the linked list is *not* empty
            // this means, first != null

            // step 2: find the last node

            // Key: introduce a temporary variable!
            // we can then update this temporary variable,
            // without changing "first"!
            // important, since "first" should not be changed!
            Node current = first;
            while (current.next != null) { // current is not the last node!
                current = current.next;
            }
            // what do we know about "current"?
            // current.next == null
            // AWESOME!
            // it means, "current" is the last node!

            // step 3: create a new node with the given int "num"
            Node node = new Node(num);

            // step 4: change the reference of the last node to
            // point to the new node
            current.next = node;
            size += 1;
        }

    }

    /**
     * Returns the linked list as a string in the format: LinkedList(elem1, elem2...)
     * Useful for testing
     *
     * @return the linked list contents as a string
     */
    public String toString() {
        // goal is to return a string like this:
        // "LinkedList(5,2,10)"

        StringBuilder builder = new StringBuilder();

        // call methods on "builder" to add strings

        builder.append("LinkedList(");
        // append strings for each integer in the list

        if (first == null) {
            // what to do here?
            // string to be returned: "LinkedList()"
            // nothing left to do!
        } else {
            // here, we know that first != null
            // go through the chain of nodes, starting with
            // "first"

            Node current = first;
            // treat first element specially:
            builder.append("" + current.elem);

            while (current.next != null) {
                current = current.next;
                builder.append("," + current.elem);
            }
            // current.next == null
            // we have already appended the last num!
        }

        // append ")"
        builder.append(")");
        return builder.toString();
    }

    /**
     * Searches for some data based on its value.
     * If we find the element the function should return the index,
     * otherwise it should return -1.
     *
     * @return the index where the value is held, or -1 if not found
     */
    public int search(int num) {

        if (first == null) {
            // skip to return -1 if list is empty
        } else {
            boolean searching = true;
            Node current = first;
            int index = -1;

            while (searching) {
                index++;
                if (current.elem == num) {
                    return index; // return the index if is is a match
                } else { // go to the next node if there is one
                    if (current.next != null) {
                        current = current.next;
                    } else {
                        searching = false; // searched all nodes without success
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Gets an element based on its index
     * (ie its position in the chain of nodes)
     *
     * @return elem (data) at that index
     * @throws IndexOutOfBoundsException if the specified index is not valid
     */
    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0) { // index is invalid
            throw new IndexOutOfBoundsException("That index is out of range.");
        } else {
            boolean searching = true;
            Node current = first;
            int currentIndex = -1;
            while (searching) { // loop until the specified index or end of list
                currentIndex++;
                if (currentIndex == index) { // reached specified index
                    return current.elem;
                } else {
                    if (current.next != null) { // go to the next node if there is one
                        current = current.next;
                    } else {
                        searching = false; // stop searching at the end
                    }
                }
            }
        }
        // index is higher than max
        throw new IndexOutOfBoundsException("The index is too high.");
    }

    /**
     * Returns the number of nodes in this list by counting each node
     *
     * @return the size of the list
     * @Deprecated use getSize method instead
     */
    public int size() {
        if (first == null) { // list is empty
            return 0;
        } else { // list not empty
            Node current = first;
            int size = 1;
            while (current.next != null) {
                size++; // count the next node if there is one
                current = current.next;
            }
            return size;
        }
    }

    /**
     * Returns the size field of the linked list
     *
     * @return the size of the list
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Removes the node at the specified index and returns its element (data)
     *
     * @param index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public int remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > (getSize() - 1)) {
            throw new IndexOutOfBoundsException("The index is out of range or the list is empty.");
        }

        int tempElem; // stores data of node to be removed

        if (index == 0 && getSize() > 1) { // remove first node and update the first reference
            tempElem = first.elem;
            first = first.next; // next node becomes the first
        } else if (index == 0 && getSize() == 1) { // list emptied so no first node
            tempElem = first.elem;
            first = null;
        } else if (index == getSize() - 1) { // remove last node
            tempElem = getNode(index - 1).elem;
            getNode(index - 1).next = null;
        } else { // remove a middle node
            tempElem = getNode(index - 1).elem;
            getNode(index - 1).next = getNode(index - 1).next.next; // previous node's next becomes the one after the removed node
        }
        size -= 1;
        return tempElem;
   }


        /**
         * Gets a Node based on its index.
         *
         * @return the Node at that index
         * @throws NullPointerException      if the list is empty
         * @throws IndexOutOfBoundsException if the specified index is not valid
         */
        private Node getNode ( int index) throws NullPointerException, IndexOutOfBoundsException {
            if (first == null) {
                throw new NullPointerException("The list is empty.");
            } else if (index < 0) {
                throw new IndexOutOfBoundsException("The index should be 0 or higher.");
            } else {
                boolean notReachedEndOfList = true;
                Node current = first;
                int currentIndex = -1;
                while (notReachedEndOfList) {
                    currentIndex++;
                    if (currentIndex == index) {
                        return current;
                    } else {
                        if (current.next != null) {
                            current = current;
                        } else {
                            notReachedEndOfList = false;
                        }
                    }
                }
            }
            throw new IndexOutOfBoundsException("That index is too high.");
        }
    }