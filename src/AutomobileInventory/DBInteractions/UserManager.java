package AutomobileInventory.DBInteractions;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.HashSet;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class UserManager {
    private static final String FILE_PATH = "users.txt";
    private HashSet<User> users = new HashSet<>();
    private SecretKey secretKey;

    public UserManager() {
        try {
            secretKey = KeyGenerator.getInstance("AES").generateKey();
        } catch (GeneralSecurityException e) {
            System.out.println("Error initializing encryption key: " + e.getMessage());
        }
    }

    // Encrypt data
    private String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (GeneralSecurityException e) {
            System.out.println("Error encrypting data: " + e.getMessage());
            return null;
        }
    }

    // Decrypt data
    private String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decoded = Base64.getDecoder().decode(encryptedData);
            return new String(cipher.doFinal(decoded));
        } catch (GeneralSecurityException e) {
            System.out.println("Error decrypting data: " + e.getMessage());
            return null;
        }
    }

    // Add user to HashSet and save to file
    public boolean addUser(String username, String password) {
        String encryptedPassword = encrypt(password);
        if (encryptedPassword == null) {
            System.out.println("Failed to add user due to encryption error.");
            return false;
        }
        User newUser = new User(username, encryptedPassword);
        users.add(newUser);
        return saveToFile();
    }

    // Save HashSet to file (encrypted)
    private boolean saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                writer.write(user.getUsername() + ":" + user.getPassword() + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
            return false;
        }
    }

    // Load from file and decrypt
    public boolean loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];
                String decryptedPassword = decrypt(parts[1]);
                if (decryptedPassword != null) {
                    users.add(new User(username, decryptedPassword));
                } else {
                    System.out.println("Error decrypting user data for username: " + username);
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error reading users from file: " + e.getMessage());
            return false;
        }
    }

    // Validate user
    public boolean validateUser(String username, String password) {
        String encryptedPassword = encrypt(password);
        if (encryptedPassword == null) {
            System.out.println("Failed to validate user due to encryption error.");
            return false;
        }
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(encryptedPassword)) {
                return true;
            }
        }
        return false;
    }
}
