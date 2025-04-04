package common;


import java.util.Base64;

public class SecurityUtils {

    public static String decrypt(String base64Encoded) {
        return new String(Base64.getDecoder().decode(base64Encoded));
    }

    public static String encrypt(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }
}
