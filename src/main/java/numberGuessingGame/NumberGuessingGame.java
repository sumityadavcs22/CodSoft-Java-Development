package numberGuessingGame;

import java.util.Random;
import java.util.Scanner;


public class NumberGuessingGame {
    private int secretNumber;
    private final int maxAttempts;
    private int attempts;
    private int score;
    private int roundsWon;
    private int totalAttempts;

    public NumberGuessingGame() {
        this.maxAttempts = 6;
        this.attempts = 0;
        this.roundsWon = 0;
        this.totalAttempts = 0;

    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            System.out.println("Welcome to the Number Guessing Game ");
            System.out.println("------------------------------------");
            this.secretNumber = random.nextInt(100) + 1;
            this.attempts = 0;
            while (this.attempts < this.maxAttempts) {
                System.out.print("Enter the guess(1-100): ");
                int guessNumber = scanner.nextInt();
                this.attempts++;
                this.totalAttempts++;
                if (guessNumber == this.secretNumber) {
                    System.out.println("Congratulations! You have guessed the correct number");
                    this.score++;
                    this.roundsWon++;
                    break;
                } else if (guessNumber > this.secretNumber) {
                    System.out.println("Your guess is too high.Try again");
                } else {
                    System.out.println("Your guess is too low.Try again");
                }
                if (this.attempts == this.maxAttempts) {
                    System.out.println("Sorry! you didn't guess the number.It was " + this.secretNumber + ".");
                }
                System.out.println("Do you want to play again.? (y/n): ");
                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("n")) {
                    break;
                }

            }
            System.out.println("-------------------------------");
            System.out.println("Your final score is " + this.score + " out of " + this.roundsWon + " rounds.");
            System.out.println("You took an average of " + (double) this.totalAttempts / this.roundsWon + " attempts per round.");
        }
    }

    public static class Main {
        public static void main(String[] args) {
            NumberGuessingGame numberGuessingGame = new NumberGuessingGame();
            numberGuessingGame.playGame();
        }
    }
}
