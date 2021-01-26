package reflect.demo7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectService
{
  public static void main(String[] args) throws Exception
  {
    test2();
  }

  /**
   * 自己写的
   * @throws Exception
   */
  public  static void test2() throws Exception
  {
    UserController userController = new UserController();
    System.out.println(userController.getUserService());  //null
    UserService userService = new UserService();
    //获取class对象
    Class<? extends UserController> clazz = userController.getClass();
    //获取全部变量
    Field[] declaredFields = clazz.getDeclaredFields();
    //获取变量名称（当前只有一个对象）
    String name = declaredFields[0].getName();
    //构造set方法名
    String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    //获取方法
    Method setUserService = clazz.getMethod(methodName, UserService.class);
    //反射，初始化了userService
    setUserService.invoke(userController, userService);
    //顺利得到方法：reflect.demo7.UserService@7921b0a2
    System.out.println(userController.getUserService());
  }

  /**
   * 马士兵老师的方法
   * @throws Exception
   */
  public static void test1() throws Exception
  {
    UserController userController = new UserController();
    Class<? extends UserController> clazz = userController.getClass();
    UserService userService = new UserService();
    Field serviceField = clazz.getDeclaredField("userService");
    serviceField.setAccessible(true);
    String name = serviceField.getName();
    name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
    String setMethodName = "set" + name;
    Method method = clazz.getMethod(setMethodName, UserService.class);
    method.invoke(userController, userService);
    System.out.println(userController.getUserService());
  }
}
