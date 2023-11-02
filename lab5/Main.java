public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("There are no arguments");
      return;
    }

    for (int index = 0; index < args.length; index += 1) {
      System.out.println("Argument " + (index + 1) + ": " + args[index]);
    }
  }
}
