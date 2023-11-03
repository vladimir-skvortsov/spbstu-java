import java.lang.reflect.*;

public class Main {
  public static void main(String[] args) {
    try {
      Class<?> cls = Class.forName("Student");
      Constructor<?> constructor = cls.getConstructor();
      Object instance = constructor.newInstance();

      Method method = cls.getMethod("displayStudentInfo");
      method.invoke(instance);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
