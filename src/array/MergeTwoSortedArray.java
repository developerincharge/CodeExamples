package array;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = ArrayUtility.inputArray();
        int[] arr2 = ArrayUtility.inputArray();

        int[] mergedArray = mergeSortedArrays(arr1, arr2);

        System.out.println("Merged Array:");
        ArrayUtility.displayArray(mergedArray);
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
       int newSize = arr1.length + arr2.length;
        int[] newArray = new int[newSize];

        int i = 0, j = 0, k = 0;
        while (i < arr1.length || j < arr2.length) {
            if (j == arr2.length ||
                    (i < arr1.length && arr1[i] < arr2[j])) {
                newArray[k] = arr1[i];
                k++;
                i++;
            } else {
                newArray[k] = arr2[j];
                k++;
                j++;
            }
        }

        return newArray;
    }
}
