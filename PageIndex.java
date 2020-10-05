//package ass4;

/**
 * Created by abhilash on 29/9/16.
 */
public class PageIndex
{
    MyLinkedList<WordEntry> words = new MyLinkedList<>();
    //int index;

    void addPositionForWord(String str, Position p)
    {
        WordEntry w = new WordEntry(str);
        if(words.isContain(w)==false)
        {
            words.insert(w);
        }

            Node<WordEntry> temp = words.front;
            while(temp!=null)
            {
                if(temp.data.word.equalsIgnoreCase(str))
                {
                    temp.data.addPosition(p);
                    return;
                }
                temp=temp.link;
            }

    }

    MyLinkedList<WordEntry> getWordEntries()
    {
        return words;
    }
}
