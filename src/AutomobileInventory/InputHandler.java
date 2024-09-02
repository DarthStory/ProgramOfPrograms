package AutomobileInventory;

import java.util.Scanner;

public class InputHandler {

    private static final int MAX_LENGTH = 15;

    public static String getUsername() {
        return getInput("Enter username (max 15 characters): ");
    }

    public static String getPassword() {
        return getInput("Enter password (max 15 characters): ");
    }

    @SuppressWarnings("resource")
    private static String getInput(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String input = "";
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            input = scnr.nextLine().trim();

            if (input.length() <= MAX_LENGTH) {
                valid = true;
            } else {
                System.out.println("Input exceeds maximum length of 15 characters. Please try again.");
            }
        }

        return sanitizeInput(input);
    }

    private static String sanitizeInput(String input) {
        // Allowing alphanumeric characters and specified symbols
        return input.replaceAll("[^a-zA-Z0-9~`!@#$%^&*()_\\-+={\\[\\]}|:;\"'<,>.?/]", "");
    }
    
}

