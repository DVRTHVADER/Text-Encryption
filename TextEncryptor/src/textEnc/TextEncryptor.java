
package textEnc;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;


public class TextEncryptor {
    public static void main(String[] args) {
        try {
            // Generate a secret key for encryption
            SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

            // Create a Cipher object for encryption
            Cipher cipher = Cipher.getInstance("AES");

            // Initialize the Cipher in encryption mode with the secret key
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Input text to encrypt
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text to encrypt: ");
            String plaintext = scanner.nextLine();

            // Encrypt the text
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

            // Encode the encrypted bytes in Base64 for better display
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Encrypted text: " + encryptedText);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}


