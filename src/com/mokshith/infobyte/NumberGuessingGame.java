package com.mokshith.infobyte;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int totalRounds = 3;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        for (int round = 1; round <= totalRounds; round++) {

            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n========== ROUND " + round + " ==========");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {

                    System.out.println("🎉 Correct! You guessed the number.");

                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;

                    System.out.println("Attempts Used: " + attempts);
                    System.out.println("Round Score: " + roundScore);

                    guessedCorrectly = true;
                    break;

                } else if (guess < randomNumber) {
                    System.out.println("The number is HIGHER.");
                } else {
                    System.out.println("The number is LOWER.");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou have used all attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }
        }

        System.out.println("\n=================================");
        System.out.println("            GAME OVER");
        System.out.println("=================================");
        System.out.println("Total Score: " + totalScore);

        if (totalScore >= 150) {
            System.out.println("Excellent Performance!");
        } else if (totalScore >= 80) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Keep Practicing!");
        }

        scanner.close();
    }
}