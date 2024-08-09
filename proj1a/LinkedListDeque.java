public class LinkedListDeque<T> {


    public class Node {
        T item;
        Node next;
        Node prev;

        Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
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

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }


    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);

    }

    public void addFirst(T item) {

        Node p = new Node(item, null, null);
        if (sentinel.next == sentinel) {
            p.next = sentinel;
            sentinel.prev = p;
        } else {
            sentinel.next.prev = p;
            p.next = sentinel.next;
        }
        p.prev = sentinel;
        sentinel.next = p;
        size++;
    }

    public void addLast(T item) {
        Node p = new Node(item, null, null);
        if (sentinel.next == sentinel) {
            p.prev = sentinel;
            sentinel.next = p;
        } else {
            p.prev = sentinel.prev;
            sentinel.prev.next = p;
        }
        p.next = sentinel;
        sentinel.prev = p;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != null) {
            System.out.println(p.item);
            p = p.next;
        }
    }

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
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinel.prev;
        if (size == 1) {
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
        } else {
            p.prev.next = sentinel;
            sentinel.prev = p.prev;
        }
        p.prev = null;
        p.next = null;
        size--;
        return p.item;

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int i = 0;
        Node p = sentinel.next;
        while (i != index) {
            p = p.next;
            i++;
        }
        return p.item;
    }
}
