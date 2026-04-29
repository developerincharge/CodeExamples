package array;

public class ReverseArray {
    public static void main(String[] args) {

        int [] numArr = ArrayUtility.inputArray();
        System.out.println("Original Array: ");
        ArrayUtility.displayArray(numArr);
        reverse(numArr);
        System.out.println("Reversed Array: ");
        ArrayUtility.displayArray(numArr);
    }

    public static void reverse(int[] arr){
            int i = 0;
            while(i < arr.length/2){
                int swap = arr[i];
                arr[i] = arr[(arr.length - 1) - i];
                arr[arr.length - 1 - i] = swap;
                i++;
            }
    }
}
