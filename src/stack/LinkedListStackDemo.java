package stack;

import LinkedList.LinkedList;

public class LinkedListStackDemo {


    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i=0; i<10; i++) {
            stack.push(i);
        }

        System.out.println(stack.pop());

        System.out.println(stack.toString());
    }

}

