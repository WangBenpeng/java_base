package com.pengo.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date: 2021/8/10
 */
public class TestArrayList
{
  public static void main(String[] args)
  {
    testSort();
  }

  static void testSort()
  {
    String[] strings = new String[]{"orange", "banana", "apple", "lemon"};
    Arrays.sort(strings);
    System.out.println(Arrays.toString(strings));
  }
}


