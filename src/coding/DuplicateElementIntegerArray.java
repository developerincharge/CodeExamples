package coding;

import java.util.ArrayList;

public class DuplicateElementIntegerArray {

    public static void main(String[] args) {

        int [] a = {5, 4, 2 , 3, 2, 1, 4, 5, 3};

//          for( int i = 0; i < a.length; i++ ){
//              for( int j = i+ 1;  j < a.length; j++){
//                if(a[i] == a[j]){
//                    System.out.print("  "+a[i]);
//                }
//              }
//          }

          ArrayList<Integer> list = new ArrayList<>();
          for(int i = 0; i < a.length; i++){
              if(list.contains(a[i])){
                  System.out.print("  "+a[i]);
              }else{
                  list.add(a[i]);
              }
          }
    }
}
