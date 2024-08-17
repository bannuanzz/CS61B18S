public class LinkedListDeque<T> implements Deque<T> {
    public class Node {
        T item;
        Node next;
        Node prev;

        Node(T item, Node next, Node prev) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node p = new Node(item, null, null);
        if (size == 0) {
            sentinel.prev = p;
            p.next = sentinel;
        } else {
            p.next = sentinel.next;
            sentinel.next.prev = p;
        }
        p.prev = sentinel;
        sentinel.next = p;
        size++;
    }


    @Override
    public void addLast(T item) {
        Node p = new Node(item, null, null);
        if (size == 0) {
            sentinel.next = p;
            p.prev = sentinel;
        } else {
            p.prev = sentinel.prev;
            sentinel.prev.next = p;
        }
        p.next = sentinel;
        sentinel.prev = p;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p != null) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinel.next;
        if (size == 1) {
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        } else {
            sentinel.next = p.next;
            p.next.prev = sentinel;

        }
        p.next = null;
        p.prev = null;
        size--;
        return p.item;

    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinel.prev;
        if (size == 1) {
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        } else {
            sentinel.prev = p.prev;
            p.prev.next = sentinel;
        }
        p.next = null;
        p.prev = null;
        size--;
        return p.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        int i = 0;
        Node p = sentinel.next;
        while (i < index) {
            i++;
            p = p.next;
        }
        return p.item;
    }

}
