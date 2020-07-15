package stack;

public interface Stack<E> {
    void push(E e);

    boolean isEmpty();

    int getSize();

    E pop();

    E peek();


}
