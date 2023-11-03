public class Main {
  public static void main(String[] args) {
    try {
      Triple<Double> triple = new Triple<Double>(3.2, -7.3, 5.9);

      System.out.println(triple);

      System.out.println("Min: " + triple.min());
      System.out.println("Max: " + triple.max());
      System.out.println("Mean: " + triple.mean());
    } catch (RuntimeException e) {
      System.out.println("Exeption: " + e.getMessage());
    }

    System.out.println("\n");

    try {
      Triple<String> triple = new Triple<String>("Saint-Petersburg", "Boston", "Madrid");

      System.out.println(triple);

      System.out.println("Min: " + triple.min());
      System.out.println("Max: " + triple.max());
      System.out.println("Mean: " + triple.mean());
    } catch (RuntimeException e) {
      System.out.println("Exeption: " + e.getMessage());
    }
  };
};
