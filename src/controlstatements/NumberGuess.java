package controlstatements;

import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberToGuess = 1 + (int)(Math.random() * 50); // Generate a random number between 1 and 50
        int guess;
        System.out.println("Welcome to the Number Guessing Game!");

        do{
            System.out.print("Enter your guess between 1 and 50: ");
            guess = input.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number!");
                break; // Exit the loop when the correct number is guessed
            }

        } while (numberToGuess != guess); // Loop will continue until the correct number is guessed
    }
}
