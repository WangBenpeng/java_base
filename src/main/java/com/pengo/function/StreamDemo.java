package com.pengo.function;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pengo
 * @description:
 * @date 2022/2/18 09:57
 */
public class StreamDemo {
    public static void main(String[] args) {
        test12();
    }

    static void test12() {
        List<String> list = List.of("Orange", "apple", "Banana")
                .stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        System.out.println(list);
        List<String> list2 = List.of("A", "B", "A", "C", "B", "D")
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list2);
        List<String> collect = List.of("A", "B", "C", "D", "E", "F")
                .stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect);
        Stream<String> s1 = List.of("A", "B", "C").stream();
        Stream<String> s2 = List.of("D", "E").stream();
        List<String> collect1 = Stream.concat(s1, s2).collect(Collectors.toList());
        System.out.println(collect1);

        Stream<List<Integer>> s = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        List<Integer> collect2 = s.flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(collect2);
    }

    static void test11() {
        List<String> list = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
//        Map<String, List<String>> map = list.stream()
//                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        Map<String, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.substring(0, 1);
                    }
                }, Collectors.toList()));
        System.out.println(map);
    }

    static void test10() {
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
//        Map<String, String> map = stream.collect(Collectors.toMap(
//                s -> s.substring(0, s.indexOf(":")),
//                s -> s.substring(s.indexOf(":") + 1)
//        ));
        Map<String, String> map = stream.collect(Collectors.toMap(
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.substring(0, s.indexOf(":"));
                    }
                }, new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.substring(s.indexOf(":") + 1);
                    }
                }
        ));
        System.out.println(map);
    }

    static void test9() {
        List<String> list = List.of("Apple", "Banana", "Orange");
//        String[] strings = list.stream().toArray(String[]::new);
        String[] strings = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        for (String string : strings) {
            System.out.println(string);
        }
    }

    static void test8() {
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> collect = stream.filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        System.out.println(collect);
    }

    static void test7() {
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
//        Map<String, String> map = props.stream()
//                .map(kv -> {
//                    String[] split = kv.split("=");
//                    return Map.of(split[0], split[1]);
//                })
//                .reduce(new HashMap<>(), (m, kv) -> {
//                    m.putAll(kv);
//                    return m;
//                });
        Stream<String> stream = props.stream();
        Stream<Map<String, String>> mapStream = stream.map(new Function<String, Map<String, String>>() {
            @Override
            public Map<String, String> apply(String s) {
                String[] split = s.split("=");
                Map<String, String> map = Map.of(split[0], split[1]);
                return map;
            }
        });
        Map<String, String> map = mapStream.reduce(new HashMap<>(), new BinaryOperator<Map<String, String>>() {
            @Override
            public Map<String, String> apply(Map<String, String> map1, Map<String, String> map2) {
                map1.putAll(map2);
                return map1;
            }
        });
        map.forEach((k,v) -> {
            System.out.println(k + " : " + v);
        });
    }

    static void test6() {
        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(reduce);
    }

    static void test5() {
        Stream.generate(new LocalDateSupplier())
                .limit(31)
                .filter(localDate -> localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }

    static void test4() {
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }

    static void test3() {
        List.of(" Apple   ","Banana  ","  OraNge")
                .stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    static void test2() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> integerStream1 = integerStream.map(n -> n * n);
        integerStream1.forEach(System.out::println);
    }

    static void test1() {
        Stream<Long> s1 = Stream.generate(new FibonacciSupplier());
        Stream<Long> s2 = s1.limit(9);
        s2.forEach(System.out::println);
    }
}

class FibonacciSupplier implements Supplier<Long> {
    int n = 0;
    @Override
    public Long get() {
        n++;
        return create(n);
    }

    long create(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        return create(n - 1) + create(n - 2);
    }
}

class LocalDateSupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2022, 2, 1);
    int n = -1;

    @Override
    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
