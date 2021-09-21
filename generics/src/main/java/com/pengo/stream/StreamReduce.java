package com.pengo.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author pengo
 * @description:
 * @date: 2021/9/21
 */
public class StreamReduce
{
  public static void main(String[] args)
  {
    testMap();
  }

  public static void testMap()
  {
    List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
    Map<String, String> map = props.stream().map(kv ->
    {
      String[] split = kv.split("\\=", 2);
      return Map.of(split[0], split[1]);
    }).reduce(new HashMap<>(), (m, kv) ->
    {
      m.putAll(kv);
      return m;
    });
    map.forEach(new BiConsumer<String, String>()
    {
      @Override
      public void accept(String s, String s2)
      {
        System.out.println(s + ":" + s2);
      }
    });

    map.forEach((k,v) -> {
      System.out.println(k + "::" + v);
    });
  }

  public static void test2()
  {
    Optional<Integer> reduce = Stream.of(1, 2, 3).filter(i -> i > 3).reduce(Integer::sum);
    reduce.ifPresent(System.out::println);

    Integer reduce1 = Stream.of(1, 2, 3, 4, 5).reduce(1, (acc, n) -> acc * n);
    System.out.println(reduce1);
  }

  public static void test1()
  {
    Integer reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, new BinaryOperator<Integer>()
    {
      @Override
      public Integer apply(Integer integer, Integer integer2)
      {
        return integer + integer2;
      }
    });
    System.out.println(reduce);
    Integer reduce1 = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);
    System.out.println(reduce1);
  }
}
