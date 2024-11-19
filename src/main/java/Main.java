import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        boolean readFileCheck = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        if (choice == 3 || choice == 4) {
            readFileCheck = true;
        }
        // Read from a text file
        //C:\Users\callu\IdeaProjects\CS_simpleCryptography\src\main\java\Text
        String TextCode = "";
        if (readFileCheck == true) {
            try {
                System.out.print("Enter the path of the text file: ");
                String filePath = keyboard.nextLine();
                TextCode = new String(Files.readAllBytes(Paths.get(filePath)));
                System.out.println("Read from file: " + TextCode);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                return; //Exit if error
            }
        }

    }

    public static String encrypt(String secret, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < secret.length(); i++) {
            char ch = secret.charAt(i);
            if (ch == ' ') {
                encrypted.append(' '); // Preserve spaces
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