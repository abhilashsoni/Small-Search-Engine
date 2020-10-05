//package ass4;

/**
 * Created by abhilash on 29/9/16.
 */

public class MySet<T>
{
    MyLinkedList<T> set = new MyLinkedList<T>();

    void addElement(T element)
    {
        //to add the element into the set
        set.insert(element);
    }

    MySet<T> union(MySet<T> otherSet)
    {
        //returns the union
        MySet<T> ret = new MySet<T>();
        ret.set.uni(set);
        ret.set.uni(otherSet.set);
        return ret;
    }

    MySet<T> intersection(MySet<T> otherSet)
    {
        //returns the intersection
        MySet<T> ret = new MySet<T>();
        ret.set.inter(set);
        ret.set.inter(otherSet.set);
        return ret;
    }
}
