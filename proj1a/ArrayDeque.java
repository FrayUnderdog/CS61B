public class ArrayDeque<T> {

    /** Declare variables */
    private int size;
    private T[] items;
    private int head;
    private int tail;
    private float loadFactor;

    /** Constructor */
    public ArrayDeque () {
        items = (T[]) new Object[8];
        head = tail = 0;
        size = 0;
    }

    private int circularIndex(int index) {
        return index % items.length;
    }

    /** add an item into start of ArrayDeque */
    public void addFirst (T item) {
        // check if space of items is enough
        if (size == items.length) {
            resize(size * 2);
        }

        // + items.length to prevent -1 index out of bound
        head = circularIndex(head + items.length - 1);
        items[head] = item;
        size ++;
    }

    /** add an item into end of ArrayDeque */
    public void addLast (T item) {
        // check if space of items is enough
        if (size == items.length) {
            resize(size * 2);
        }

        tail = circularIndex(tail + 1);
        items[tail] = item;
        size ++;
    }

    /** remove the first item of ArrayDeque */
    public T removeFirst() {
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
        // check if loadFactor is appropriate
        if (getLoadFactor() < 0.25 && items.length >= 16) {
            resize(items.length / 2);
        }
        T retVal = items[tail];
        head = circularIndex(tail + items.length - 1);
        size --;
        return retVal;
    }

    /** get the item of index input */
    public T get (int index) {
        // index out of bounds
        if (index < 0 || index >= size) {
            return null;
        }

        int retIndex = head;
        for (int i = 0; i < index; i++) {
            retIndex ++;
        }

        return items[retIndex];
    }

    public T getRecursive (int index) {
        getRecursiveHelper(head, index);
    }

    private T getRecursiveHelper (int ptr, int index) {
        if (index == 0) {
            return items[ptr];
        }
        ptr ++;
        return getRecursiveHelper(ptr, index - 1);
    }

    /** return size of deque */
    public int size () {
        return size;
    }

    /** resize when space isn't enough or too sparse */
    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        int ptr = head;
        for (int i = 0; i < size; i ++) {
            newItems[i] = items[ptr];
            ptr ++;
        }
        head = 0;
        tail = head + newSize;
        items = newItems;
        size = newSize;
    }

    private float getLoadFactor() {
        return (float) size / items.length;
    }
}
