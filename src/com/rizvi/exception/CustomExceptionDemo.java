package com.rizvi.exception;

public class CustomExceptionDemo {
    public static void main(String[] args) {

        try {
            checkNumber(-5);
        } catch (NegativeNumberException e) {
            System.out.println("Caught Exception : "+e.getMessage());
        }
    }

    public static void checkNumber(int number) throws NegativeNumberException {
        if(number < 0){
            throw new NegativeNumberException("Number can not be Negative");
        }
        System.out.println("Number is Valid  "+number);
    }
}
