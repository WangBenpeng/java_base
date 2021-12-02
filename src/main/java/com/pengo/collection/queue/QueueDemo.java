package com.pengo.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pengo
 * @description:
 * @date 2021/12/2 10:48 上午
 */
public class QueueDemo {
    public static void main(String[] args) {
        test2();
    }

    /**
     * @author: pengo
     * @description: 返回true/false
     * @date: 2021/12/2 10:49 上午
     **/
    public static void test1() {
        Queue<String> strings = new LinkedList<>();
        System.out.println(strings.offer("apple"));
        System.out.println(strings.offer("banana"));
        System.out.println(strings.peek());
        System.out.println(strings.peek());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
    }

    /**
     * @author: pengo
     * @description: 抛出异常
     * @date: 2021/12/2 10:51 上午
     **/
    public static void test2() {
        try {

            Queue<String> strings = new LinkedList<>();
            System.out.println(strings.add("apple"));
            System.out.println(strings.add("orange"));
            System.out.println(strings.element());
            System.out.println(strings.element());
            System.out.println(strings.remove("banana"));
            System.out.println(strings.remove());
            System.out.println(strings.remove());
            System.out.println(strings.remove());
        } catch (Exception e) {
            System.out.println("获取失败");
        }

    }
}
