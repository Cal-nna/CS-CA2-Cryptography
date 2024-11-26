import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        while (choice != 3)
        {
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();


            String textCode;
            try {
                textCode = new String(Files.readAllBytes(Path.of("src/main/textFile/Text.file")));
//                System.out.println("Read from file: " + textCode);
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

            if (choice == 3) {
                System.out.println("Exiting program.");
                break; // Exit the program
            }
        }

    }
}
//TODO, fix the file reading so it can comprehend seperate lines but only for the encrypting does this problem persist
//TODO, Destroy the program, find any weaknesses