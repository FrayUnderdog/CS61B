public class ArrayDeque<T> {

    /** Declare variables */
    private int size;
    private T[] items;
    // the index of first element
    private int head;
    // tail = next position to insert element
    private int tail;
    private float loadFactor;

    /** Constructor */
    public ArrayDeque () {
        items = (T[]) new Object[8];
        head = tail = 0;
        size = 0;
    }

    private int circularIndex(int index) {
        return (index + items.length) % items.length;
    }

    /** add an item into start of ArrayDeque */
    public void addFirst (T item) {
        // check if space of items is enough
        if (size == items.length) {
            resize(size * 2);
        }

        // + items.length to prevent -1 index out of bound
        head = circularIndex(head - 1);
        items[head] = item;
        // head = the first element
        size ++;
    }

    /** add an item into end of ArrayDeque */
    public void addLast (T item) {
        // check if space of items is enough
        if (size == items.length) {
            resize(size * 2);
        }

        // tail = the next position to insert newLast element
        items[tail] = item;
        tail = circularIndex(tail + 1);
        size ++;
    }

    /** remove the first item of ArrayDeque */
    public T removeFirst() {
        // empty ArrayDeque
        if (size == 0) {
            return null;
        }
        // check if loadFactor is appropriate
        if (getLoadFactor() < 0.25 && items.length >= 16) {
            resize(items.length / 2);
        }
        T retVal = items[head];
        head = circularIndex(head + 1);
        size --;
        return retVal;
    }

    /** remove the last item of ArrayDeque */
    public T removeLast() {
        // empty ArrayDeque
        if (size == 0) {
            return null;
        }
        // check if loadFactor is appropriate
        if (getLoadFactor() < 0.25 && items.length >= 16) {
            resize(items.length / 2);
        }
        T retVal = items[circularIndex(tail - 1)];
        tail = circularIndex(tail - 1);
        size --;
        return retVal;
    }

    /** get the item of index input */
    public T get (int index) {
        // index out of bounds
        if (index < 0 || index >= size) {
            return null;
        }

        // (head + index) maybe exceed the back bound of array
        return items[circularIndex(head + index)];
    }

    private T getRecursive (int index) {
        return getRecursiveHelper(head, index);
    }

    private T getRecursiveHelper (int ptr, int index) {
        if (index == 0) {
            return items[ptr];
        }
        ptr ++;
        return getRecursiveHelper(ptr, index - 1);
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            // circle index
            System.out.print(items[(head + i)] + " ");
        }
    }

    /** return size of deque */
    public int size () {
        return size;
    }

    /** resize when space isn't enough or too sparse */
    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        // copy every element from items to newItems
        for (int i = 0; i < size; i ++) {
            // head + i may exceed back bound, so circle index needed
            newItems[i] = items[circularIndex(head + i)];
        }
        head = 0;
        tail = size;  // tail = next position to insert element
        items = newItems;
    }

    private float getLoadFactor() {
        return (float) size / items.length;
    }

    public boolean isEmpty () {
        return size == 0;
    }
}
