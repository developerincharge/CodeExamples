package generics;

public class GenericDataTypeDemo {

    public static <T> void printArray(T[] array){
        for(T element : array){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

     Integer[] inArray = {1, 2, 3, 4, 5};
     String[] strArray = {"Hello", "Java", "Generics", "Is", "Fun"};

        System.out.println("Integer Array:  ");
        printArray(inArray);

        System.out.println("String Array:  ");
        printArray(strArray);


    }
}
