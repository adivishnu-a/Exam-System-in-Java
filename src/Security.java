import java.util.Base64;

//v0.1.0

public class Security {
    public static String encStr(String str){
        Base64.Encoder encoder = Base64.getEncoder();
        str = encoder.encodeToString(str.getBytes());
        return str;
    }

    public static String decStr(String str){
        Base64.Decoder decoder = Base64.getDecoder();
        str = new String(decoder.decode(str));
        return str;
    }

    public static String encInt(int i){
        String str = String.valueOf(i);
        Base64.Encoder encoder = Base64.getEncoder();
        str = encoder.encodeToString(str.getBytes());
        return str;
    }

    public static int decInt(String str){
        Base64.Decoder decoder = Base64.getDecoder();
        str = new String(decoder.decode(str));
        return Integer.parseInt(str);
    }
}
