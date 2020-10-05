//package ass4;

/**
 * Created by abhilash on 29/9/16.
 */
public class Position
{
    PageEntry pe;
    int wordposition;

    Position(PageEntry p, int wordIndex)
    {
        pe=p;
        wordposition = wordIndex;
    }

    PageEntry getPageEntry()
    {
        return pe;
    }

    int getWordIndex()
    {
        return wordposition;
    }
}
