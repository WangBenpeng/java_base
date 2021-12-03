package com.pengo.collection.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2021/12/3 4:59 下午
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        testSort();
    }

    public static void testSort() {
//        List<String> list = List.of("apple", "orange", "banana"); //immutable list
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("orange");
        list.add("banana");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collection<String> strings = Collections.unmodifiableCollection(list);
        System.out.println(strings);
        list.add("lemon");
        System.out.println(strings);
    }

    public static void testSingleton() {
        List<String> list1 = List.of("apple");
        List<String> list2 = Collections.singletonList("apple");
//        list2.add("banana");  //immutable list
        System.out.println(list1);
        System.out.println(list2);
    }
}
