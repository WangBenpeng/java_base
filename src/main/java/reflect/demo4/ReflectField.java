package reflect.demo4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectField
{
  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    Class<?> clazz = Class.forName("reflect.demo2.Student");
    //获取公共参数
    Field[] fields = clazz.getFields();
    for(Field field : fields)
    {
      System.out.println(field);
    }
    System.out.println("---------");

    //获取所有参数
    Field[] fields1 = clazz.getDeclaredFields();
    for(Field field : fields1)
    {
      System.out.println(field);
    }
    System.out.println("---------");

    //获取address field
    Field addressField = clazz.getField("address");
    //无参构造实例化类
    Constructor<?> con = clazz.getConstructor();
    Object obj = con.newInstance();
    //给obj的成员变量addressField赋值
    addressField.set(obj, "西安");
    System.out.println(obj);
    System.out.println("---------");

    //赋值练习
    Field[] fields2 = clazz.getDeclaredFields();
    for(Field field : fields2)
    {
      field.setAccessible(true);
    }
    fields2[0].set(obj, "林青霞");
    fields2[1].set(obj, 30);
    fields2[2].set(obj, "西安");
    System.out.println(obj);


  }
}
