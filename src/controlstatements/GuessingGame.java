package controlstatements;

import java.util.Scanner;

public class GuessingGame {
      int random;
      GuessingGame(){
            random = (int) Math.ceil(Math.random() * 100) + 1;
      }

    /**
     * Compares the guess number with the random number and returns:
     * -1 if the guess number is less than the random number
     * 1 if the guess number is greater than the random number
     * 0 if the guess number is equal to the random number
     * @param guessNumber the number guessed by the user
     * @return -1, 0, or 1 based on the comparison of guessNumber and random
     */

      int guess(int guessNumber){
            if(guessNumber < random){
                  return -1;
            } else if(guessNumber > random){
                  return 1;
            } else {
                  return 0;
            }
      }
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            GuessingGame game = new GuessingGame();
            System.out.println("Guess the number between 1 and 100\n");
            int guess = 0;
            int result = 0;
            do {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();
                result = game.guess(guess);
                if (result < 0) {
                    System.out.println("Too low! Try again.");
                } else if (result > 0) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number.");
                }

            } while(result != 0);

//            int number = (int) (Math.random() * 10) + 1;
//            int guess = 0;
//
//            while(guess != number){
//                System.out.println("Guess the number between 1 and 10");
//                guess = input.nextInt();
//
//                if(guess < number){
//                    System.out.println("Too low! Try again.");
//                } else if(guess > number){
//                    System.out.println("Too high! Try again.");
//                } else {
//                    System.out.println("Congratulations! You guessed the number.");
//                }
//            }
        }
}
