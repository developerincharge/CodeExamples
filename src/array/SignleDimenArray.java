package array;

public class SignleDimenArray {

    public static void main(String[] args) {
         // declaration
        // Approach 1
        /*
        int a[] = new int[5];
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[4] = 50;
        */


         // approach 2
        int a[] = {10, 20, 30, 40, 50, 60};
        for(int x : a){
            System.out.println(x);
        }
    }
}
