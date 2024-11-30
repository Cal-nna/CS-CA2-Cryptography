public class Decrypt {
    public static String decrypt(String decryptedSecret, int key) {
        if (decryptedSecret == null || decryptedSecret.isEmpty()) {
            return "The file appears to have no content. Please ensure the file has valid content.";
        }

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < decryptedSecret.length(); i++) {
            char ch = decryptedSecret.charAt(i);
            if (ch == ' ' || ch == '\n') {
                decrypted.append(ch); // Preserve spaces and newlines
            } else {
                ch = (char) (ch - key);
                if (Character.isLowerCase(decryptedSecret.charAt(i)) && ch < 'a') {
                    ch = (char) (ch + 26);
                } else if (Character.isUpperCase(decryptedSecret.charAt(i)) && ch < 'A') {
                    ch = (char) (ch + 26);
                }
                decrypted.append(ch);
            }
        }
        return decrypted.toString();
    }
}
