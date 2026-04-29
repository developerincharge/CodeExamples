package controlstatements;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number (1-7) to get the corresponding day of the week: ");
        int dayNumber = input.nextInt();
        //oldSwitch(dayNumber);
        newSwitch(dayNumber);

    }

     public static void newSwitch(int dayNumber){
         String dayOfWeek = switch (dayNumber) {
             case 1 -> "Monday";
             case 2 -> "Tuesday";
             case 3 -> "Wednesday";
             case 4 -> "Thursday";
             case 5 -> "Friday";
             case 6, 7 -> "Holiday";

             default -> "Value is invalid ! Please enter a number between 1 and 7.";
         };
         System.out.println("Today is " + dayOfWeek);
     }

      public static void oldSwitch(int dayNumber){
          String dayOfWeek;
          switch (dayNumber) {
              case 1:
                  dayOfWeek = "Monday";
                  System.out.println("Today is " + dayOfWeek);
                  break;
              case 2:
                  dayOfWeek = "Tuesday";
                  System.out.println("Today is " + dayOfWeek);
                  break;
              case 3:
                  dayOfWeek = "Wednesday";
                  System.out.println("Today is " + dayOfWeek);
                  break;
              case 4:
                  dayOfWeek = "Thursday";
                  System.out.println("Today is " + dayOfWeek);
                  break;
              case 5:
                  dayOfWeek = "Friday";
                  System.out.println("Today is " + dayOfWeek);
                  break;
              case 6:
                  dayOfWeek = "Saturday";
                  System.out.println("Today is " + dayOfWeek);
                  break;
              case 7:
                  dayOfWeek = "Sunday";
                  System.out.println("Today is " + dayOfWeek);
                  break;
              default:
                  dayOfWeek = "Value is invalid ! Please enter a number between 1 and 7.";
                  System.out.println(dayOfWeek);
          }
    }
}
