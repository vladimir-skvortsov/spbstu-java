import java.lang.UnsupportedOperationException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class InOut {
  static String ARC_HEADER = "ARC2023";

  static private void readArchiveHeader(String filePath, ArcData arcData) {
    RecoveryMap recoveryMap = new RecoveryMap();

    String headerData = "";
    String originalFileName = "";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String header = br.readLine();
      headerData += header + '\n';

      if (!header.equals(ARC_HEADER)) {
        throw new UnsupportedOperationException("Wrong file format");
      }

      originalFileName = br.readLine();
      headerData += originalFileName + '\n';

      if (originalFileName.isEmpty()) {
        throw new Exception("Missing original file name");
      }

      String recoveryMapSizeString = br.readLine();
      headerData += recoveryMapSizeString + '\n';

      Integer recoveryMapSize = Integer.valueOf(recoveryMapSizeString);
      if (recoveryMapSize == 0) {
        throw new Exception("Missing encoding table");
      }

      for (int index = 0; index < recoveryMapSize; index += 1) {
        char symbol;
        String code;
        String rec = br.readLine();

        // New line symbol has been read
        if (rec.length() == 0) {
          symbol = '\n';
          code = br.readLine();

          headerData += symbol + code + '\n';
        } else {
          symbol = rec.charAt(0);
          code = rec.substring(1, rec.length());
          headerData += rec + '\n';
        }

        recoveryMap.put(code, (byte) symbol);
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    arcData.dataOffset = headerData.getBytes().length;
    arcData.recoveryMap = recoveryMap;
    arcData.originalFileName = originalFileName;
  };

  static private int getAdditionalZerosNumber(String compressed) {
    String delta = compressed.substring(0, 8);
    return Integer.parseInt(delta, 2);
  };

  static private void readArchiveData(String filePath, ArcData arcData) {
    File compressedFile = new File(filePath);
    String compressed = "";
    int originalLength = 0;

    try {
      FileInputStream fileInputStream = new FileInputStream(compressedFile);

      fileInputStream.skip(arcData.dataOffset);

      while (true) {
        int cur = fileInputStream.read();
        if (cur == -1) {
          break;
        }
        originalLength += 1;

        compressed += String.format("%8s", Integer.toBinaryString(((byte) cur) & 0xff)).replace(" ", "0");
      }

      fileInputStream.close();
    } catch (Exception e) {
      System.out.println(e);
    }

    int additionalZerosNumber = getAdditionalZerosNumber(compressed);

    arcData.originalLength = originalLength;
    arcData.compressed = compressed.substring(8, compressed.length() - additionalZerosNumber);
  };

  static public ArcData readArchive(String filePath) {
    ArcData arcData = new ArcData();

    readArchiveHeader(filePath, arcData);
    readArchiveData(filePath, arcData);

    return arcData;
  };

  static public byte[] readFile(String filePath) {
    File srcFile = new File(filePath);

    byte[] data = new byte[(int) srcFile.length()];

    try {
      FileInputStream fileInputStream = new FileInputStream(srcFile);

      fileInputStream.read(data);

      fileInputStream.close();
    } catch (Exception e) {
      System.out.println(e);
    }

    return data;
  };

  static public void writeArchive(byte[] result, CodeMap codeMap, String originalFileName, String outputFilePath) {
    String archiveHeader = ARC_HEADER + "\n";
    archiveHeader += originalFileName + "\n";
    archiveHeader += Integer.toString(codeMap.size()) + '\n';

    for (Map.Entry<Byte, String> entry : codeMap.entrySet()) {
      Byte symbol = entry.getKey();
      String code = entry.getValue();

      archiveHeader += (char) (symbol & 0xFF) + code + '\n';
    }

    try (PrintWriter pw = new PrintWriter(outputFilePath)) {
      pw.write(archiveHeader);
    } catch (FileNotFoundException e) {
      System.out.println("Wrong file, or the file does not exist");
    }

    try {
      FileOutputStream fos = new FileOutputStream(outputFilePath, true);

      fos.write(result);
      fos.close();

      System.out.println("outputFilePath: " + outputFilePath);
    } catch (Exception e) {
      System.out.println(e);
    }
  };

  static public void writeFile(byte[] result, String outputFilePath) {
    try {
      FileOutputStream fos = new FileOutputStream(outputFilePath, false);

      fos.write(result, 0, result.length);
      fos.flush();
      fos.close();

      System.out.println("outputFilePath: " + outputFilePath);
    } catch (Exception e) {
      System.out.println(e);
    }
  };

  static public void test(ArcData arcData, byte[] result) {
    System.out.println("Archive length: " + arcData.originalLength);
    System.out.println("Original file name: " + arcData.originalFileName);
    System.out.println("Original file length: " + result.length);

    if (result.length > 0) {
      System.out.println("Compress ratio: " + (100 * arcData.originalLength / result.length) + "%");
    }

    System.out.println("Code map:");

    for (Map.Entry<String, Byte> entry : arcData.recoveryMap.entrySet()) {
      String code = entry.getKey();
      byte symbol = entry.getValue();
      char c = (char) symbol;
      System.out.println(c + "=" + code);
    }
  };
}
