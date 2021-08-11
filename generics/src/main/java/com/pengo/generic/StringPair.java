package com.pengo.generic;

/**
 * @author pengo
 * @description:
 * @date: 2021/8/11
 */
public class StringPair<T,K>
{
  private T first;
  private K last;

  public StringPair(T first, K last)
  {
    this.first = first;
    this.last = last;
  }

//  public static <K> StringPair<K> create(K first, K last)
//  {
//    return new StringPair<>(first, last);
//  }

  public T getFirst()
  {
    return first;
  }

  public K getLast()
  {
    return last;
  }
}
