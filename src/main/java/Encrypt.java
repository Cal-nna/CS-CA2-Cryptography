public class Encrypt {
    public static String encrypt(String secret, int key) {
        if (secret == null || secret.isEmpty()) {
            return "The file appears to have no content. Please ensure the file has valid content.";
        }

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < secret.length(); i++) {
            char ch = secret.charAt(i);
            if (ch == ' ' || ch == '\n') {
                encrypted.append(ch); // Preserve spaces and newlines
            } else {
                ch = (char) (ch + key);
                if (Character.isLowerCase(secret.charAt(i)) && ch > 'z') {
                    ch = (char) (ch - 26);
                } else if (Character.isUpperCase(secret.charAt(i)) && ch > 'Z') {
                    ch = (char) (ch - 26);
                }
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }
}
