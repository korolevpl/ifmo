package com.ifmo.lesson7;

import java.util.LinkedList;

/**
 * Реализуйте библиотеку на основе хэш-таблицы. Для решения коллизий
 * используйте связный список (можете так же попробовать открытую адресацию).
 *
 * Библиотека помогает вести учет книг: какие книги и сколько в ней хранятся.
 * Библиотека ограничена по числу типов книг, это ограничение задается аргументом
 * конструктора maxBookKinds. Например, если библиотека ограничена числом 10,
 * то это означает, что она может хранить 10 разных книг, но любое их количество.
 *
 * Если из библиотеки убираются все книги одного типа, то освобождается место,
 * на которое можно добавить книгу другого типа.
 * Например:
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *     library.put(new Book("Stephen King", "Dark Tower"), 3); // return true
 *
 *     // Эту книгу добавить не можем, т.к. лимит 2
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return false
 *
 *     // Забираем все книги Тёмной башни, чтобы освободить место.
 *     library.take(new Book("Stephen King", "Dark Tower"), 3) // return 3
 *
 *     // Теперь мы можем успешно добавить "Войну и мир".
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return true
 * </pre>
 *
 * Если попытаться взять из библиотеки больше книг, чем у нее есть, то она
 * должна вернуть только число книг, которые в ней находились и освободить место.
 * Например:
 *
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *
 *     // Все равно вернет 2, т.к. больше нет.
 *     library.take(new Book("Stephen King", "Shining"), 10) // return 2
 * </pre>
 */
public class Library {
    // при создании объекта Library создается словарь buckets
    LinkedList<Shelf> buckets;
    int capacityBuckets; // вместимость словаря (количество элементов)
    int countBuckets; // фактическое количество элементов словаря

    public Library(int maxBookKinds) {
        buckets = new LinkedList<>();
        capacityBuckets = maxBookKinds;
        countBuckets = 0;

        for(int i=0; i<capacityBuckets; i++) {
            buckets.add(null);
        }
    }

    int getIndex(Book book) {
        int hash = book.hashCode();
        int index = hash % capacityBuckets;
        return index;
    }

    /**
     * Add books to library.
     *
     * @param book Book to add.
     * @param quantity How many books to add.
     * @return {@code True} if book successfully added, {@code false} otherwise.
     */
    public boolean put(Book book, int quantity) {
        int index = getIndex(book);

        Shelf current = buckets.get(index);

        System.out.println("index = " + index);

        Shelf item = new Shelf(book, quantity);
        if (current == null) {
            buckets.add(index, item);
            countBuckets++;
            return true;
        }

        while(current != null) {
            if (current.getBook().equals(book)) {
                current.setQuantity(current.getQuantity() + quantity);
                break;
            }
            if (current.next == null) {
                current.next = item;
                break;
            } else {
                // Когда книга отличается от искомой, переходим к следующему элементу в словаре
                current = current.next;
            }
        }
        return true;
    }

    /**
     * Take books from library.
     *
     * @param book Book to take.
     * @param quantity How many books to take.
     * @return Actual number of books taken.
     */
    public int take(Book book, int quantity) {
        int count = 0;
        int index = getIndex(book);

        System.out.println("index = " + index);

        Shelf current = buckets.get(index);

        if (current == null) {
            return count;
        }

        while(current != null) {
            if (current.getBook().equals(book)) {
                if (current.getQuantity() <= quantity) {
                    count = current.getQuantity();
                    current = null;
                } else {
                    current.setQuantity(current.getQuantity() - quantity);
                    count = quantity;
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /*
        Library library = new Library(5);

        Book wp = new Book("Tolstoy", "War and peace");
        boolean wpAdded = library.put(wp, 2);
        System.out.println(wp.toString() + " added: " + wpAdded);

        Book wp2 = new Book("Tolstoy", "War and peace");
        boolean wpAdded2 = library.put(wp2, 5);
        System.out.println(wp2.toString() + " added: " + wpAdded2);

        System.out.println();
        System.out.println(library.capacityBuckets);
        System.out.println(library.countBuckets);
        System.out.println();
        for(int i=0; i < library.capacityBuckets; i++) {
            if (library.buckets.get(i) != null) {
                System.out.println("index = " + i);
                System.out.println(library.buckets.get(i).getBook());
                System.out.println(library.buckets.get(i).getQuantity());
            }
        }
        */
        Library library = new Library(2);

        System.out.println("put: " + library.put(new Book("Stephen King", "Shining"), 2)); // return true
        System.out.println();
        System.out.println("put: " + library.put(new Book("Stephen King", "Dark Tower"), 3)); // return true
        System.out.println();
        System.out.println("put: " + library.put(new Book("Tolstoy", "War and peace"), 6)); // return false
        System.out.println();
        System.out.println("took: " + library.take(new Book("Stephen King", "Dark Tower"), 3)); // return 3
        System.out.println();
        System.out.println("put: " + library.put(new Book("Tolstoy", "War and peace"), 6)); // return true
        System.out.println();
        System.out.println("put: " + library.put(new Book("Stephen King", "Shining"), 2)); // return true
        System.out.println();
        System.out.println("took: " + library.take(new Book("Stephen King", "Shining"), 10)); // return 2
        System.out.println();
        for(int i=0; i < library.capacityBuckets; i++) {
            if (library.buckets.get(i) != null) {
                System.out.println("index = " + i);
                System.out.println(library.buckets.get(i).getBook());
                System.out.println(library.buckets.get(i).getQuantity());
            }
        }
    }
}
