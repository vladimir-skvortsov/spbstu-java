public class Triple<T extends Comparable<T>> {
  private T first;
  private T second;
  private T third;

  public Triple(T first, T second, T third) {
    this.first = first;
    this.second = second;
    this.third = third;
  };

  public T getFirst() {
    return first;
  };
  public T getSecond() {
    return second;
  };
  public T getThird() {
    return third;
  };

  public void setFirst(T value) {
    this.first = value;
  };
  public void setSecond(T value) {
    this.second = value;
  };
  public void setThird(T value) {
    this.third = value;
  };

  public T min() {
    T min = first;
    if (second.compareTo(min) < 0) {
      min = second;
    }
    if (third.compareTo(min) < 0) {
      min = (T) third;
    }
    return min;
  };

  public T max() {
    T max = first;
    if (second.compareTo(max) > 0) {
      max = (T) second;
    }
    if (third.compareTo(max) > 0) {
      max = (T) third;
    }
    return max;
  };

  public double mean() {
    if (!(first instanceof Number) && !(second instanceof Number) && !(third instanceof Number)) {
      throw new RuntimeException("Is not possible to cast values to numbers to perform mean operation");
    }

    double sum = ((Number)first).doubleValue() + ((Number)second).doubleValue() + ((Number)third).doubleValue();
    return sum / 3;
  };

  @Override
  public String toString() {
    return "(" + first + ", " + second + ", " + third + ')';
  };
};
