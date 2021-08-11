package com.pengo.generic;

import java.util.Arrays;

/**
 * @author pengo
 * @description:
 * @date: 2021/8/10
 */
public class TestSort
{
  public static void main(String[] args)
  {
    test1();
  }

  static void test1()
  {
    SortPerson person1 = new SortPerson("ZhangSan", 18);
    SortPerson person2 = new SortPerson("LiSi", 20);
    SortPerson person3 = new SortPerson("WangWu", 22);
    SortPerson[] persons = new SortPerson[]{
      person1,person2,person3
    };
    Arrays.sort(persons);
    System.out.println(Arrays.toString(persons));
  }
}

class SortPerson implements Comparable<SortPerson>
{
  String name;
  Integer score;

  public SortPerson(String name, Integer score)
  {
    this.name = name;
    this.score = score;
  }

  @Override
  public String toString()
  {
    return "SortPerson{" + "name='" + name + '\'' + ", score=" + score + '}';
  }

  @Override
  public int compareTo(SortPerson o)
  {
    return this.score.compareTo(o.score);
  }
}
