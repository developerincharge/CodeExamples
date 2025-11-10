package coding;

class ReverseSolution1 {
    public int reverse(int x) {
        try {
            String reversed = new StringBuilder(Integer.toString(Math.abs(x)))
                                .reverse()
                                .toString();
            int result = Integer.parseInt(reversed);
            return x < 0 ? -result : result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseSolution1 result = new ReverseSolution1();
        
        // Test cases
        int[] testCases = {123, -123, 120, 0, 1534236469, -2147483648, 901000};
        
        System.out.println("Testing reverse method:");
        for (int num : testCases) {
            int reversed = result.reverse(num);
            System.out.println("reverse(" + num + ") = " + reversed);
        }
    }
}