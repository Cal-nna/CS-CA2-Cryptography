import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        if (choice == 3) {
            System.out.println("Exiting program.");
            return; // Exit the program
        }

        System.out.print("Enter the path of the text file: ");
        String filePath = keyboard.nextLine();

        String textCode = "";
        try {
            textCode = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("Read from file: " + textCode);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return; // Exit if error
        }

        System.out.print("Enter the key for encryption/decryption: ");
        int key = keyboard.nextInt();
        keyboard.nextLine();

        if (choice == 1) {
            String encryptedText = Encrypt.encrypt(textCode, key);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (choice == 2) {
            String decryptedText = Decrypt.decrypt(textCode, key);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
