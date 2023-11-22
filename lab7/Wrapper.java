public class Wrapper<T> {
  private T instance;

  public Wrapper(T instance) {
    this.instance = instance;
  };

  public T getInstance() {
    return this.instance;
  };
  public void setInstance(T instance) {
    this.instance = instance;
  };

  public void swap(Wrapper<T> other) {
    T temp = this.instance;
    instance = other.instance;
    other.instance = temp;
  };
};
