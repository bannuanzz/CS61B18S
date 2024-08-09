public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length*2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length*2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = (nextFirst + 1) % items.length;
        for (int j = 0; j < size; j++) {
            System.out.println(items[(i + j) % items.length]);
        }

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;

    }

    public T removeLast() {

        if (isEmpty()) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T item = items[nextLast];
        items[nextLast] = null;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int actualIndex = (nextFirst + 1 + index) % items.length;
        return items[actualIndex];
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int currFirst = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(currFirst + i) % items.length];
        }
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }
}
