//package ass4;

/**
 * Created by abhilash on 29/9/16.
 */
public class WordEntry
{
    MyLinkedList<Position> entries = new MyLinkedList<Position>();
    String word;

    WordEntry(String a)
    {
        word = a;
    }

    void addPosition(Position position)
    {
        entries.insert(position);
    }

    void addPositions(MyLinkedList<Position> positions)
    {
        Node<Position> p = positions.front;
        while(p!=null)
        {
            entries.insert(p.data);
            p=p.link;
        }
    }
    MyLinkedList<Position> getAllPostionsForThisWord()
    {
        return entries;
    }
}
