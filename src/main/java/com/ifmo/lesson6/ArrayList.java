package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Этот класс должен реализовывать следующие методы: add(), get(), remove() и iterator() из интерфейса List.
 * Если при выполнении add() в массиве нет свободных элементов, то создать новый - вдвое больше,
 * скопировать в него все значения из старого и + 1, который сейчас добавляется.
 * Удаление должно сдвинуть все элементы влево, если это требуется.
 * Например, если список с такими элементами:
 * |0|1|2|3|4|5|
 * Удаляем элемент по индексу 2:
 * |0|1|_|3|4|5|
 * Перемещаем все элементы влево:
 * |0|1|3|4|5|_|
 * Теперь при итерации по ним после 1 будет идти сразу 3, как в связном списке.
 */
public class ArrayList implements List {
    private static final int DEFAULT_SIZE = 10;
    private int itemCount;
    private Object[] values;

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {
        values = new Object[initialSize];
    }

    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        Object item = new Item(val);
        int len = values.length;
        if (values[0] == null) {
            values[0] = item;
        } else if (values[len-1] != null) {
            Object[] temp = new Object[values.length * 2];
            System.arraycopy(values, 0, temp, 0, values.length);
            values = temp;
            values[len] = item;
        } else {
            for (int i = 1; i < len; i++) {
                if (values[i] == null) {
                    values[i] = item;
                    break;
                }
            }
        }
        itemCount++;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        if(i >= itemCount) {
            return null;
        } else {
            return values[i];
        }
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int i) {
        if(i >= itemCount) {
            return null;
        } else {
            Object item = values[i];
            System.arraycopy(values, i+1, values, i, values.length - (i+1));
            itemCount--;
            return item;
        }
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public Object next() {
                if(hasNext()) {
                    return values[index++];
                }
                return null;
            }
        };
        return iterator;
    }
}
