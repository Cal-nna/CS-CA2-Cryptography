import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Decrypt {
    public static String decrypt(String encryptedSecret, String base64Key) throws Exception {
        if (encryptedSecret == null || encryptedSecret.isEmpty()) {
            return "The file appears to have no content. Please ensure the file has valid content.";
        }
        // Decode key
        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
        SecretKeySpec secretKey = new SecretKeySpec(decodedKey, "AES");

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Do the Decryption
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedSecret);
        byte[] originalBytes = cipher.doFinal(decodedBytes);
        return new String(originalBytes);
    }
}
