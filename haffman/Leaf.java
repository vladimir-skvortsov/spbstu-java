import java.nio.charset.StandardCharsets;

public class Leaf extends Node {
  public Byte symbol;
  public Integer weight;
  public String prefix;

  public Leaf(Byte symbol, Integer weight) {
    super(weight);

    this.symbol = symbol;
  };

  public String toString() {
    return this.symbol + "(" + new String(new byte[] { this.symbol }, StandardCharsets.UTF_8) + ")=" + this.prefix;
  };

  public String getTreeInfo() {
    return String.format("[Leaf, s=%s]", new String(new byte[] { this.symbol }, StandardCharsets.UTF_8));
  };

  public void fillCodeMap(String character, CodeMap codeMap) {
    this.prefix = character;
    codeMap.put(this.symbol, this.prefix);
  };
};
