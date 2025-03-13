package programs.java;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodeDecode {

    public static void main(String args[]){
        EncodeDecode encodeDecode = new EncodeDecode();
        String str = "hello world";
        encodeDecode.encode(str);
    }

    public String encode(String byteData){
        byte[] message = byteData.getBytes(StandardCharsets.UTF_8);
        String encoded = Base64.getEncoder().encodeToString(message);
        System.out.println(encoded);
        return encoded;
    }
}
