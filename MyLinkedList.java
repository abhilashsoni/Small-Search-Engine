//package ass4;
import java.util.NoSuchElementException;

/**
 * Created by abhilash on 29/9/16.
 */
public class MyLinkedList<T>
{
    Node<T> front, rear;
    int size;
    Boolean isEmpty()
    {
        return (front==null);
    }

    void insert(T k)
    {
        Node<T> newnode = new Node<T>(k);
        if(front==null)
        {
            front = newnode;
            rear = newnode;
        }
        else
        {
            rear.link=newnode;
            rear = rear.link;
        }
        size++;
    }

    void remove(T n)
    { if(isEmpty()) throw new NoSuchElementException("Underflow Exception");
        Node<T> newnode = new Node<T>(n);
        if(front==newnode)
        {
            front=front.link;
            return;
        }
        Node<T> l=front;
        while(!(l.link==newnode))
        {
            l=l.link;
        }
        l.link=l.link.link;
    }

    Boolean isContain(T l)
    {
        Node<T> newnode = new Node<T>(l);
        Node<T> ref = front;
        while(ref!=null)
        {
            if(ref==l)
            return true;
            ref = ref.link;
        }
        return false;
    }

    void inter(MyLinkedList<T> n)
    {
        Node<T> ref = n.front;
        while(ref!=null)
        {
            if(isContain(ref.data)==true)
                insert(ref.data);
            ref = ref.link;
        }
    }

    void uni(MyLinkedList<T> n)
    {
        if(front==null)
        {
            Node<T> ref = n.front;
            while(ref!=null)
            {
                insert(ref.data);
                ref = ref.link;
            }
        }

        else
        {
            Node<T> ref = n.front;
            while(ref!=null)
            {
                if(isContain(ref.data)==false)
                insert(ref.data);
                ref = ref.link;
            }
        }
    }
}

class Node<T>
{
    T data;
    Node<T> link;

    Node(Node<T> a)
    {
        data =a.data;
        link = a.link;
    }

    Node(T a)
    {
        data = a;
    }
}
