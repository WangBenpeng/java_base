package reflect.demo3;

import reflect.demo2.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructor
{
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    Class<Student> clazz = Student.class;
    //获取所有的公共构造方法
    Constructor<?>[] cons = clazz.getConstructors();
    for(Constructor<?> con : cons)
    {
      System.out.println(con);
    }
    System.out.println("---------------");
    //获取所有的公共方法
    Constructor<?>[] cons2 = clazz.getDeclaredConstructors();
    for(Constructor<?> con2 : cons2)
    {
      System.out.println(con2);
    }
    System.out.println("---------------");

    //根据构造方法创建对象
    Constructor<Student> con3 = clazz.getConstructor();
    Object student = con3.newInstance();
    System.out.println(student);
    System.out.println("---------------");

    //practice public constructor
    Constructor<Student> con4 = clazz.getConstructor(String.class, int.class, String.class);
    Student student1 = con4.newInstance("林青霞", 30, "西安");
    System.out.println(student1);

    //practice private constructor
    Constructor<Student> con5 = clazz.getDeclaredConstructor(String.class);
    System.out.println(con5);
    //暴力反射
    con5.setAccessible(true);

    Student student2 = con5.newInstance("林青霞");
    System.out.println(student2);

  }
}
