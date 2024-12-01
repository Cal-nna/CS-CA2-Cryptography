import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
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
                keyboard.next(); // Consume the invalid input
                continue; // Prompt the menu again
            }

            int choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 3) {
                System.out.println("Exiting program.");
                break; // Exit the program
            } else if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Input only one of the prompted numbers in the menu.");
                continue;
            }

            String textCode;
            try {
                System.out.print("Enter the path of the text file: ");
                String filePath = keyboard.nextLine(); // e.g., src/main/textFile/Text.file for example purposes
                textCode = new String(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                System.out.println("error encrypting/decrypting file");
                continue; // Prompt the menu again
            } catch (Exception e) { //catches special symbols
                System.out.println("Error reading file: " + e.getMessage() + ". Please try again with the correct file path.");
                continue; // Prompt the menu again
            }

            int key;
            if (choice == 1) {
                // Generate a random key
                key = new Random().nextInt(100) + 1;
                System.out.println("Generated encryption key: " + key);
                String encryptedText = Encrypt.encrypt(textCode, key);
                System.out.println("Encrypted text: " + encryptedText);
            } else {
                // Ask for the key
                System.out.print("Enter the key for decryption (1-100): ");
                if (!keyboard.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    keyboard.next();
                    continue;
                }
                key = keyboard.nextInt();
                keyboard.nextLine();

                if (key < 1 || key > 100) {
                    System.out.println("Invalid key. Key must be in the range 1-100.");
                    continue;
                }
                String decryptedText = Decrypt.decrypt(textCode, key);
                System.out.println("Decrypted text: " + decryptedText);
            }
        }
    }
}
//https://github.com/Cal-nna/CS-CA2-Cryptography
