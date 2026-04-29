package coding;

public class PrimeNumbers {

    public static void main(String[] args) {
   int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29,
            30,31 ,32 ,33 ,34 ,35 ,36 ,37 ,38 ,39 ,40 ,
            41 ,42 ,43 ,44 ,45 ,46 ,47 ,48 ,49 ,50};

        for(int num = 2; num<=numbers.length; num++){
            boolean isPrime = true;
            for(int i=2; i <= num/2; i++ ){
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(num + "  is Prime Numbers :");
            }else{
                System.out.println(num + "  is not Prime Numbers :");
            }
        }
    }
}
