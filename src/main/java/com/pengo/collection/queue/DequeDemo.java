package com.pengo.collection.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author pengo
 * @description:
 * @date 2021/12/2 11:41 上午
 */
public class DequeDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("apple");
        deque.offerLast("orange");
        deque.offerFirst("banana");
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
    }
}
