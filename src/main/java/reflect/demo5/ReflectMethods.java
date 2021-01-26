package reflect.demo5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethods
{
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    Class<?> clazz = Class.forName("reflect.demo2.Student");
    //获取所有的公共方法，包括继承的
    Method[] methods = clazz.getMethods();
    for(Method method : methods)
    {
      System.out.println(method);
    }
    System.out.println("------------");

    //获取所有的方法，包括私有的，不包括继承的
    Method[] declaredMethods = clazz.getDeclaredMethods();
    for(Method declaredMethod : declaredMethods)
    {
      System.out.println(declaredMethod);
    }
    System.out.println("------------");

    //获得method1方法
    Method method1 = clazz.getMethod("method1");
    Constructor<?> constructor = clazz.getConstructor();
    //无参构造实例化类
    Object obj = constructor.newInstance();
    //调用obj的method1方法
    method1.invoke(obj);
    System.out.println("------------");

    //练习调用method2并传参
    Method method2 = clazz.getMethod("method2", String.class);
    method2.invoke(obj, "林青霞");
    System.out.println("------------");

    //练习调用method3并传参
    Method method3 = clazz.getMethod("method3", String.class, int.class);
    Object obj2 = method3.invoke(obj, "林青霞", 30);
    System.out.println(obj2);
    System.out.println("------------");

    //练习调用私有的function方法
    Method function = clazz.getDeclaredMethod("function");
    //暴力反射
    function.setAccessible(true);
    function.invoke(obj);
  }
}
