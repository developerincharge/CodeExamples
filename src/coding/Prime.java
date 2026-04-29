package coding;

import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Is " + num + " a prime number? " + (isPrime(num) ? "Prime" : "Not Prime"));

//        boolean isPrime = isPrime(num);
//        if(isPrime){
//            System.out.println("Is " +num + "  is Prime Number? : "+ isPrime(num));
//            System.out.println("As " +num + "  is a Prime Number ");
//        }else{
//            System.out.println("Is " + num + " a prime number? " + isPrime(num));
//            System.out.println("As " +num + "  is not Prime Number ");
//
//        }

    }

      public static boolean isPrime(int num) {
//          if (num <= 1) {
//              return false; // 0 and 1 are not prime
//          }
//          for (int i = 2; i <= Math.sqrt(num); i++) {
//              if (num % i == 0) {
//                  return false; // Found a divisor, not prime
//              }
//          }

          // Using for loop

//          int i = 2;
//          while(i < num) {
//              if (num % i == 0) {
//                  return false; // Found a divisor, not prime
//              }
//              i++;
//          }

//            int i = 2;
//            do {
//                if (num % i == 0) {
//                    return false; // Found a divisor, not prime
//                }
//                i++;
//            } while (i < num);
//      return true; // No divisors found, it's prime

          for(int i=2; i<=num; i++) {
              if(num % i == 0){
                  return false; // Found a divisor, not prime
              }
          }
          return true; // No divisors found, it's prime
      }
}


