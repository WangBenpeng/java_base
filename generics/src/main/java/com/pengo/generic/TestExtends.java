package com.pengo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author pengo
 * @description:
 * @date: 2021/8/11
 */
public class TestExtends
{
  public static void main(String[] args)
  {
    Class<IntPair> clazz = IntPair.class;
    Type t = clazz.getGenericSuperclass();
    if(t instanceof ParameterizedType)
    {
      ParameterizedType pt = (ParameterizedType)t;
      Type[] types = pt.getActualTypeArguments();
      Type firstType = types[0];
      Class<?> typeClass = (Class<?>)firstType;
      System.out.println(typeClass);
    }
  }
}

class IntPair extends IntegerPair<Integer>{
  public IntPair(Integer first, Integer last)
  {
    super(first, last);
  }
}

class IntegerPair<T>{
  private T first;
  private T last;

  public IntegerPair(T first, T last)
  {
    this.first = first;
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
