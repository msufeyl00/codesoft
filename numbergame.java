import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class numbergame {

    public static int playRound(Scanner scanner) {
        int lowerBound = 1;
        int upperBound = 100;
        Random random = new Random();
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound; 
        int maxAttempts = 7; 
        int attemptsTaken = 0;

        System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attemptsTaken < maxAttempts) {
            int guess;
            System.out.print("Attempt " + (attemptsTaken + 1) + "/" + maxAttempts + ": Enter your guess: ");
            try {
                guess = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
                continue; 
            }

            attemptsTaken++;

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("\nCongratulations! You guessed the number " + secretNumber + " in " + attemptsTaken + " attempts!");
                return attemptsTaken; 
            }
        }

        System.out.println("\nSorry, you ran out of attempts! The number I was thinking of was " + secretNumber + ".");
        return -1; // Indicate loss
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRoundsPlayed = 0;
        int roundsWon = 0;
        int totalAttemptsForWins = 0;

        System.out.println("Welcome to the 'Guess the Number' game!");

        while (true) {
            totalRoundsPlayed++;
            int attemptsThisRound = playRound(scanner);

            if (attemptsThisRound != -1) {
                roundsWon++;
                totalAttemptsForWins += attemptsThisRound;
                System.out.println("Current Score: Rounds Won: " + roundsWon + ", Total Attempts in Wins: " + totalAttemptsForWins);
            } else {
                System.out.println("Current Score: Rounds Won: " + roundsWon);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Final Score: You played " + totalRoundsPlayed + " rounds and won " + roundsWon + " of them.");
        if (roundsWon > 0) {
            System.out.printf("Your average attempts per win: %.2f%n", (double) totalAttemptsForWins / roundsWon);
        } else {
            System.out.println("You didn't win any rounds this time.");
        }

        scanner.close(); 
    }
}