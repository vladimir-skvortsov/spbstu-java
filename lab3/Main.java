public class Main {
  public static void main(String[] args) {
    // Basic logical operators
    System.out.println("Logical AND: true && false = " + (true && false));
    System.out.println("Logical OR: true || false = " + (true || false));
    System.out.println("Logical NOT: !true = " + (!true));

    // Ternary operator
    System.out.println("Ternary operator: is 10 is bigger than 15? " + (10 > 15 ? "Yes" : "No"));

    // Bitwise operators
    System.out.println("Bitwise AND: 5 & 2 = " + (5 & 2));
    System.out.println("Bitwise OR 7 | 3 = " + (7 | 3));
    System.out.println("Bitwise XOR: 4 ^ 2 = " + (4 ^ 2));
    System.out.println("Bitwise NOT: ~7 = " + (~7));

    // Shift operations
    System.out.println("6 >> 3 = " + (6 >> 3));
    System.out.println("-6 >> 3 = " + (-6 >> 3));
    System.out.println("6 >>> 3 = " + (6 >>> 3));
    System.out.println("-6 >>> 30 = " + (-6 >>> 30));
  };
};
