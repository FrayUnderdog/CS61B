public class LinkedListDeque<T> {
    private Node sentinal;
    private int size;

    private class Node {
        protected T item;
        protected Node pre;
        protected Node next;

        public Node() {
            item = null;
            pre = next = null;
        }

        public Node(T item, Node preNode, Node nextNode) {
            this.item = item;
            this.pre = preNode;
            this.next = nextNode;
        }
    }

    /** Constructor for empty LLD
     * sentinal.next is the first node*/
    public LinkedListDeque() {
        this.size = 0;
        sentinal = new Node(null, null,null);
        sentinal.pre = sentinal;
        sentinal.next = sentinal;
    }

    /** Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        // sentinal <- newFirst, newFirst -> oldFirst
        Node newFirst = new Node(item, sentinal, sentinal.next);
        // sentinal -> newFirst
        sentinal.next = newFirst;
        sentinal.next.next.pre = newFirst;

        size ++;
    }

    /** Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        // Invariant: snetinel.pre = last
        // oldLast <- newLast -> sentinel
        Node newLast = new Node(item, sentinal.pre, sentinal);
        // oldLast -> newLast
        sentinal.pre.next = newLast;
        // sentinel -> newLast
        sentinal.pre = newLast;

        size ++;
    }

    /** return the last node of LLD, aka last.next == sentinal */
    private Node getLast() {
        // LLD is empty
        if (sentinal.next == sentinal) {
            return null;
        }

        Node last = sentinal.next;
        while (last.next != sentinal) {
            last = last.next;
        }
        return last;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space */
    public void printDeque() {
        Node ptr = sentinal.next;
        while (ptr != sentinal) {
            System.out.print(ptr.item);
            System.out.print(" ");
            ptr = ptr.next;
        }
    }

    /**  Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        // LLD is empty
        if (size == 0) {
            return null;
        }
        Node retVal = sentinal.next;
        // sentinal point to the second
        sentinal.next = sentinal.next.next;
        // second aka the new first should also point back to sentinal
        sentinal.next.pre = sentinal;

        size --;
        return retVal.item;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null */
    public T removeLast() {
        // if LLD is empty
        if (size == 0) {
            return null;
        }
        Node last = sentinal.pre;
        // iterate newLast from head to second last
        Node newLast = last.pre;
        newLast.next = sentinal;
        sentinal.pre = newLast;

        size --;
        return last.item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        // LLD is empty
        if (size == 0) {
            return null;
        }
        // index out of bound
        if (index < 0 || index >= size) {
            return null;
        }
        Node retPtr = sentinal.next;
        for (int i = 0; i < index; i++) {
            retPtr = retPtr.next;
        }
        return retPtr.item;
    }

    /** inplement get() function recursively */
    public T getRecursive(int index) {
        // LLD is empty
        if (size == 0) {
            return null;
        }
        // index out of bound
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinal.next, index);
    }

    private T getRecursiveHelper (Node node, int index) {
        // base case
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
