import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
  public static void printClassName(Class<?> cls) {
    System.out.println("Class name: " + cls.getName());
  };
  public static void printClassPackageName(Class<?> cls) {
    System.out.println("Package name: " + cls.getPackage().getName());
  };
  public static void printClassFields(Class<?> cls) {
    Field[] fields = cls.getDeclaredFields();

    System.out.println("Declared fields:");

    for (Field field : fields) {
      System.out.println("  " + field.getType().getName() + " " + field.getName());
    }
  };
  public static void printConstructors(Class<?> cls) {
    Constructor<?>[] constructors = cls.getDeclaredConstructors();

    System.out.println("Declared constructors:");

    for (Constructor<?> constructor : constructors) {
      System.out.print("  " + constructor.getName() + "(");

      Parameter[] parameters = constructor.getParameters();

      for (int index = 0; index < parameters.length; index += 1) {
        System.out.print(parameters[index].getType().getName() + " " + parameters[index].getName());

        if (index < parameters.length - 1) {
          System.out.print(", ");
        }
      }

      System.out.println(")");
    }
  };
  public static void printMethods(Class<?> cls) {
    Method[] methods = cls.getDeclaredMethods();

    System.out.println("Declared methods:");

    for (Method method : methods) {
      System.out.print("  " + method.getReturnType().getName() + " " + method.getName() + "(");

      Parameter[] parameters = method.getParameters();

      for (int index = 0; index < parameters.length; index += 1) {
        System.out.print(parameters[index].getType().getName() + " " + parameters[index].getName());

        if (index < parameters.length - 1) {
          System.out.print(", ");
        }
      }

      System.out.println(")");
    }
  };

  public static void printClassInfo(Class<?> cls) {
    printClassName(cls);
    printClassPackageName(cls);
    printClassFields(cls);
    printConstructors(cls);
    printMethods(cls);
  };

  public static void main(String[] args) {
    printClassInfo(Student.class);

    System.out.print("\n");
    printClassInfo(Scanner.class);

    System.out.print("\n");
    printClassInfo(Math.class);
  };
};
