//package ass4;

/**
 * Created by abhilash on 1/10/16.
 */
public class InvertedPageIndex
{
    MyHashTable hash = new MyHashTable();
    void addPage(PageEntry p)
    {
        hash.insertpage(p);
    }

    MySet<PageEntry> getPagesWhichContainWord(String str)
    {
        MySet<PageEntry> temp3 = new MySet<PageEntry>();
        int j = hash.geti(str);
        Box temp5 = hash.wordentries[j];
        while(temp5!=null)
        {
            if (temp5.ent.word.equalsIgnoreCase(str))
            {
                temp5.ent.getAllPostionsForThisWord();
                Node<Position> temp10 = temp5.ent.entries.front;
                while(temp10!=null)
                {
                    if(temp3.set.isContain(temp10.data.pe))
                    {
                        temp3.addElement(temp10.data.pe);
                    }
                    temp10 = temp10.link;
                }
            }
            else
            {
                temp5 = temp5.next;
            }
        }
        return temp3;
    }
}
