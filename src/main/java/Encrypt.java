import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encrypt {
    public static String encrypt(String secret, String base64Key) throws Exception {
        if (secret == null || secret.isEmpty()) {
            return "The file appears to have no content. Please ensure the file has valid content.";
        }
        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
        SecretKeySpec secretKey = new SecretKeySpec(decodedKey, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(secret.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
