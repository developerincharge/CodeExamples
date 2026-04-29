package array;

public class TwoDimentionalArrow {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5},
                {7, 8, 9}
        };

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (i == j) {
//                    System.out.print(arr[i][j] + " ");
//                } else if (i + j == arr.length - 1) {
//                    System.out.print(arr[i][j] + " ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }

        int i = 0;
        while(i < arr.length){
            int j = 0;
            while(j < arr[i].length) {

                System.out.print(arr[i][j] + " ");
                  j++;
            }
            System.out.println();
            i++;
        }
    }
}
