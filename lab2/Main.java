import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String dir = System.getProperty("user.dir");
    System.out.println(dir);

    try {
      Scanner fin = new Scanner(Paths.get(dir, "input.txt"), StandardCharsets.UTF_8);

      while (fin.hasNext()) {
        String word = fin.next();
        System.out.println("Word: " + word);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  };
};
