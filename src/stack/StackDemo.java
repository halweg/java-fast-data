package stack;

public class StackDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i=0; i<10; i++) {
            stack.push(i);
        }

        System.out.println(stack.pop());

        System.out.println(stack.toString());
    }
}
