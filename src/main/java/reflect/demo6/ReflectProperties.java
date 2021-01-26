package reflect.demo6;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectProperties
{
  public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    //加载配置文件
    Properties properties = new Properties();
    FileReader fileReader = new FileReader("src/main/java/reflect/demo6/class.txt");
    properties.load(fileReader);
    fileReader.close();

    //获取类路径和方法名
    String className = properties.getProperty("className");
    String methodName = properties.getProperty("methodName");

    Class<?> clazz = Class.forName(className);
    //构造方法实例化对象
    Constructor<?> constructor = clazz.getConstructor();
    Object obj = constructor.newInstance();
    //获得方法
    Method method = clazz.getMethod(methodName);

    //调用方法
    method.invoke(obj);
  }
}
