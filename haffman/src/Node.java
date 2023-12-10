public class Node implements Comparable<Node> {
  public Integer weight;
  public Node leftChild;
  public Node rightChild;

  public Node(Integer weight) {
    this.weight = weight;
  };

  @Override
  public int compareTo(Node n) {
    if (this.weight > n.weight) {
      return 1;
    } else if (this.weight < n.weight) {
      return -1;
    } else {
      return 0;
    }
  };

  public String toString() {
    return "w=" + this.weight;
  };

  public String getTreeInfo() {
    return String.format("[Node, w=%d]", this.weight);
  };

  public void fillCodeMap(String character, CodeMap codeMap) {
    this.leftChild.fillCodeMap(character + "0", codeMap);
    this.rightChild.fillCodeMap(character + "1", codeMap);
  };
};
