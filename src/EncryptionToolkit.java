import java.util.*;

public class EncryptionToolkit {

    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char)((ch - 'A' + shift) % 26 + 'A'));
            }
            else if (Character.isLowerCase(ch)) {
                result.append((char)((ch - 'a' + shift) % 26 + 'a'));
            }
            else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }

    public static String rot13(String text) {
        return caesarEncrypt(text, 13);
    }

    public static String reverseCipher(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static int letterFrequency(String text) {
        int count = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n==== Text Encryption Toolkit ====");
            System.out.println("1. Caesar Encrypt");
            System.out.println("2. Caesar Decrypt");
            System.out.println("3. ROT13 Cipher");
            System.out.println("4. Reverse Cipher");
            System.out.println("5. Letter Frequency Counter");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter shift value: ");
                    int shift = scanner.nextInt();
                    System.out.println("Encrypted: " + caesarEncrypt(text, shift));
                    break;

                case 2:
                    System.out.print("Enter shift value: ");
                    int shift2 = scanner.nextInt();
                    System.out.println("Decrypted: " + caesarDecrypt(text, shift2));
                    break;

                case 3:
                    System.out.println("ROT13 Result: " + rot13(text));
                    break;

                case 4:
                    System.out.println("Reversed: " + reverseCipher(text));
                    break;

                case 5:
                    System.out.println("Letter Count: " + letterFrequency(text));
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
