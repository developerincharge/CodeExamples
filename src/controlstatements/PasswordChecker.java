package controlstatements;

import java.util.Scanner;

class PasswordChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String password;
      do{
          System.out.print("Enter your password:  ");
          password = input.next();

        }while (!isValidPassword(password));
            System.out.println("Password is valid. Access granted.");

    }

    public static boolean isValidPassword(String password) {

        // At least one special character
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") && // At least one uppercase letter
                password.matches(".*[a-z].*") && // At least one lowercase letter
                password.matches(".*\\d.*") &&   // At least one digit
                password.matches(".*[@#$%^&+=].*");

    }
}
