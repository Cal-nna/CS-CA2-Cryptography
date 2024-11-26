public class Decrypt {
    public static String decrypt(String decryptedSecret, int key) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < decryptedSecret.length(); i++) {
            char ch = decryptedSecret.charAt(i);
            if (ch == ' ') {
                decrypted.append(' '); // Preserve spaces
            } else {
                ch = (char) (ch - key);
                // Adjust for lowercase letters
                if (Character.isLowerCase(decryptedSecret.charAt(i)) && ch < 'a') {
                    ch = (char) (ch + 26);
                }
                // Adjust for uppercase letters
                else if (Character.isUpperCase(decryptedSecret.charAt(i)) && ch < 'A') {
                    ch = (char) (ch + 26);
                }
                decrypted.append(ch);
            }
        }
        return decrypted.toString();
    }
}
