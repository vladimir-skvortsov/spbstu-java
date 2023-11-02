class ExampleClass {
    private int value;

    public ExampleClass(int value) {
      this.value = value;
    };

    public int getValue() {
      return value;
    };

    public void swap(ExampleClass other) {
      int temp = this.value;
      this.value = other.value;
      other.value = temp;
    };
};

public class Main {
  public static void main(String[] args) {
    ExampleClass obj1 = new ExampleClass(-10);
    ExampleClass obj2 = new ExampleClass(10);

    System.out.println("Before:");
    System.out.println("Object 1: " + obj1.getValue());
    System.out.println("Object 2: " + obj2.getValue());

    obj1.swap(obj2);

    System.out.println("After:");
    System.out.println("Object 1: " + obj1.getValue());
    System.out.println("Object 2: " + obj2.getValue());
  };
};
