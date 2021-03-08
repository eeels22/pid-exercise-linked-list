package se.sdaproject;

// a "box" in our previous picture
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


public class LinkedList {

    private Node first = null;

    public void add(int num) {
        // int num is available!

        // step 1: is the linked list still empty?
        if (first == null) {
            // in this case, the linked list is empty
            Node node = new Node(num); // node.next == null
            first = node;
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
        }

    }

    // useful for testing!
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

    // Search for some data based on its value.
    // If we find the element the function should return the index,
    // otherwise it should return -1.
    public int search(int num) {

        if (first == null) {
            // return -1 if list is empty
            return -1;
        } else {
            // search each node for a match.
            boolean reachedEndOfList = true;
            Node current = first;
            int index = -1;
            // loop while we hav
            while (reachedEndOfList) {
                // keep track of indec as we search the nodes
                index++;
                if (current.elem == num) {
                    // return the index if is is a match
                    return index;
                } else {
                    // go to the next node if there is one
                    if (current.next != null) {
                        current = current.next;
                    } else {
                        reachedEndOfList = false;
                    }
                }
            }
            // we have reached the end of the list with no match
            return -1;
        }
    }


    // gets an element based on its index
    // (ie its position in the chain of nodes)
    // throws an exception is the index is not valid
    public int get(int index) throws NullPointerException {
        // throw an exception if the list is empty
        if (first == null) {
            throw new NullPointerException("The list is empty.");
        } else if (index < 0) {
            // throw an exception if the specified index is less than 0
            throw new IndexOutOfBoundsException("The index should be 0 or higher.");
        } else {
            boolean notReachedEndOfList = true;
            Node current = first;
            int currentIndex = -1;

            // loop until you reach the specified index.
            while (notReachedEndOfList) {
                currentIndex++;
                if (currentIndex == index) {
                    // return the elem at the current node is the indices match
                    return current.elem;
                } else {
                    // go to the next node if there is one
                    if (current.next != null) {
                        current = current.next;
                    } else {
                        notReachedEndOfList = false;
                    }
                }
            }
        }
        // throw an exception if the specified index is higher than max index
        throw new IndexOutOfBoundsException("That index is too high.");
    }


    // Returns the number of nodes in this list
    public int size() {
        // is the list empty?
        if (first == null) {
            return 0;
        } else {
            Node current = first;
            int size = 1;
            while (current.next != null) {
                // count the next node
                size++;
                // go to the next node
                current = current.next;
            }
            return size;
        }

    }
}