import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if (!keyboard.hasNextInt()) {
                System.out.println("Invalid input. Please enter one of the numbers presented on the menu.");
                keyboard.next();
                continue;
            }

            int choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 3) {
                System.out.println("Exiting program.");
                break;
            } else if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Input only one of the prompted numbers in the menu.");
                continue;
            }

            String textCode;
            try {
                System.out.print("Enter the path of the text file: "); //src/main/textFile/Text.file for testing
                String filePath = keyboard.nextLine();
                textCode = new String(Files.readAllBytes(Paths.get(filePath)));
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage() + ". Please try again with the correct file path.");
                continue;
            }

            try {
                if (choice == 1) {
                    // Generate AES key
                    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                    keyGen.init(128);
                    SecretKey secretKey = keyGen.generateKey();
                    String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());

                    System.out.println("Generated encryption key: " + base64Key);
                    String encryptedText = Encrypt.encrypt(textCode, base64Key);
                    System.out.println("Encrypted text: " + encryptedText);
                } else {
                    // Decrypt
                    System.out.print("Enter the encoded key for decryption: ");
                    String base64Key = keyboard.nextLine();
                    String decryptedText = Decrypt.decrypt(textCode, base64Key);
                    System.out.println("Decrypted text: " + decryptedText);
                }
            } catch (Exception e) {
                System.out.println("Error during encryption/decryption: " + e.getMessage());
            }
        }
    }
}
