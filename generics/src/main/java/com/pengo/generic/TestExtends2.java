package com.pengo.generic;

/**
 * @author pengo
 * @description:
 * @date: 2021/8/11
 */
public class TestExtends2
{
  public static void main(String[] args)
  {
    Pair<Integer> pair = new Pair<>(1, 2);
    int n = add(pair);
    System.out.println(n);
  }

  static int add(Pair<? extends Number> p)
  {
    //get method
    Number first = p.getFirst();
    Number last = p.getLast();
    //set method
//    p.setFirst(new Integer(first.intValue() + 100));
    return first.intValue() + last.intValue();
  }
}

class Pair<T>{
  private T first;
  private T last;

  public Pair(T first, T last)
  {
    this.first = first;
    this.last = last;
  }

  public void setFirst(T first)
  {
    this.first = first;
  }

  public void setLast(T last)
  {
    this.last = last;
  }

  public T getFirst()
  {
    return first;
  }

  public T getLast()
  {
    return last;
  }
}