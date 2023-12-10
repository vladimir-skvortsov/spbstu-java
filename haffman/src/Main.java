import java.io.File;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    String helpString = "Arguments format: <command> <file path>, where command is -a [archive](default), -e [extract], -t [testing]";

    Haffman h = new Haffman();

    String[] nargs = new String[args.length];
    System.arraycopy(args, 0, nargs, 0, args.length);

    String[] commands = new String[] { "-a", "-e", "-t" };

    if (args.length == 0 || !(Arrays.asList(commands).contains(args[0]))) {
      nargs = new String[args.length + 1];
      System.arraycopy(args, 0, nargs, 1, args.length);
      nargs[0] = "-a";
    }

    if (nargs[0].equals("-e")) {
      if (nargs.length <= 1) {
        throw new IllegalArgumentException("Provide path to archive file");
      }

      ArcData arcData = InOut.readArchive(args[1]);

      byte[] result = h.decode(arcData.compressed, arcData.recoveryMap);

      InOut.writeFile(result, arcData.originalFileName);
    } else if (nargs[0].equals("-a")) {
      if (nargs.length <= 1) {
        throw new IllegalArgumentException("Provide path to a file");
      }

      byte[] data = InOut.readFile(nargs[1]);
      byte[] result = h.encode(data);
      File f = new File(nargs[1]);
      String originalFileName = f.getName();
      String outputFilePath = originalFileName.substring(0, originalFileName.lastIndexOf('.')) + ".arc";

      InOut.writeArchive(result, h.codeMap, originalFileName, outputFilePath);
    } else if (nargs[0].equals("-t")) {
      if (nargs.length <= 1) {
        throw new IllegalArgumentException("Provide path to archive file");
      }

      ArcData arcData = InOut.readArchive(args[1]);
      byte[] result = h.decode(arcData.compressed, arcData.recoveryMap);

      InOut.test(arcData, result);
    } else {
      throw new IllegalArgumentException(helpString);
    }
  };
};
