package coding;

public class CountDigits {

    public static void main(String[] args) {

        int numbers = 1234567891;
        int count = 0;
        for (int temp = numbers; temp > 0; temp /= 10) {
              count++;
           //count += temp % 10;  // to sum all numbers
        }
        System.out.println("Total Number of digits  : "+count);
    }
}
