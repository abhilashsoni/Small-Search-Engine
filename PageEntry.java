//package ass4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by abhilash on 29/9/16.
 */
public class PageEntry
{
    //to store the information related to webpage
    String name;
    PageIndex page = new PageIndex();

    PageEntry(String pageName)
    {
        BufferedReader pr = null;
        name = pageName;
        //page.index = Integer.parseInt(pageName);

        try
        {
            String actionString;
            System.out.println(name);
            pr = new BufferedReader(new FileReader(pageName));
            int i = 0;

            while ((actionString = pr.readLine()) != null)
            {
                if(actionString.equalsIgnoreCase("a") || actionString.equalsIgnoreCase("an") || actionString.equalsIgnoreCase("the") ||                     actionString.equalsIgnoreCase("they") || actionString.equalsIgnoreCase("these") || actionString.equalsIgnoreCase                       ("this")  || actionString.equalsIgnoreCase("for")  || actionString.equalsIgnoreCase("is") || actionString                               .equalsIgnoreCase("are") || actionString.equalsIgnoreCase("was") || actionString.equalsIgnoreCase("of") ||                              actionString.equalsIgnoreCase("or") || actionString.equalsIgnoreCase("and") || actionString.equalsIgnoreCase                             ("does") || actionString.equalsIgnoreCase("will") || actionString.equalsIgnoreCase("whose"));
                else
                {
                    Position temp1 = new Position(this,i);
                    page.addPositionForWord(actionString.toLowerCase(), temp1);
                }
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (pr != null)pr.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    PageIndex getPageIndex()
    {
        return page;
    }
}
