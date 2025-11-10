package coding;

class ReverseSolution2 {
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
        ReverseSolution2  result = new ReverseSolution2();
        
        // Test cases with expected results
        int[][] testCases = {
            {123, 321},
            {-123, -321},
            {120, 21},
            {0, 0},
            {1534236469, 0},  // Overflow case
            {-2147483648, 0}, // Overflow case
            {901000, 109}
        };
        
        System.out.println("Testing Integer Reverse Method:");
        System.out.println("=================================");
        
        for (int[] testCase : testCases) {
            int input = testCase[0];
            int expected = testCase[1];
            int actual = result.reverse(input);
            
            String status = (actual == expected) ? "✓ PASS" : "✗ FAIL";
            System.out.printf("%s reverse(%11d) = %11d (Expected: %11d)%n", 
                            status, input, actual, expected);
        }
    }
}