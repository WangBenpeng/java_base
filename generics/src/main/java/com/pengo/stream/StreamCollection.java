package com.pengo.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pengo
 * @description:
 * @date: 2021/9/21
 */
public class StreamCollection
{
  public static void main(String[] args)
  {
    test4();
  }

  public static void test5()
  {
    
  }

  public static void test4()
  {
    Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
    Map<String, String> map = stream.collect(Collectors.toMap(s -> s.substring(0, s.indexOf(":")), s -> s.substring(s.indexOf(":") + 1)));
    System.out.println(map);
    Stream<String> stream2 = Stream.of("APPL:Apple", "MSFT:Microsoft");
    Collector<String, ?, Map<String, String>> stringMapCollector = Collectors.toMap(new Function<String, String>()
    {
      @Override
      public String apply(String s)
      {
        return s.substring(0, s.indexOf(":"));
      }
    }, new Function<String, String>()
    {
      @Override
      public String apply(String s)
      {
        return s.substring(s.indexOf(":") + 1);
      }
    });
    stream2.collect(stringMapCollector).forEach((k,v) -> {
      System.out.println(k + ":::" + v);
    });
  }

  public static void test3()
  {
    List<String> list = List.of("Apple", "Banana", "Orange");
    list.stream().toArray(String[]::new);
    String[] strings = list.stream().toArray(new IntFunction<String[]>()
    {
      @Override
      public String[] apply(int value)
      {
        return new String[value];
      }
    });
    System.out.println(String.join(",", strings));
  }

  public static void test2()
  {
    Stream<String> stream = Stream.of("Apple", null, "Pear", "", "  ", "Orange");
    List<String> collect = stream.filter(s -> s != null).filter(s -> !s.isBlank()).collect(Collectors.toList());
    System.out.println(collect);
  }

  public static void test1()
  {
    Stream<Long> s1 = Stream.generate(new NaturalSupplier());
    Stream<Long> s2 = s1.map(n -> n * n);
    Stream<Long> s3 = s2.map(n -> n - 1);
    Stream<Long> s4 = s3.limit(10);
    Long reduce = s4.reduce(0L, (acc, n) -> acc + n);
    System.out.println(reduce);
  }
}

class NaturalSupplier implements Supplier<Long>
{
  long n = 0;
  @Override
  public Long get()
  {
    n++;
    return n;
  }
}
