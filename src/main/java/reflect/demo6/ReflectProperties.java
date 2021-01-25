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
    Properties properties = new Properties();
    FileReader fileReader = new FileReader("src/main/java/reflect/demo6/class.txt");
    properties.load(fileReader);
    fileReader.close();

    String className = properties.getProperty("className");
    String methodName = properties.getProperty("methodName");

    Class<?> clazz = Class.forName(className);
    Constructor<?> constructor = clazz.getConstructor();
    Object obj = constructor.newInstance();
    Method method = clazz.getMethod(methodName);

    method.invoke(obj);
  }
}
