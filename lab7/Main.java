public class Main {
  public static void main(String[] args) {
    Character viking = new Character("Bjorn", 100, 30, 5);
    Character ninja = new Character("Ninja", 80, 20, 30);

    Wrapper vikingWrapper = new Wrapper(viking);
    Wrapper ninjaWrapper = new Wrapper(ninja);

    System.out.println("Before:");
    System.out.println("Viking: " + vikingWrapper.getInstance());
    System.out.println("Ninja: " + ninjaWrapper.getInstance());

    vikingWrapper.swap(ninjaWrapper);

    System.out.println("After:");
    System.out.println("Viking: " + vikingWrapper.getInstance());
    System.out.println("Ninja: " + ninjaWrapper.getInstance());
  };
};
