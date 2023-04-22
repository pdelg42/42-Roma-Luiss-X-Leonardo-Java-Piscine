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
import java.util.Scanner;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        byte[] bytes = new byte[(int) 16];
        String bytesString = "";
        HashMap<String, String> dict = parseSig();
        int size = 1;
        ArrayList<String> out = new ArrayList<String>(size);
        Scanner input = new Scanner(System.in);
        System.out.print("-> ");
        String path = input.nextLine();
        
        while(path.equals("42") == false){
            File file = new File(path);
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(bytes);
                bytesString = bytesToHex(bytes);
                out.add(executioner(bytesString, dict));
                System.out.println("PROCESSED");
                System.out.print("-> ");
                path = input.nextLine();
            } catch (IOException e) {
                e.printStackTrace();
                break ;
            }
        }
        input.close();
        buildResult(out);
    }

    public static void buildResult(ArrayList out){
        try {
            FileWriter myWriter = new FileWriter("result.txt");
            for (int i = 0; i < out.size(); i++) {
                if (out.get(i) == null)
                    continue ;
                myWriter.write(out.get(i).toString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {}
    }
    
    public static String executioner(String str, HashMap<String, String> dict) {
        for(String key : dict.keySet()) {
            if(str.substring(0, dict.get(key).length()).equals(dict.get(key))) {
                return(key);
            }
        }
        return(null);
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
