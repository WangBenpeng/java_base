package reflect.demo6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectArray
{
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
  {
    ArrayList<Integer> array = new ArrayList<>();
    Class<? extends ArrayList> clazz = array.getClass();
    Method method = clazz.getMethod("add", Object.class);
    method.invoke(array, "hello");
    method.invoke(array, "world");
    method.invoke(array, "123");
    System.out.println(array);
  }
}
