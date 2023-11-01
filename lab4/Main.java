
public class Main {
  public static void main(String[] args) {
    // Types, that can be used in switch case
    byte byteVariable = 4;
    short shortVariable = 42;
    int integerVariable = 422;
    char charVariable = 'a';
    String name = "Vova";
    enum Roles {
      ADMIN,
      USER,
      MODERATOR,
      GUEST
    };

    // Byte switch case
    System.out.println("Byte switch case");
    switch (byteVariable) {
      case 0 -> System.out.println("Variable is empty");
      case 4 -> System.out.println("Variable is 4");
      default -> System.out.println("Default case");
    }

    // Short switch case
    System.out.println("Short switch case");
    switch (shortVariable) {
      case 0 -> System.out.println("Variable is empty");
      case 42 -> System.out.println("Variable is 42");
      default -> System.out.println("Default case");
    }

    // Integer switch case
    System.out.println("Integer switch case");
    switch (integerVariable) {
      case 0 -> System.out.println("Variable is empty");
      case 422 -> System.out.println("Variable is 422");
      default -> System.out.println("Default case");
    }

    // Char switch case
    System.out.println("Char switch case");
    switch (charVariable) {
      case 0 -> System.out.println("Variable is empty");
      case 'a' -> System.out.println("Variable is a");
      default -> System.out.println("Default case");
    }

    // String switch case
    System.out.println("String switch case");
    switch (name) {
      case "Misha" -> System.out.println("Hey, Misha!");
      case "Vova" -> System.out.println("Hello, my creator");
      default -> System.out.println("I do not know you");
    }

    // Enum switch case
    System.out.println("Enum switch case");
    Roles myRole = Roles.ADMIN;
    switch (myRole) {
      case ADMIN -> System.out.println("Hey, you are allowed to be here");
      case MODERATOR -> System.out.println("Hey, you are allowed to be here");
      default -> System.out.println("Sorry, you do not have access");
    }
  };
};
