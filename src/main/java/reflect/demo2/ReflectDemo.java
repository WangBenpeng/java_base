package reflect.demo2;

public class ReflectDemo
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    Class<Student> c = Student.class;
    System.out.println(c);

    Class<Student> c2 = Student.class;
    System.out.println(c == c2);
    System.out.println("-----------");

    Student student = new Student();
    Class<? extends Student> c3 = student.getClass();
    System.out.println(c == c3);
    System.out.println("-----------");

    Class<?> c4 = Class.forName("reflect.demo2.Student");
    System.out.println(c == c4);

  }
}
