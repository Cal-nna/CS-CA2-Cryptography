import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            if (!keyboard.hasNextInt()) {
                System.out.println("Invalid input. Please enter one of the numbers presented on the menu");
                keyboard.next(); // Consume the invalid input
                continue; // Prompt the menu again
            }
           int choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 3) {
                System.out.println("Exiting program.");
                break; // Exit the program
            }
            else if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Input only one of the prompted numbers in the menu");
                continue;
            }

            String textCode;
                try {
                    System.out.print("Enter the path of the text file: ");
                    String filePath = keyboard.nextLine(); // src/main/textFile/Text.file for example purposes
                    textCode = new String(Files.readAllBytes(Paths.get(filePath)));
                    //System.out.println("Read from file: " + textCode);
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage() +", please try again with the correct file path");
                    continue; // Prompt the menu again
                } catch (Exception e) {
                    System.out.println("error encrypting/decrypting file");
                    continue; // Prompt the menu again
                }

            System.out.print("Enter the key for encryption/decryption: ");
            if (!keyboard.hasNextInt()) {
                System.out.println("Invalid input. Please enter an appropriate number to use as a key");
                keyboard.next(); // Consume the invalid input
                continue; // Prompt the menu again
            }
            int key = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 1) {
                String encryptedText = Encrypt.encrypt(textCode, key);
                System.out.println("Encrypted text: " + encryptedText);
            } else {
                String decryptedText = Decrypt.decrypt(textCode, key);
                System.out.println("Decrypted text: " + decryptedText);
            }
        }


    }
}
//TODO, Destroy the program, find any weaknesses. To start, any input that is only a number should BE only numbers
//make a range for the key to prevent the program from being confused. Make the encryption key randomly generated
//Keep key input but for only for decryption