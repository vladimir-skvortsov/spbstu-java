import java.util.ArrayList;
import java.util.Map;

public class Haffman {
  CodeMap codeMap = new CodeMap();

  public byte[] encode(byte[] data) {
    WeightMap map = getWeightMap(data);
    WeightQueue queue = getWeightQueue(map);
    Node root = getTree(queue);

    root.fillCodeMap("", this.codeMap);

    String compressed = "";
    for (byte b : data) {
      compressed += codeMap.get(b);
    }
    compressed = fillAdditionalZeros(compressed);

    StringBuilder compressedString = new StringBuilder(compressed);
    byte[] result = new byte[compressedString.length() / 8];
    for (int index = 0; index < result.length; index += 1) {
      result[index] = (byte) Integer.parseInt(compressedString.substring(index * 8, (index + 1) * 8), 2);
    }

    return result;
  };

  public byte[] decode(String compressed, RecoveryMap recoveryMap) {
    ArrayList<Byte> result = new ArrayList<>();
    String current = "";

    for (int index = 0; index < compressed.length(); index += 1) {
      current += compressed.charAt(index);

      if (recoveryMap.containsKey(current)) {
        result.add(recoveryMap.get(current));
        current = "";
      }
    }

    byte[] decompressed = new byte[result.size()];
    for (int i = 0; i < result.size(); i++) {
      decompressed[i] = result.get(i);
    }

    return decompressed;
  };

  private String fillAdditionalZeros(String compressed) {
    int delta = 8 - compressed.length() % 8;
    byte counter = 0;

    for (; counter < delta; counter += 1) {
      compressed += "0";
    }

    return String.format("%8s", Integer.toBinaryString(counter & 0xff)).replace(" ", "0") + compressed;
  };

  private Node getTree(WeightQueue queue) {
    while (queue.size() > 1) {
      Node node1 = queue.poll();
      Node node2 = queue.poll();

      Node node = new Node(node1.weight + node2.weight);
      node.rightChild = node1;
      node.leftChild = node2;

      queue.add(node);
    }

    return queue.poll();
  };

  private WeightQueue getWeightQueue(WeightMap map) {
    WeightQueue queue = new WeightQueue();

    for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
      Byte symbol = entry.getKey();
      Integer weight = entry.getValue();
      Node node = new Leaf(symbol, weight);

      queue.add(node);
    }

    return queue;
  };

  private WeightMap getWeightMap(byte[] data) {
    WeightMap map = new WeightMap();

    for (byte b : data) {
      Integer value = map.get(b);

      if (value != null) {
        value += 1;
      } else {
        value = 1;
      }

      map.put(b, value);
    }

    return map;
  };
};
