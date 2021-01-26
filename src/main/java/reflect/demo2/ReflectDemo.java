package reflect.demo2;

public class ReflectDemo
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    //使用class属性
    Class<Student> c = Student.class;
    System.out.println(c);  //class reflect.demo2.Student
    System.out.println("-----------");

    Class<Student> c2 = Student.class;
    System.out.println(c == c2);  //true
    System.out.println("-----------");

    //使用getClass方法
    Student student = new Student();
    Class<? extends Student> c3 = student.getClass();
    System.out.println(c == c3);  //true
    System.out.println("-----------");

    //使用forName方法
    Class<?> c4 = Class.forName("reflect.demo2.Student");
    System.out.println(c == c4);  //true

  }
}
