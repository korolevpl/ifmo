package com.ifmo.lesson6;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(2));
        System.out.println();

        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println(list.remove(2));
        System.out.println();


        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }

        System.out.println();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());

        System.out.println();
        /*
        Iterator<Integer> iterator2 = queue.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }

        System.out.println();
        */
        Stack stack = new LinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println();
        /*
        Iterator<Integer> iterator3 = stack.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }
        */

        List<Integer> arrayList = new ArrayList();
        for (int i=1; i<=10; i++) {
            arrayList.add(i);
        }
        for (Object val : arrayList) {
            System.out.println(val);
        }

        arrayList.add(11);
        System.out.println();

        for (Object val : arrayList) {
            System.out.println(val);
        }
        System.out.println();

        System.out.println(arrayList.get(5));
        System.out.println();

        System.out.println(arrayList.remove(5));
        System.out.println();

        for (Object val : arrayList) {
            System.out.println(val);
        }
    }
}