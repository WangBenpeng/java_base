package com.pengo.stream;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author pengo
 * @description:
 * @date: 2021/9/21
 */
public class StreamMap
{
  public static void main(String[] args)
  {
    test3();
  }

  public static void test3()
  {
    List.of("2021-09-21")
      .stream()
      .map(new Function<String, LocalDate>()
      {
        @Override
        public LocalDate apply(String s)
        {
          return LocalDate.parse(s);
        }
      })
      .forEach(System.out::println);
  }

  public static void test2()
  {
    List.of("Apple", "  pear ", " ORANGE", " B aN a Na")
      .stream()
      .map(String::trim)
      .map(String::toUpperCase)
      .forEach(System.out::println);
  }

  public static void test1()
  {
    Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
    Stream<Integer> s2 = s.map(new Function<Integer, Integer>()
    {
      @Override
      public Integer apply(Integer integer)
      {
        return integer * integer;
      }
    });
    s2.forEach(System.out::println);
    System.out.println("-------");
    Stream<Integer> ss = Stream.of(1, 2, 3, 4, 5);
    Stream<Integer> s3 = ss.map(n -> n * n);
    s3.forEach(System.out::println);
  }
}
