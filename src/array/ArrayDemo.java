package array;

public class ArrayDemo {

    public static void main(String[] args) {
                     //single array
        int [] numbers = {10, 20, 30, 40, 50};
                    // multi dimensional array
        int [][] matrix = { {1, 2, 3},
                            {4, 5, 6 },
                            {7, 8, 9}
        };



        System.out.println("First array - Index Value:   "+numbers[0]);
        System.out.println("Second array - Index Value:  "+numbers[1]);
        System.out.println("Third array - Index Value:   "+numbers[2]);
        System.out.println("Fourth array - Index Value:  "+numbers[3]);

        System.out.print("All Numbers:  ");
        for(int i = 0; i < numbers.length; i++){
            System.out.print(" "+ numbers[i]);
        }
        System.out.println();

        System.out.println(" Element at this position of matrix[0][0] is : "+matrix[0] [0]);
        System.out.println(" Element at this position of matrix[1][2] is : "+matrix[1] [2]);
        System.out.println(" Element at this position of matrix[2][1] is : "+matrix[2] [1]+"\n");

        System.out.println("Printing Element of multi dimensional Array");

          for(int i = 0; i < matrix.length; i++){
              for(int j = 0; j < matrix[i].length; j++){
                  System.out.print(" "+matrix[i][j]);
              }
              System.out.println();
          }


    }
}
