import java.util.Base64;

public class Codec {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        String x = "Hello";
        System.out.println(x);
        x = encoder.encodeToString(x.getBytes());
        System.out.println(x);
        Base64.Decoder decoder = Base64.getDecoder();
        String y = new String(decoder.decode(x));
        x = new String(decoder.decode(x));
        System.out.println(x);
        System.out.println(y);
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
        //Integer.parseInt()
        //String.valueOf();
    }
}