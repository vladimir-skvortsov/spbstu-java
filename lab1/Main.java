public class Main {
  public static void main(String[] args) {
    String leftString = "Hello";
    String rightString = ", brave new world";

    System.out.println("Left string: " + leftString);
    System.out.println("Right string: " + rightString);

    // 1. Strings concatenation
    String concatenatedString = leftString.concat(rightString);
    System.out.println("1. Concatenated string: " + concatenatedString);

    // 2. String length
    int length = concatenatedString.length();
    System.out.println("2. Length of the string: " + length);

    // 3. Substring
    String substring = concatenatedString.substring(7);
    System.out.println("3. Substring from index 7: " + substring);

    // 4. Char at the index
    char ch = concatenatedString.charAt(0);
    System.out.println("4. Char at the index 0: " + ch);

    // 5. String to lower case
    String lowerCaseString = concatenatedString.toLowerCase();
    System.out.println("5. String to lower case: " + lowerCaseString);

    // 6. String to upper case
    String upperCaseString = concatenatedString.toUpperCase();
    System.out.println("6. String to upper case: " + upperCaseString);

    // 7. Replace substring
    String replacedString = concatenatedString.replace("brave", "beautiful");
    System.out.println("7. Replace substring: " + replacedString);

    // 8. Is word "world" contained in the string?
    boolean isContained = concatenatedString.contains("world");
    System.out.println("8. Is word \"world\" contained in the string?: " + isContained);

    // 9. Index of the word "new"
    int index = concatenatedString.indexOf("new");
    System.out.println("9. Index of the word \"new\": " + index);

    // 10. Are left and right strings equal?
    boolean areEqual = leftString.equalsIgnoreCase(rightString);
    System.out.println("10. Are left and right strings equal?: " + areEqual);

    // 11. Trim a string
    String rawString = "   some external input   ";
    String trimmedString = rawString.trim();
    System.out.println("11. Trim a string:");
    System.out.println("Raw string: " + rawString);
    System.out.println("Trimmed string: " + trimmedString);

    // 12. Split a string into an array
    String[] tokens = concatenatedString.split(" ");
    System.out.println("12. Split a string into an array:");
    for (String token : tokens) {
      System.out.println(token);
    }
  }
}
