package com.pengo.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author pengo
 * @description:
 * @date 2021/12/2 11:13 上午
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test2() {
        PriorityQueue<String> strings = new PriorityQueue<>();
        strings.add("apple");
        strings.add("orange");
        strings.add("banana");
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
    }

    public static void test1() {
        PriorityQueue<User> users = new PriorityQueue<>(new UserComparator());
        users.add(new User("Bob", "A1"));
        users.add(new User("Alice", "A2"));
        users.add(new User("Carl", "A11"));
        users.add(new User("Boss", "V1"));
        System.out.println(users.poll());
        System.out.println(users.poll());
        System.out.println(users.poll());
        System.out.println(users.poll());
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        //相同级别
        if (o1.number.charAt(0) == o2.number.charAt(0)) {
            if (o1.number.length() > o2.number.length()) {
                return 1;
            }
            return o1.number.compareTo(o2.number);
        }
        if (o1.number.charAt(0) == 'V') {
            return -1;
        } else {
            return 1;
        }
    }
}

class User{
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + "/" + number;
    }
}
