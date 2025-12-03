package array;

import java.util.Stack;

public class StackDemo {


    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        System.out.println("Stack after Push "+stack);
        System.out.println("Top Element after Push "+stack.peek());
        System.out.println("Remove the Top Element "+stack.pop());
        System.out.println("Stack after removal of top element "+stack);

    }
}