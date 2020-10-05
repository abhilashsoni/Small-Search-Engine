//package ass4;

/**
 * Created by abhilash on 30/9/16.
 */
public class MyHashTable
{
    Box[] wordentries = new Box[101];

    private int getHashIndex(String str)
    {
        String temp2 = str.toLowerCase();
        int s = 0;
        for(int i=0; i<temp2.length(); i++)
        {
            s = s + (int)temp2.charAt(i);
        }
        return (s%101);
    }

    void addPositionsForWord(WordEntry w)
    {
        int z = getHashIndex(w.word);
        Box temp9 = wordentries[z];
        while(temp9!=null)
        {
            if (temp9.ent.word.equalsIgnoreCase(w.word))
            {
                temp9.ent.addPositions(w.entries);
                return;
            }
            else
            {
                temp9 = temp9.next;
            }
        }
        Box t = new Box();
        t.next = null;
        t.ent = w;
        temp9 = t;
    }

    void insertpage(PageEntry p)
    {
        Node<WordEntry> temp7 = p.page.words.front;
        while(temp7!=null)
        {
            int k = getHashIndex(temp7.data.word);
            /*if(wordentries[k].ent.word.equalsIgnoreCase(temp7.data.word))
            {
                Node<Position> temp8 = temp7.data.entries.front;
                while(temp8!=null)
                {
                    wordentries[k].ent.entries.insert(temp8.data);
                    temp8=temp8.link;
                }
            }*/
            addPositionsForWord(temp7.data);
            temp7 = temp7.link;
        }
    }

    int geti(String str)
    {
        int i = getHashIndex(str);
        return i;
    }
}

class Box
{
    WordEntry ent;
    Box next;
}
