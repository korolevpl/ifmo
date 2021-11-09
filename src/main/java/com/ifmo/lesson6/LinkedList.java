package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList<T> implements List<T>, Stack<T>, Queue<T> {
    /** Ссылка на первый элемент списка. */
    private Item<T> head;

    /** {@inheritDoc} */
    @Override
    public void add(T val) {
        Item<T> item = new Item<T>(val);
        if (head == null) {
            head = item;
        } else {
            Item<T> current = head;
            while(true) {
                if(current.next == null) {
                    current.next = item;
                    break;
                }
                current = current.next;
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public T take() {
        if (head == null) {
            return null;
        } else {
            T val = head.value;
            head = head.next;
            return val;
        }
    }

    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        Item<T> current = head;

        for (int j = 0; current != null; j++) {
            if (j == i) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        if (head == null) {
            return null;
        }

        if (i == 0) {
            T val = head.value;
            head = head.next;
            return val;
        }

        Item<T> previous = head;
        for (int j = 0; previous != null; j++) {
            if (j + 1 == i) {
                if (previous.next == null) {
                    return null;
                }
                Item<T> current = previous.next;
                T val = current.value;
                previous.next = current.next;
                return val;
            }
            previous = previous.next;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<T> iterator() {
        LinkedListIterator<T> iterator = new LinkedListIterator<T>(head);
        return iterator;
    }

    /** {@inheritDoc} */
    @Override
    public void push(T value) {
        Item<T> item = new Item<T>(value);
        if (head == null) {
            head = item;
        } else {
            Item<T> current = head;
            while(true) {
                if(current.next == null) {
                    current.next = item;
                    break;
                }
                current = current.next;
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public T pop() {
        if (head == null) {
            return null;
        } else if(head.next == null) {
            Item<T> current = head;
            head = null;
            return current.value;
        } else {
            Item<T> current = head.next;
            Item<T> previous = head;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            return current.value;
        }
    }

    private static class LinkedListIterator<T> implements Iterator<T> {
        private Item<T> cursor;

        public LinkedListIterator(Item<T> cursor) {
            this.cursor = cursor;
        }

        public boolean hasNext() {
            return cursor != null;
        }

        public T next() {
            if(hasNext()) {
                T val = cursor.value;
                cursor = cursor.next;
                return val;
            }
            return null;
        }
    }

}
