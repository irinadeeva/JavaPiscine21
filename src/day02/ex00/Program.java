
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Map<String, String> signaturesMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        try {
            parseSignature(signaturesMap);

            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            while (!(fileName.equals("42"))) {
                FileInputStream fis = new FileInputStream(fileName);
                    StringBuilder fileData = new StringBuilder();
                    while (fis.available() > 0) {
                        int i = fis.read();
                        fileData.append((char) i);
                        if (findSignature(signaturesMap, fileData.toString(), result))
                            break;
                    }
                    if (fis.available() == 0)
                        System.out.println("UNDEFINED");
                    fis.close();

                    fileName = scanner.nextLine();

            }
            if (result.length() != 0) {
                printResult(result.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(byte[] buffer) {
       try (FileOutputStream fos = new FileOutputStream("result.txt")) {
            fos.write(buffer, 0, buffer.length);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static boolean findSignature(Map<String, String> signaturesMap, String fileData, StringBuilder result) {
        for (String key : signaturesMap.keySet()) {
            if (fileData.startsWith(key)) {
                result.append(signaturesMap.get(key)).append("\n");
                System.out.println("PROCESSED");
                return true;
            }
        }

        return false;
    }

    private static void parseSignature(Map<String, String> signaturesMap) throws IOException {

        StringBuilder fileData = new StringBuilder();
        try (FileInputStream fis = new FileInputStream("signatures.txt")) {

            int i;
            while ((i = fis.read()) != -1) {
                fileData.append((char) i);
            }
            fis.close();

            String[] fileLines = fileData.toString().split("\n");

            for (String fileLine : fileLines) {
                String[] tmp = fileLine.split(",");
                if (tmp.length > 2)
                    throw new IOException("File not well-formated");
                signaturesMap.put(strHexToString(tmp[1].trim()), tmp[0].trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String strHexToString(String str) {
        StringBuilder ret = new StringBuilder();
        String[] strings = str.split(" ");
        for (String string : strings) {
            ret.append((char) Long.parseLong(string, 16));
        }
        return ret.toString();
    }

}