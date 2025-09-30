package com.nit.bank;

import java.util.Random;

public class RandomStringGenerator {
    public static String generateRandomString(String input) {
        // Generate a random 6-digit number
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000); // Ensures a 6-digit number

        // Take the first 6 letters from the input string
        String prefix = input.length() >= 6 ? input.substring(0, 6) : input;

        // Combine the prefix and the random number
        return prefix + randomNumber;
    }

    public static void main(String[] args) {
        // Example usage
        String input = "parmeshwar";
        String result = generateRandomString(input);
        System.out.println("Generated String: " + result);
    }
}
