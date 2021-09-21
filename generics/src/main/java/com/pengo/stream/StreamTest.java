package com.pengo.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author pengo
 * @description:
 * @date: 2021/9/20
 */
public class StreamTest
{
  public static void main(String[] args)
  {
    test7();
  }

  public static void test7()
  {
    Stream<Integer> generate = Stream.generate(new FibonacciSupplier());
    generate.limit(10).forEach(System.out::println);
  }

  public static void test6()
  {
    IntStream is = Arrays.stream(new int[]{1, 2, 3});
    LongStream ls = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);
    is.forEach(System.out::println);
    ls.forEach(System.out::println);
  }

  public static void test5()
  {
    Pattern p = Pattern.compile("\\s+");
    Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
    s.forEach(System.out::println);
  }

  public static void test4()
  {
    try(Stream<String> lines = Files.lines(Paths.get("generics/src/main/resources/TestStream.txt"))){
      lines.forEach(System.out::println);
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }

  public static void test3()
  {
    Stream<Integer> natual = Stream.generate(new NatualSupplier());
    natual.limit(20).forEach(System.out::println);
  }

  public static void test2()
  {
    Stream<String> stream1 = Arrays.stream(new String[]{"A", "B", "C"});
    Stream<String> stream2 = List.of("X", "Y", "Z").stream();
    stream1.forEach(System.out::println);
    stream2.forEach(System.out::println);
  }

  public static void test1()
  {
    Stream<String> stream = Stream.of("A", "B", "C", "D");
    stream.forEach(System.out::println);
  }
}

class NatualSupplier implements Supplier<Integer>
{
  int n = 0;
  @Override
  public Integer get()
  {
    n++;
    return n;
  }
}

class FibonacciSupplier implements Supplier<Integer>
{
  int a0 = 0;
  int a1 = 0;
  int a2 = 1;
  @Override
  public Integer get()
  {
    a0 = a1;
    a1 = a2;
    a2 = a0 + a1;
    return a1;
  }
}
