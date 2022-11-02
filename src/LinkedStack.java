import java.util.Stack;

public class LinkedStack<E> extends Stack<E>
{
    private final SinglyLinkedList<E> list;

    public LinkedStack()
    {
        list = new SinglyLinkedList<>();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public E push(E element)
    {
        list.addFirst(element);
        return element;
    }

    public E peek()
    {
        return list.first();
    }

    public E pop()
    {
        return list.removeFirst();
    }
}
