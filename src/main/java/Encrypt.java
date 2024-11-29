public class Encrypt {
    public static String encrypt(String secret, int key) {
        StringBuilder encrypted = new StringBuilder();
        if (secret == null || secret.isEmpty()) {
            return "The file appears to have no content. Please ensure the file has valid content.";
        }
        if (!encrypted.isEmpty()){
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
        }} else {return "It appeears there is no content within the file, make sure the directory is correct or the file has content in it";}
        return encrypted.toString();
    }
}
