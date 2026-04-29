package array;

public class SumAverage2DArray {
    public static void main(String[] args) {
        int [][] numArray = ArrayUtility.input2DArray();
        long sum = sum(numArray);
        double average = average(numArray);
        System.out.println("Sum of 2D Array is : " + sum);
        System.out.println("Average of 2D Array is : " + average);
    }

      public static double average(int[][] numArr){
         if(numArr.length == 0){return 0;}
           int rows = numArr.length;
           int columns = numArr[0].length;
           double size = rows * columns;

         return  sum(numArr ) / size;
      }

      public static long sum(int[][] numArr){
        long sum = 0;
        int i = 0;
        while(i < numArr.length){
            int j = 0;
            while(j < numArr[i].length){
                sum += numArr[i][j];
                j++;
            }
            i++;
        }
         return  sum;
      }
}
