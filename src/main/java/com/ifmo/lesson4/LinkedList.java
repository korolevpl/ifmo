package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        Item item = new Item(val);
        if (head == null) {
            head = item;
        } else {
            Item current = head;
            while(true) {
                if(current.next == null) {
                    current.next = item;
                    break;
                }
                current = current.next;
            }
        }
    }

    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */

    public Object get(int i) {
        Item current = head;

        for (int j = 0; current != null; j++) {
            if (j == i) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Object remove(int i) {
        if (head == null) {
            return null;
        }

        if (i == 0) {
            Object val = head.value;
            head = head.next;
            return val;
        }

        Item previous = head;
        for (int j = 0; previous != null; j++) {
            if (j + 1 == i) {
                if (previous.next == null) {
                    return null;
                }
                Item current = previous.next;
                Object val = current.value;
                previous.next = current.next;
                return val;
            }
            previous = previous.next;
        }
        return null;
    }
}
