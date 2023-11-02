import java.util.Arrays;

public class StackArray<T> {
  private T[] data;
  private int size = 0;

  public StackArray () {
    this(16);
  };
  public StackArray (int capacity) {
    data = (T[]) new Object[capacity];
  };

  // Return the last element
  public T peek() {
    return data[(size - 1)];
  };

  // Pop the last element
  public T pop() {
    if (size == 0) {
      return null;
    }
    size--;
    T savedData = data[size];
    data[size] = null;
    return savedData;
  }

  // Push new element
  public void push(T newElement) {
    if (size == data.length) {
      data = Arrays.copyOf(data, 2 * data.length);
    }
    data[size] = newElement;
    size++;
  };

  // Check if stack is empty
  public boolean isEmpty() {
    return size == 0;
  };

  // Get stack's size
  public int getSize() {
    return size;
  };
};
