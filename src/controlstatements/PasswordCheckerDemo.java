package controlstatements;

import java.util.Scanner;

public class PasswordCheckerDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        String result = checkPassword(password);
        System.out.println(result);


    }

    public static String checkPassword(String password) {
        if (password.length() < 8) {
            return "Password is too short. It must be at least 8 characters long.";
        } else if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter.";
        } else if (!password.matches(".*[a-z].*")) {
            return "Password must contain at least one lowercase letter.";
        } else if (!password.matches(".*\\d.*")) {
            return "Password must contain at least one digit.";
        } else if (!password.matches(".*[!@#$%^&*()].*")) {
            return "Password must contain at least one special character (e.g., !@#$%^&*()).";
        } else {
            return "Password is strong.";
        }
    }
}
