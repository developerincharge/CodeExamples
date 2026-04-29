package controlstatements;

import java.util.Scanner;

public class StudentScoreTernary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the student's score: ");
        int score = input.nextInt();

        String category = (score >= 90) ? "Excellent" :
                          (score >= 80) ? "Good" :
                          (score >= 70) ? "Average" :
                          (score >= 60) ? "Pass" :
                          (score >= 50) ? "Low" :
                          (score >= 40) ? "retake": "Fail";



//        String category = score > 80 ? "High" : (score >= 50 ? "Medium" : "Low");
        System.out.println("The student's performance is: " + category);
    }
}
