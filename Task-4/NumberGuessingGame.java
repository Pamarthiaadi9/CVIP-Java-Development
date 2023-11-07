import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1; // Minimum number in the range
        int upperBound = 100; // Maximum number in the range
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");
        
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt();
            attempts++;
            
            if (playerGuess < lowerBound || playerGuess > upperBound) {
                System.out.println("Invalid guess. Please guess between " + lowerBound + " and " + upperBound + ".");
            } else if (playerGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (playerGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }
        
        scanner.close();
    }
}
