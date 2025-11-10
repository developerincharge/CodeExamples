package coding;

public class ReverseSolution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow before actually multiplying
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            rev = rev * 10 + digit;
        }
        
        return rev;
    }

    public static void main(String[] args) {
        ReverseSolution result = new ReverseSolution();
        
        // Test cases
        int[] testCases = {123, -123, 120, 0, 1534236469, -2147483648, 901000};
        
        for (int num : testCases) {
            int reversed = result.reverse(num);
            System.out.println("reverse(" + num + ") = " + reversed);
        }
    }
}