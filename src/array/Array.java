package array;

public class Array {
    public static void main(String[] args) {
        int arr[] = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        System.out.print("All Numbers in Array:  ");
        int index = 0;

//        for(int i = 0; i < arr.length; i++){
//            System.out.print(" "+ arr[i]);
//        }
     // Array Traversal using while loop
        while(index < arr.length){
            System.out.print(" "+ arr[index]);
            index++;
        }

        String[] strArr = new String[4];
        strArr[0] = "My String";
        strArr[1] = "Hello World";
        strArr[2] = "Java Programming";
        strArr[3] = "Array of Strings";

        System.out.print("\nAll Strings in String Array:  ");
            index = 0;
        while(index < strArr.length){
            System.out.print(", "+ strArr[index]);
            index++;

        }
    }
}
