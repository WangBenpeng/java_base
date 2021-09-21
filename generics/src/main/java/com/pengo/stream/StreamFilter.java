package com.pengo.stream;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pengo
 * @description:
 * @date: 2021/9/21
 */
public class StreamFilter
{
  public static void main(String[] args)
  {
    test3();
  }

  public static void test3()
  {
    Student s1 = new Student("Zhangsan",55);
    Student s2 = new Student("Lisi",60);
    Student s3 = new Student("Wangwu",65);
    List.of(s1, s2, s3)
      .stream()
      .filter(student -> student.score >= 60)
      .map(student -> student.name)
      .forEach(System.out::println);

  }

  public static void test2()
  {
    Stream.generate(new LocalDateSupplier())
      .limit(31)
      .filter(ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
      .forEach(System.out::println);
  }

  public static void test1()
  {
    IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(new IntPredicate()
    {
      @Override
      public boolean test(int value)
      {
        return value % 2 != 0;
      }
    }).forEach(System.out::println);

    IntStream.of(2, 4, 6, 7, 8, 9).filter(n -> n % 2 == 0).forEach(System.out::println);
  }
}

class LocalDateSupplier implements Supplier<LocalDate>
{
  LocalDate start = LocalDate.of(2020, 1, 1);
  int n = -1;
  @Override
  public LocalDate get()
  {
    n++;
    return start.plusDays(n);
  }
}

class Student{
  String name;
  int score;

  public Student(String name, int score)
  {
    this.name = name;
    this.score = score;
  }
}
