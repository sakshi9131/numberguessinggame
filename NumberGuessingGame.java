import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;

            System.out.println("Round " + (++rounds));
            System.out.println("Guess a number between 1 and 100. You have 10 attempts.");

            while (attempts < 10) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You won this round in " + attempts + " attempts.");
                    won = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!won) {
                System.out.println("You lost this round. The number was " + numberToGuess);
            }

            score += won ? 1 : 0;
            System.out.println("Score: " + score + " out of " + rounds);

            System.out.print("Play again? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}