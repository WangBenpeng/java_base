package com.pengo.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author pengo
 * @description:
 * @date 2022/2/17 17:23
 */
public class LambadaDemo {
    public static void main(String[] args) {
        test2();
    }

    static void test2() {
        List<String> names = List.of("Bob", "Alice", "Tim");
//        List<Person> collect = names.stream().map(new Function<String, Person>() {
//            @Override
//            public Person apply(String s) {
//                return new Person(s);
//            }
//        }).collect(Collectors.toList());
        List<Person> collect = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(collect);
    }

    static void test1() {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
//        Arrays.sort(array, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        Arrays.sort(array,(s1,s2)->{
//            return s1.compareTo(s2);
//        });
//        Arrays.sort(array, (s1, s2) -> s1.compareTo(s2));
        Arrays.sort(array,String::compareTo);
        System.out.println(String.join(",", array));
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
