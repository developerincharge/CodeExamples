package array;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] numArray = ArrayUtility.inputArray();
        boolean isIncreasing = isIncreasing(numArray);
        boolean isDecreasing = isDecreasing(numArray);
        if (isIncreasing || isDecreasing) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }

public static boolean isDecreasing(int[] numArr){
    int i = 1;
    while (i < numArr.length) {
        if (numArr[i] > numArr[i - 1]) {
            return false;
        }
        i++;
    }
    return true;
}

    public static boolean isIncreasing(int[] numArr) {
        int i = 1;
        while (i < numArr.length) {
            if (numArr[i] < numArr[i - 1]) {
               return false;
            }
            i++;
        }
        return true;
    }
}
