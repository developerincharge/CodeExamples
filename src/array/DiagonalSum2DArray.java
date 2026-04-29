package array;

public class DiagonalSum2DArray {
    public static void main(String[] args) {
        int [][] numArr = ArrayUtility.input2DArray();
        long sumOfDiagonal = sumOfDiagonals(numArr);
        System.out.println("Diagonal Sum of 2D Array is : " + sumOfDiagonal);
    }
    // Diagonal Sums of 2D Array
    public static long sumOfDiagonals(int[][] numArr) {
       long leftSum = sumOfLeftDiagonals(numArr);
       long rightSum = sumOfRightDiagonals(numArr);
       int sum = (int) (leftSum + rightSum);
       if(numArr.length % 2 != 0) {
           int midIndex = numArr.length / 2;
           sum -= numArr[midIndex][midIndex];
       }
       return sum;
    }

    public static long sumOfLeftDiagonals(int[][] numArr) {
         long sum = 0;
         int i = 0;
         while(i < numArr.length) {
             sum += numArr[i][i];
             i++;
         }
        return sum;
    }

    public static long sumOfRightDiagonals(int[][] numArr) {
        long sum = 0;
        int i = 0;
        while(i < numArr.length) {
            int colIndex = numArr.length - 1 - i;
            sum += numArr[i][colIndex];
            i++;
        }
        return sum;
    }

}
