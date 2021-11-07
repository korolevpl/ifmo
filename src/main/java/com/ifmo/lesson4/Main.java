package com.ifmo.lesson4;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        printList(list, 3);
        list.add("row 1");
        list.add("row 2");
        list.add("row 3");
        printList(list, 3);
        Object removed = list.remove(2);
        /*
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
         */
    }

    private static void printList(LinkedList list, int len) {
        for(int i=0; i<=len; i++) {
            System.out.println(list.get(i));
        }
    }
}
