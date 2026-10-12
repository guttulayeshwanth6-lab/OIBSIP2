import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        int totalAttempts = 0;
        String playAgain;

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            // Generate random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;

            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                // Check whether input is a number
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too Low!");

                } else if (guess > randomNumber) {
                    System.out.println("Too High!");

                } else {
                    System.out.println("Correct!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    guessedCorrectly = true;
                    totalAttempts += attempts;
                    break;
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            // If player did not guess correctly
            if (!guessedCorrectly) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + randomNumber);
            }

            // Display round result
            if (guessedCorrectly) {
                System.out.println("Round " + round
                        + " completed successfully.");
            } else {
                System.out.println("Round " + round
                        + " completed.");
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next();

            round++;

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n=================================");
        System.out.println("          GAME OVER");
        System.out.println("=================================");
        System.out.println("Total rounds played: " + (round - 1));
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}