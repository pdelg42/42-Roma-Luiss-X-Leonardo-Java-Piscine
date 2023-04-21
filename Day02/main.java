import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        byte[] bytes = new byte[(int) 16];
        String bytesString = "";
        HashMap<String, String> dict = parseSig();
        int count = 0;

        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytes);
            bytesString = bytesToHex(bytes);
            executioner(bytesString, dict, count);
            // System.out.println(bytesToHex(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void executioner(String str, HashMap<String, String> dict, int count) {
        for(String key : dict.keySet()) {
            if(str.substring(0, dict.get(key).length()).equals(dict.get(key)))
            {
                if (count == 0)
                FileOutputStream file = new FileOutputStream("File.txt", );
                System.out.println(key);

            }
        }

    }

    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);

    public static String bytesToHex(byte[] bytes) {
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }

    public static final HashMap<String, String> parseSig() {
        File file = new File("signatures.txt");
        HashMap<String, String> dict = new HashMap<String, String>();

        try (FileInputStream stream = new FileInputStream(file)) {
            int c;
            String s = "";
            String key = "";
            do {
                c = stream.read();
                if (c == ' ') {
                    continue;
                } else if (c == ',') {
                    key = s;
                    s = "";
                    continue;
                } else if (c == '\n') {
                    dict.put(key, s);
                    s = "";
                    continue;
                } else if (c != -1)
                    s += (char) c + "";
            } while (c != -1);
            dict.put(key, s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (dict);
    }

}
